package guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class CaffeineBenchmark {

  @Test
  public void guavaCacheBenchmark() {
    Cache<String, String> cache = CacheBuilder.newBuilder()
        .expireAfterAccess(1, TimeUnit.HOURS)
        .maximumSize(10000)
        .build();

    for (int i = 0; i < 99999; i++) {
      cache.put("" + i, "" + i);
    }

  }

}
