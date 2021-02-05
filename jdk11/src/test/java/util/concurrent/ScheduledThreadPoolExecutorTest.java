package util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {

  @Test
  public void init() {

  }

  @Test
  public void schedule() throws InterruptedException {
    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

    scheduledThreadPoolExecutor
        .schedule(() -> System.out.println(Thread.currentThread().getName()), 500,
            TimeUnit.MICROSECONDS);

    System.out.println(
        "scheduledThreadPoolExecutor.getQueue().size() = " + scheduledThreadPoolExecutor.getQueue()
            .size());
    TimeUnit.SECONDS.sleep(10L);

  }
}
