package util.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class MyCompletableFuture<T> extends CompletableFuture<T> {
    static final Executor myExecutor = Executors.newFixedThreadPool(100);

    public <U> CompletableFuture<U> newIncompleteFuture() {
        return new MyCompletableFuture<U>();
    }

    public Executor defaultExecutor() {
        return myExecutor;
    }
}