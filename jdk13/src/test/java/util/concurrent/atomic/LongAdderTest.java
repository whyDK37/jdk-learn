package util.concurrent.atomic;

import java.util.concurrent.atomic.LongAdder;

/**
 * https://blog.csdn.net/zqz_zqz/article/details/70665941
 */
public class LongAdderTest {

  public static void main(String[] args) {
    LongAdder longAdder = new LongAdder();
    longAdder.increment();
    System.out.println(longAdder.longValue());
  }
}
