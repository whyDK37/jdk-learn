package juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                completableFuture.complete("a");
            }
        });

        CompletableFuture<String> stringCompletableFuture = completableFuture.whenCompleteAsync((s, throwable) -> System.out.println("complete " + s))
                .whenComplete((s, throwable) -> System.out.println("complete 2 " + s));

        thread.start();

        TimeUnit.SECONDS.sleep(2);
    }
}
