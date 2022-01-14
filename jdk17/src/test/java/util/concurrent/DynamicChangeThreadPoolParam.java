package util.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DynamicChangeThreadPoolParam {

  public static void main(String[] args) {
    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
        5, 10,
        60L, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(100));

    System.out.println(poolExecutor.getCorePoolSize());
    System.out.println(poolExecutor.getMaximumPoolSize());

    System.out.println("动态修改核心线程数和最大线程数");
    poolExecutor.setCorePoolSize(1);
    poolExecutor.setMaximumPoolSize(20);
    System.out.println(poolExecutor.getCorePoolSize());
    System.out.println(poolExecutor.getMaximumPoolSize());

    System.out.println("初始化核心线程");
    poolExecutor.prestartCoreThread();
    poolExecutor.prestartAllCoreThreads();

    System.out.println("可通过自定义队列实现动态修改队列大小");
    BlockingQueue<Runnable> queue = poolExecutor.getQueue();

    poolExecutor.shutdown();

  }
}
