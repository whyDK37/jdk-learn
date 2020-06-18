package util.concurrent.lock;

public class ReentrantReadWriteLockTest {

  // constants
  static final int SHARED_SHIFT = 16;
  static final int SHARED_UNIT = (1 << SHARED_SHIFT);
  static final int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
  static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(SHARED_UNIT));
    System.out.println(Integer.toBinaryString(MAX_COUNT));
    System.out.println(Integer.toBinaryString(EXCLUSIVE_MASK));

    System.out.println("ReentrantReadWriteLock.Sync.tryAcquire()");
    int stats = 1;
    int c = stats;
    int w = exclusiveCount(c);
    System.out.println("c:" + c);
    System.out.println("w:" + w);
  }


  /**
   * Returns the number of shared holds represented in count
   */
  static int sharedCount(int c) {
    return c >>> SHARED_SHIFT;
  }

  /**
   * Returns the number of exclusive holds represented in count
   */
  static int exclusiveCount(int c) {
    return c & EXCLUSIVE_MASK;
  }
}
