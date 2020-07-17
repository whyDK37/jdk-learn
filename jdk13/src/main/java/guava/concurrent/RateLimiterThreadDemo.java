package guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterThreadDemo {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(1);

        // 每一个线程都会取获取限流的请求，最终等待的时间会是
        for (int i = 0; i < 10; i++) {
            final Thread thread = getThread(limiter);
            thread.start();
        }
    }

    private static Thread getThread(RateLimiter limiter) {
        return new Thread(() -> {
            for (; ; ) {
                System.out.println(Thread.currentThread().getName() +
                        " limiter.acquire() = " + limiter.acquire());
            }
        });
    }
}
