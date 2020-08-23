package util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 案例来自 java并发编程之美 11.9 线程池使用FutureTask时需要注意的事情
 */
public class FutureWithDiscardPolicyTest {

  // 创建一个单线程，拒绝策略时 DiscardPolicy
  private final static ThreadPoolExecutor executorService = new
      ThreadPoolExecutor(1, 1, 1L, TimeUnit.MINUTES,
      new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.DiscardPolicy());

  public static void main(String[] args) throws Exception {
    //提交任务，阻塞 5 秒
    Future taskOne = executorService.submit(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    //此时，队列和线程已经都被占用，当前提交的任务会执行绝策略
    Future taskTwo = null;
    try {
      taskTwo = executorService.submit(() -> System.out.println("start runable three"));
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
    }
    System.out.println("获取结果：");
    System.out.println("task one " + taskOne.get()); //等待任务one执行完毕
    System.out
        .println("task two " + (taskTwo == null ? null : taskTwo.get())); // (7)等待任务three执行完毕
    executorService.shutdown(); //(8)关闭线程池，阻塞直到所有任务执行完毕
  }
}
