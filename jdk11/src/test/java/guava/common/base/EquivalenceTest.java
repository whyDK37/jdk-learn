package guava.common.base;

import com.google.common.base.Equivalence;
import org.junit.jupiter.api.Test;

public class EquivalenceTest {

  @Test
  public void test(){
    Equivalence<Object> equals = Equivalence.equals();
    int hash = equals.hash("123");
    System.out.println(hash);
    System.out.println("123".hashCode());
  }
}
