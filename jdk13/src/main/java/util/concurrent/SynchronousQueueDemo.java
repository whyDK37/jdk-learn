package util.concurrent;

import static java.util.concurrent.TimeUnit.MICROSECONDS;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

  public static void main(String[] args) {
    final SynchronousQueue<Integer> handoffQueue = new SynchronousQueue<>(true);

    Thread produce = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println("produce " + i);
          handoffQueue.offer(i);
        }
      }
    });

    Thread consumer = new Thread(new Runnable() {
      @Override
      public void run() {
        Integer poll = null;
        while (true) {
          try {
            poll = handoffQueue.poll(200, MICROSECONDS);
            if (poll != null) {
              System.out.println("consumer " + poll);
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });

    produce.start();
    consumer.start();
  }
}
