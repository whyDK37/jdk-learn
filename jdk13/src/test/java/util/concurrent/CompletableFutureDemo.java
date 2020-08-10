package util.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class CompletableFutureDemo {

  @Test
  public void supplyAsync() throws InterruptedException, ExecutionException {
    // 创建异步执行任务:
    CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureDemo::fetchPrice);
    System.out.println("cf = " + cf);
    // 如果执行成功:
    CompletableFuture<Void> voidCompletableFuture = cf.thenAccept((result) -> {
      System.out.println("price: " + result);
    });
    System.out.println("voidCompletableFuture = " + voidCompletableFuture);
    // 如果执行异常:
    CompletableFuture<Double> exceptionally = cf.exceptionally((e) -> {
      e.printStackTrace();
      return -1.0;
    });
    System.out.println("exceptionally = " + exceptionally);
    System.out.println("exceptionally.get() = " + exceptionally.get());
    // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
    Thread.sleep(200);
  }

  @Test
  public void thenApplyAsync() throws InterruptedException {
    // 第一个任务:
    CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> queryCode("中国石油"));

    // cfQuery成功后继续执行下一个任务:
    CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync(CompletableFutureDemo::fetchPrice);
    // cfFetch成功后打印结果:
    cfFetch.thenAccept((result) -> {
      System.out.println("price: " + result);
    });
    // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
    Thread.sleep(2000);
  }

  @Test
  public void anyOf() throws InterruptedException {
    // 两个CompletableFuture执行异步查询:
    CompletableFuture<String> cfQueryFromSina = CompletableFuture
        .supplyAsync(() -> queryCode("中国石油", "https://finance.sina.com.cn/code/"));
    CompletableFuture<String> cfQueryFrom163 = CompletableFuture
        .supplyAsync(() -> queryCode("中国石油", "https://money.163.com/code/"));

    // 用anyOf合并为一个新的CompletableFuture:
    CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

    // 两个CompletableFuture执行异步查询:
    CompletableFuture<Double> cfFetchFromSina = cfQuery
        .thenApplyAsync((code) -> fetchPrice((String) code, "https://finance.sina.com.cn/price/"));
    CompletableFuture<Double> cfFetchFrom163 = cfQuery
        .thenApplyAsync((code) -> fetchPrice((String) code, "https://money.163.com/price/"));

    // 用anyOf合并为一个新的CompletableFuture:
    CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

    // 最终结果:
    cfFetch.thenAccept((result) -> System.out.println("price: " + result));
    // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
    Thread.sleep(200);
  }

  @Test
  public void allOf() throws InterruptedException, ExecutionException {
    CompletableFuture<Void> allOf = CompletableFuture.allOf(
        CompletableFuture
            .supplyAsync(() -> {
              try {
                TimeUnit.MILLISECONDS.sleep(300L);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              System.out.println(300);
              return 300;
            }),
        CompletableFuture
            .supplyAsync(() -> {
              try {
                TimeUnit.MILLISECONDS.sleep(100L);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              System.out.println(100);
              return 100;
            })
    );

    CompletableFuture<String> stringCompletableFuture = allOf.thenApply(aVoid -> "全部完成");
    System.out.println(stringCompletableFuture.get());

    TimeUnit.SECONDS.sleep(2);


  }

  @Test
  public void executor() throws ExecutionException, InterruptedException {
    final ExecutorService executorService = Executors.newFixedThreadPool(10);

    CompletableFuture<String> cfQueryFromSina = CompletableFuture
        .supplyAsync(() -> queryCode("中国石油", "https://finance.sina.com.cn/code/"), executorService);
    CompletableFuture<String> cfQueryFrom163 = CompletableFuture
        .supplyAsync(() -> queryCode("中国石油", "https://money.163.com/code/"), executorService);

    CompletableFuture.allOf(cfQueryFromSina, cfQueryFrom163).join();
    System.out.println("all done.");
    System.out.println(cfQueryFromSina.get());
    System.out.println(cfQueryFrom163.get());

    ArrayList<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    System.out.println(Arrays.toString(list.toArray(new String[2])));
  }

  static String queryCode(String name) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
    }
    return "601857";
  }

  static Double fetchPrice(String code) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return 5 + Math.random() * 20;
  }

  static Double fetchPrice() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
    }
    if (Math.random() < 0.3) {
      throw new RuntimeException("fetch price failed!");
    }
    return 5 + Math.random() * 20;
  }

  static String queryCode(String name, String url) {
    try {
      Thread.sleep((long) (Math.random() * 5000));
    } catch (InterruptedException e) {
    }
    System.out.println("query code from " + url + "...");
    return "601857";
  }

  static Double fetchPrice(String code, String url) {
    System.out.println("query price from " + url + "...");
    try {
      Thread.sleep((long) (Math.random() * 100));
    } catch (InterruptedException e) {
    }
    return 5 + Math.random() * 20;
  }
}