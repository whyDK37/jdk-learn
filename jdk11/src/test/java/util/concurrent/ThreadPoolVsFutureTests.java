package util.concurrent;

import com.google.common.base.Stopwatch;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * 多线程对比，多线程开异步 vs 多线程直接运行
 **/
public class ThreadPoolVsFutureTests {

  @Test
  @SuppressWarnings("unchecked")
  public void introFutureHell() {
    CompletableFuture<List<String>> ids = ifhIds();

    CompletableFuture<List<String>> result = ids.thenComposeAsync(l -> {
      Stream<CompletableFuture<String>> zip = l.stream().map(i -> {
        CompletableFuture<String> nameTask = ifhName(i);
        CompletableFuture<Integer> statTask = ifhStat(i);

        return nameTask
            .thenCombineAsync(statTask, (name, stat) -> "名称：" + name + " 状态：" + stat); // <6>
      });
      List<CompletableFuture<String>> combinationList = zip.collect(Collectors.toList());
      CompletableFuture<String>[] combinationArray = combinationList
          .toArray(new CompletableFuture[combinationList.size()]);

      CompletableFuture<Void> allDone = CompletableFuture.allOf(combinationArray);
      return allDone.thenApply(v -> combinationList.stream().map(CompletableFuture::join)
          .collect(Collectors.toList()));
    });

    List<String> results = result.join();
    System.out.println(results.toString());
  }

  int threadCount = 16;
  private final ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);

  @Test
  public void testFuture() throws InterruptedException {
    Stopwatch started = Stopwatch.createStarted();
    final CountDownLatch cdTest = new CountDownLatch(threadCount);
    Runnable runnable = () -> {
      try {
        test();
      } finally {
        cdTest.countDown();
      }
    };

    for (int i = 0; i < threadCount; i++) {
      threadPool.submit(runnable);
    }
    cdTest.await();
    started.stop();
    System.out.println("all done:" + started.elapsed(TimeUnit.MILLISECONDS));

    started = Stopwatch.createStarted();
    final CountDownLatch cdDirect = new CountDownLatch(threadCount);
    Runnable direct = () -> {
      try {
        testDirect();
      } finally {
        cdDirect.countDown();
      }
    };
    for (int i = 0; i < threadCount; i++) {
      threadPool.submit(direct);
    }
    cdDirect.await();
    started.stop();
    System.out.println("all done:" + started.elapsed(TimeUnit.MILLISECONDS));
  }


  private void test() {
    CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
      int fib = fib(45);
      return 100;
    });
    CompletableFuture.allOf(future1).join();
  }

  private void testDirect() {
    int fib = fib(40);
  }

  private CompletableFuture<String> ifhName(String id) {
    CompletableFuture<String> f = new CompletableFuture<>();
    f.complete(id);
    return f;
  }

  private CompletableFuture<Integer> ifhStat(String id) {
    CompletableFuture<Integer> f = new CompletableFuture<>();
    f.complete(id.length() + 100);
    return f;
  }

  private CompletableFuture<List<String>> ifhIds() {
    CompletableFuture<List<String>> ids = new CompletableFuture<>();
    ids.complete(Arrays.asList(" jd", " jd1", " jd2", " jd3", " jd4"));
    return ids;
  }

  @Test
  public void fibTest() {
    System.out.println(fib(45));
  }

  public int fib(int N) {
    if (N <= 1) {
      return N;
    }
    return fib(N - 1) + fib(N - 2);
  }
}
