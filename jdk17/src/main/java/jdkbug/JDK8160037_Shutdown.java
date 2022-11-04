package jdkbug;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * https://segmentfault.com/a/1190000042094218?utm_source=sf-similar-article
 * <p>
 * https://bugs.openjdk.org/browse/JDK-8160037
 */
public class JDK8160037_Shutdown {

    public static void main(String[] args) throws InterruptedException {

        // 1 create tem task
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            tasks.add(() -> {
                System.out.println("callable " + finalI);
                Thread.sleep(500);
                return null;
            });
        }

        // 2 submit to thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Thread executorInvokerThread = new Thread(() -> {
            try {
                executor.invokeAll(tasks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("invokeAll returned");
        });
        executorInvokerThread.start();

        // 3
        Thread.sleep(800);
        System.out.println("shutdown");


        executor.shutdown();// 任务会执行完
        System.out.println("Shutdown complete");


    }
}
