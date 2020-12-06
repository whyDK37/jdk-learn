package caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

public class CaffeineBenchmark {

  @Benchmark
  @Warmup(iterations = 1, time = 2)
  @Fork(2)
  @BenchmarkMode(Mode.All)
  public void caffeineCacheBenchmark() {
    Cache<String, String> cache = Caffeine.newBuilder()
        //5秒没有读写自动删除
        .expireAfterAccess(1, TimeUnit.HOURS)
        //最大容量1024个，超过会自动清理空间
        .maximumSize(10000)
//        .removalListener(((key, value, cause) -> {
//          //清理通知 key,value ==> 键值对   cause ==> 清理原因
//        }))
        .build();

    for (int i = 0; i < 99999; i++) {
      cache.put("" + i, "" + i);
    }

  }


  @Benchmark
  @Warmup(iterations = 1, time = 2)
  @Fork(2)
  @BenchmarkMode(Mode.All)
  public void guavaCacheBenchmark() {
    com.google.common.cache.Cache<String, String> cache = CacheBuilder.newBuilder()
        .expireAfterAccess(1, TimeUnit.HOURS)
        .maximumSize(10000)
        .build();

    for (int i = 0; i < 99999; i++) {
      cache.put("" + i, "" + i);
    }

  }

}
