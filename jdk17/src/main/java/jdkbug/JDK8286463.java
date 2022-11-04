package jdkbug;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * https://bugs.openjdk.org/browse/JDK-8286463
 */
public class JDK8286463 {

    public static void main(String[] args) throws InterruptedException {

        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            tasks.add(() -> {
                System.out.println("callable " + finalI);
                Thread.sleep(500);
                return null;
            });
        }
        ExecutorService executor = new ThreadPoolExecutor(
                1,
                1,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardPolicy() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                        System.out.println("discardPolicy " + r.getClass());
                        FutureTask futureTask = (FutureTask) r;
                        futureTask.cancel(true);
                        super.rejectedExecution(r, e);
                    }
                }
        );
//        ExecutorService executor = Executors.newFixedThreadPool(2);
        Thread executorInvokerThread = new Thread(() -> {
            try {
                executor.invokeAll(tasks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("invokeAll returned");
        });
        executorInvokerThread.start();

        Thread.sleep(800);
        System.out.println("shutdown");
        List<Runnable> runnables = executor.shutdownNow();
        for (Runnable r : runnables) {
            System.out.println("r.getClass() = " + r.getClass());
            if (r instanceof Future) ((Future<?>) r).cancel(false);
        }
        System.out.println("Shutdown complete");
    }
}
