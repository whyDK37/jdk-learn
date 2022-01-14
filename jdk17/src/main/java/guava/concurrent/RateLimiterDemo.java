package guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

/**
 * This implements a "bursty" RateLimiter, where storedPermits are translated to zero throttling.
 * The maximum number of permits that can be saved (when the RateLimiter is unused) is defined in
 * terms of time, in this sense: if a RateLimiter is 2qps, and this time is specified as 10 seconds,
 * we can save up to 2 * 10 = 20 permits.
 */
public class RateLimiterDemo {

  public static void main(String[] args) {
    RateLimiter limiter = RateLimiter.create(1);
    limiter.acquire(5);
//    acquire(limiter);
//    System.out.println("limiter.getRate()  = " + limiter.getRate());
//    limiter.setRate(10);
//    acquire(limiter);
//
//    final RateLimiter rateLimiter = RateLimiter.create(2.0, 1000L, TimeUnit.MILLISECONDS);
  }

  private static void acquire(RateLimiter limiter) {
    for (int i = 1; i < 10; i = i + 2) {
      double waitTime = limiter.acquire(i);
      System.out
          .println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
    }
  }
}
