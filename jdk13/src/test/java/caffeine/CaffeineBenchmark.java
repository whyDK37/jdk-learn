package caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.cache.CacheBuilder;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

public class CaffeineBenchmark {

  @State(Scope.Benchmark)
  public static class CacheState {

    com.google.common.cache.Cache<String, String> cache;
    Cache<String, String> caffeineCache;

    ThreadLocal<Random> cacheRandom = ThreadLocal.withInitial(Random::new);
    ThreadLocal<Random> caffeineCacheRandom = ThreadLocal.withInitial(Random::new);

    @Setup(Level.Iteration)
    public void setup() throws Exception {
      caffeineCache = Caffeine.newBuilder()
          //5秒没有读写自动删除
          .expireAfterAccess(1, TimeUnit.HOURS)
          //最大容量1024个，超过会自动清理空间
          .maximumSize(10000)
//        .removalListener(((key, value, cause) -> {
//          //清理通知 key,value ==> 键值对   cause ==> 清理原因
//        }))
          .build();
      cache = CacheBuilder.newBuilder()
          .expireAfterAccess(1, TimeUnit.HOURS)
          .maximumSize(10000)
          .build();
    }
  }

  @Benchmark
  public void caffeineCacheBenchmark(CacheState cacheState) {
    String key = String.valueOf(cacheState.caffeineCacheRandom.get().nextInt());
    cacheState.caffeineCache.put(key, key);
  }

  @Benchmark
  public void guavaCacheBenchmark(CacheState cacheState) {
    String key = String.valueOf(cacheState.cacheRandom.get().nextInt());
    cacheState.cache.put(key, key);
  }

}
