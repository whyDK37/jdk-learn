package lang;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

  /**
   * https://mp.weixin.qq.com/s/CrPXwNfN1LrUDDjjJ1c7rQ jls 3.10.5
   */
  @Test
  public void intern() {
    String s1 = new StringBuilder("计算机").append("软件").toString();
    Assertions.assertTrue(s1.intern() == s1);
    String s2 = new StringBuilder("ja").append("va").toString();
    // java 已经在常量池，所以在调用 intern 之后，返回的是常量池的对象，s2还是新创建的对象
    Assertions.assertFalse(s2.intern() == s2);
    Assertions.assertFalse(s2 == "java");
    Assertions.assertSame("java", s2.intern());
    System.out.println("System.identityHashCode(\"java\") = " + System.identityHashCode("java"));
    System.out
        .println("System.identityHashCode(s2.intern()) = " + System.identityHashCode(s2.intern()));
    System.out.println("System.identityHashCode(s2) = " + System.identityHashCode(s2));

    // from jsl 3.10.5 六条规则对应留个demo
    /*• Literal strings within the same class (§8 (Classes)) in the same package (§7 (Packages))
        represent references to the same String object (§4.3.1).
      • Literal strings within different classes in the same package represent references to the
        same String object.
      • Literal strings within different classes in different packages likewise represent references
        to the same String object.
      • Strings computed by constant expressions (§15.28) are computed at compile time and
        then treated as if they were literals.
      • Strings computed by concatenation at run time are newly created and therefore distinct.
      • The result of explicitly interning a computed string is the same string as any pre-existing
        literal string with the same contents.*/
    String hello = "Hello", lo = "lo";
    System.out.print((hello == "Hello") + " ");
    System.out.print((Other.hello == hello) + " ");
    System.out.print((lang.other.Other.hello == hello) + " ");
    System.out.print((hello == ("Hel" + "lo")) + " ");
    System.out.print((hello == ("Hel" + lo)) + " ");// false
    System.out.println(hello == ("Hel" + lo).intern());// from string pool
  }//

  static class Other {

    static String hello = "Hello";
  }

}
