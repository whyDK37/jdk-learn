package lang;

import java.util.Random;
import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

  @Test
  public void threadLocal() {
    ThreadLocal<Random> randomThreadLocalHolder = ThreadLocal.withInitial(Random::new);
    for (int i = 0; i < 100; i++) {
      System.out.println(randomThreadLocalHolder.get().nextInt());
    }

  }
}
