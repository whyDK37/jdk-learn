package util.concurrent.lock;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {


  public static void main(String[] args) throws InterruptedException {

    ReentrantLock reentrantLock = new ReentrantLock(true);

    reentrantLock.lock();

    new Thread(() -> {
      reentrantLock.lock();
      System.out.println(Thread.currentThread().getName());
      reentrantLock.unlock();
    }).start();

    System.out.print("input 1:");
    Scanner scanner = new Scanner(System.in);
    scanner.nextDouble();
    reentrantLock.unlock();

    TimeUnit.HOURS.sleep(1L);

  }

}
