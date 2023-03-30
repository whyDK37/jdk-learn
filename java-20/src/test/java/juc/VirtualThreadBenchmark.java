package juc;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class VirtualThreadBenchmark {

    private OkHttpClient client = null;

    @Setup
    public void init() {
        client = new OkHttpClient().newBuilder()
                .build();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testVirtualThread() throws Exception {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        Future<?> future = executor.submit(() -> {
        });
        future.get();
        executor.shutdown();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testThread() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<?> future = executor.submit(() -> {
        });
        future.get();
        executor.shutdown();
    }

    private void extracted() {
        Request request = new Request.Builder()
                .get()
                .url("http://www.baidu.com")
                .build();
        try {
            Response response = client.newCall(request).execute();
            response.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}