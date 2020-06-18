package lang.reflect;

import java.lang.reflect.Field;

public class FinalFieldTest {

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    Test test = new Test();

    Field str = Test.class.getDeclaredField("str");
    str.setAccessible(true);
    str.set(test, "ss-f");
    System.out.println(test.str);

    Field str2 = Test.class.getDeclaredField("str2");
    str2.setAccessible(true);
    str2.set(test, "ss-f2");
    System.out.println(test.str2);

  }

  static class Test {

    private final String str = "ss";
    private final String str2;

    Test() {
      str2 = "ss";
    }
  }
}
