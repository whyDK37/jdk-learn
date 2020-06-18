package util.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamParallelDemo {

  public static void main(String[] args) {
//    System.out.println(
//        "IntStream.range(1, 10).parallel().peek(StreamParallelDemo::debug).count() = " + IntStream
//            .range(1, 10).parallel().peek(StreamParallelDemo::debug).count());
//
//    System.out.println("穿行后并行, 多次调用 parallel/sequential 以最后一次为准");
//    System.out.println(
//        "IntStream.range(1, 10)\n\t\t .parallel().peek(StreamParallelDemo::debug)\n\t\t .sequential().peek(StreamParallelDemo::debug2)\n\t\t .count() = "
//            + IntStream.range(1, 10)
//            .parallel().peek(StreamParallelDemo::debug)
//            .sequential().peek(StreamParallelDemo::debug2)
//            .count());
//
//    System.out.println("修改默认并行数");
//    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
//    IntStream.range(1, 10).parallel().peek(StreamParallelDemo::debug).count();

    System.out.println("使用自定义线程池");
    ForkJoinPool pool = new ForkJoinPool(20);
    pool.submit(() -> IntStream.range(1, 100).parallel()
        .peek(StreamParallelDemo::debug).count());
    pool.shutdown();

    synchronized (pool) {
      try {
        pool.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void debug(int i) {
    System.out.println(Thread.currentThread().getName() + " debug " + i);
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void debug2(int i) {
    System.err.println("debug2 " + i);
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
