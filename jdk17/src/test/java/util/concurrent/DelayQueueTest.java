package util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

  @Test
  public void test() {
    DelayQueue<Delayed> delayQueue = new DelayQueue<>();

    delayQueue.add(new Delayed() {
      @Override
      public long getDelay(TimeUnit unit) {
        return 2000;
      }

      @Override
      public int compareTo(Delayed o) {
        return 0;
      }
    });

    Delayed peek = delayQueue.poll();
    System.out.println();
  }
}
