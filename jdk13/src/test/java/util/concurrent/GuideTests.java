package util.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * @program: concurrent
 * @description:
 * @author: wangdehui
 * @create: 2020-08-06 21:59
 **/
public class GuideTests {

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
//
//    @Test
//    public void introFutureHellReactorVersion() {
//        Flux<String> ids = ifhrIds();
//
//        Flux<String> combinations = ids.publishOn(Schedulers.elastic())
//                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x)).log()
//                .flatMap(id -> {
//                    System.out.println("--->" + Thread.currentThread().getName());
//                    Mono<String> nameTask = ifhrName(id);
//                    Mono<Integer> statTask = ifhrStat(id);
//                    return nameTask.zipWith(statTask, (name, stat) -> "名称：" + name + " 状态：" + stat).subscribeOn(Schedulers.parallel())
//                            .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x)).log();
//                });
//
//        System.out.println("===" + Thread.currentThread().getName());
//
//        Mono<List<String>> result = combinations.collectList();
//
//        List<String> results = result.block();
//
//        System.out.println("---->" + Thread.currentThread().getName());
//
//        System.out.println(results.toString());
//    }
//
//    @Test
//    public void introFutureHellReactorVersionReduce() {
//        Flux<Integer> ids = ifhrInt();
//
//        Flux<Integer> combinations = ids.publishOn(Schedulers.elastic()).flatMap(id -> {
//            return ifhrSum(id).subscribeOn(Schedulers.elastic());
//        });
//
//        Mono<List<Integer>> result = combinations.collectList();
//        System.out.println(result.toFuture().join());
//    }

  private final ExecutorService threadPool = Executors.newFixedThreadPool(4);

  @Test
  public void testFuture() {
    CountDownLatch ct = new CountDownLatch(32);
    Runnable finallyCallback = () -> {
      ct.countDown();
    };

    for (int i = 0; i < 32; i++) {
      int finalI = i;
      Runnable runnable = () -> {
        try {
          long start = System.currentTimeMillis();
          test(finalI);
          System.err.println(System.currentTimeMillis() - start);
        } finally {
          finallyCallback.run();
        }
      };
      threadPool.submit(runnable);

    }

    try {
      ct.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void test(int sum) {
    System.out.println("wdh-main--->" + Thread.currentThread().getName());
    Random rand = new Random();
    CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
      System.out.println("wdh-future1--->" + ForkJoinPool.commonPool().getPoolSize());
      System.out.println("wdh-future1--->" + Thread.currentThread().getName());
      try {
        Thread.sleep(10 + sum);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("future1完成");
      return 100;
    });
    CompletableFuture.allOf(future1).join();
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

//    private Flux<String> ifhrIds() {
//        return Flux.just(" jd", " jd1", " jd2", " jd3", " jd4");
//    }
//
//    private Flux<Integer> ifhrInt() {
//        return Flux.range(1, 10);
//    }
//
//    private Mono<String> ifhrName(String id) {
//        return Mono.just(id);
//    }
//
//    private Mono<Integer> ifhrSum(Integer id) {
//        return Mono.just(1 + id);
//    }
//
//    private Mono<Integer> ifhrStat(String id) {
//        return Mono.just(id.length() + 100);
//    }
}
