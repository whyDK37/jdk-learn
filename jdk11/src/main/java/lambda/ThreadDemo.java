package lambda;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ThreadDemo {

  public static void main(String[] args) throws IOException, InterruptedException {
    Runnable target = new Runnable() {

      @Override
      public void run() {
        LockSupport.park(this);
        System.out.println("ok");
      }
    };
    Thread thread = new Thread(target);
    thread.setName("parking thread");
    thread.start();

    // jdk8 lambda
    Runnable target2 = () -> System.out.println("ok");
    Runnable target3 = () -> System.out.println("ok");
    System.out.println(target2 == target3); // false

    new Thread(target2).start();

    System.in.read();
    LockSupport.unpark(thread);
    TimeUnit.HOURS.sleep(1L);

  }

}
