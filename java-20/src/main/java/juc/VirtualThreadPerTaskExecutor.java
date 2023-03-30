package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadPerTaskExecutor {
    public static void main(String[] argv) throws InterruptedException {
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 100; i++) {
            final int num = i;
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + ", " + num));
        }

        executorService.shutdown();

        TimeUnit.SECONDS.sleep(2);
    }
}