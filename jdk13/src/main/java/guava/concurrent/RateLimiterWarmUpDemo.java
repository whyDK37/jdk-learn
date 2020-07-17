package guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class RateLimiterWarmUpDemo {
    public static void main(String[] args) {
        final RateLimiter limiter = RateLimiter.create(2.0, 2000L, TimeUnit.MILLISECONDS);

        acquire(limiter);
        System.out.println("limiter.getRate() = " + limiter.getRate());
        limiter.setRate(10);
        acquire(limiter);

    }

    private static void acquire(RateLimiter limiter) {
        for (int i = 1; i < 10; i = i + 2) {
            double waitTime = limiter.acquire(i);
            System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
        }
    }
}
