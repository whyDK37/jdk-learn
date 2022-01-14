package guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheDemo {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Cache<String, String> cache = CacheBuilder.newBuilder()
        .expireAfterAccess(Duration.ofSeconds(3))
        .recordStats()
        .maximumSize(100)
        .build();
    System.out.println(cache.getClass());
    cache.put("a", "AA");
    String value = cache.get("a", () -> "BB");
    System.out.println(value);
    TimeUnit.SECONDS.sleep(3);

    value = cache.get("a", () -> "BB");
    System.out.println(value);
  }

}
