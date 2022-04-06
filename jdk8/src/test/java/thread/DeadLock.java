package thread;

import java.util.concurrent.TimeUnit;

public class DeadLock {

  public static void main(String[] args) {
    Object lock1 = new Object();
    Object lock2 = new Object();

    Runnable runnable1 = new Runnable() {
      @Override
      public void run() {
        synchronized (lock1){
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          synchronized (lock2){
            System.out.println("runable 1");
          }
        }

      }
    };
    Runnable runnable2 = new Runnable() {
      @Override
      public void run() {
        synchronized (lock2){
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          synchronized (lock1){
            System.out.println("runable 1");
          }
        }
      }
    };

    new Thread(runnable1).start();
    new Thread(runnable2).start();
  }

}
