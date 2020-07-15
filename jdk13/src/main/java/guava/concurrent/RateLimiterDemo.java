package guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class RateLimiterDemo {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(1);
        acquire(limiter);
        System.out.println("limiter.getRate() = " + limiter.getRate());
        limiter.setRate(10);
        acquire(limiter);

        final RateLimiter rateLimiter = RateLimiter.create(2.0, 1000L, TimeUnit.MILLISECONDS);
    }

    private static void acquire(RateLimiter limiter) {
        for (int i = 1; i < 10; i = i + 2) {
            double waitTime = limiter.acquire(i);
            System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
        }
    }
}
