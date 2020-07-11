package invoke;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class VarHandleTest {

  @Test
  void test() {
    String[] sa = new String[11];
    VarHandle avh = MethodHandles.arrayElementVarHandle(String[].class);
    boolean r = avh.compareAndSet(sa, 10, "expected", "new");
    System.out.println(r);
    System.out.println("Arrays.toString(sa) = " + Arrays.toString(sa));
  }

}
