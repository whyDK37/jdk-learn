package util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsTest {

  /**
   * 高三位是状态 低29位是 worker count
   */
  private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

  private static final int COUNT_BITS = Integer.SIZE - 3;
  private static final int COUNT_MASK = (1 << COUNT_BITS) - 1;

  // runState is stored in the high-order bits
  private static final int RUNNING = -1 << COUNT_BITS;
  private static final int SHUTDOWN = 0 << COUNT_BITS;
  private static final int STOP = 1 << COUNT_BITS;
  private static final int TIDYING = 2 << COUNT_BITS;
  private static final int TERMINATED = 3 << COUNT_BITS;

  // Packing and unpacking ctl
  private static int runStateOf(int c) {
    return c & ~COUNT_MASK;
  }

  private static int workerCountOf(int c) {
    return c & COUNT_MASK;
  }

  /**
   * @param rs run status
   * @param wc worker count
   */
  private static int ctlOf(int rs, int wc) {
    return rs | wc;
  }

  @Test
  public void init() {
    System.out.println(ctl);
    System.out.println("COUNT_BITS:" + COUNT_BITS);
    System.out.println("COUNT_MASK:" + Integer.toBinaryString(COUNT_MASK));
    System.out.println("RUNNING:" + RUNNING + "->" + Integer.toBinaryString(RUNNING));
    System.out.println("SHUTDOWN:" + SHUTDOWN + "->" + Integer.toBinaryString(SHUTDOWN));
    System.out.println("STOP:" + STOP + "->" + Integer.toBinaryString(STOP));
    System.out.println("TIDYING:" + TIDYING + "->" + Integer.toBinaryString(TIDYING));
    System.out.println("TERMINATED:" + TERMINATED + "->" + Integer.toBinaryString(TERMINATED));

    System.out.println("workerCountOf:" + workerCountOf(ctl.get()));
    System.out.println("runStateOf:" + runStateOf(ctl.get()));
  }

  @Test
  public void fix() throws InterruptedException {

    ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

    executorService.submit(() -> {
      System.out.println(Thread.currentThread().getName());
    });

    Future<Object> submit1 = executorService.submit(new Callable<Object>() {
      @Override
      public Object call() throws Exception {
        return null;
      }
    });

    TimeUnit.SECONDS.sleep(1L);
    System.out.println(Thread.currentThread().getName());
  }

}
