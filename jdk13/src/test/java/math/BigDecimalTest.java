package math;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

public class BigDecimalTest {

  @Test
  public void test() {

    System.out.println("使用double类型构造器会造成精度损失");
    System.out.println("new BigDecimal(0.1).add(new BigDecimal(0.2)) = " + new BigDecimal(0.1)
        .add(new BigDecimal(0.2)));
    System.out.println("new BigDecimal(1.0).subtract(new BigDecimal(0.8)) = " + new BigDecimal(1.0)
        .subtract(new BigDecimal(0.8)));
    System.out.println(
        "new BigDecimal(4.015).multiply(new BigDecimal(100)) = " + new BigDecimal(4.015)
            .multiply(new BigDecimal(100)));
    System.out.println(
        "new BigDecimal(123.3).divide(new BigDecimal(100)) = " + new BigDecimal(123.3)
            .divide(new BigDecimal(100)));

    System.out.println("使用字符串构造器，不会造成精度损失");
    System.out.println(
        "new BigDecimal(\"0.1\").add(new BigDecimal(\"0.2\")) = " + new BigDecimal("0.1")
            .add(new BigDecimal("0.2")));
    System.out.println(
        "new BigDecimal(\"1.0\").subtract(new BigDecimal(\"0.8\")) = " + new BigDecimal("1.0")
            .subtract(new BigDecimal("0.8")));
    System.out.println(
        "new BigDecimal(\"4.015\").multiply(new BigDecimal(\"100\")) = " + new BigDecimal("4.015")
            .multiply(new BigDecimal("100")));
    System.out.println(
        "new BigDecimal(\"123.3\").divide(new BigDecimal(\"100\")) = " + new BigDecimal("123.3")
            .divide(new BigDecimal("100")));

    System.out.println();
    double num1 = 3.35;
    float num2 = 3.35f;
    // 这就是由精度问题和舍入方式共同导致的，double 和 float 的 3.35 其实相当于 3.350xxx 和 3.349xxx:
    System.out.println(String.format("格式化，四舍五入 %f->%.1f", num1, num1));
    System.out.println(String.format("格式化，四舍五入 %f->%.1f", num2, num2));

    DecimalFormat format = new DecimalFormat("#.#");
    format.setRoundingMode(RoundingMode.HALF_UP);
    System.out.println(format.format(num1));
    System.out.println(format.format(num2));

    System.out.println(
        "new BigDecimal(\"3.35\").setScale(1, RoundingMode.DOWN) = " + new BigDecimal("3.35")
            .setScale(1, RoundingMode.DOWN));
    System.out.println(
        "new BigDecimal(\"3.35\").setScale(1, RoundingMode.HALF_UP) = " + new BigDecimal("3.35")
            .setScale(1, RoundingMode.HALF_UP));


  }

  @Test
  void compareAndEquals() {
    System.out.println();
    System.out.println("比较 equals");
    // BigDecimal 的 equals 方法的注释中说 明了原因，equals 比较的是 BigDecimal 的 value 和 scale，1.0 的 scale 是 1，1 的 scale 是 0，所以结果一定是 false:
    assertNotEquals(new BigDecimal("1.0"), new BigDecimal("1"));
    assertEquals(0, (new BigDecimal("1.0")
        .compareTo(new BigDecimal("1"))));
  }

  @Test
  void setTest() {
    System.out
        .println("setTest---------------------------------------------------------------------");
    System.out.println("HashSet 比较的是 hash code");
    assertEquals(311, new BigDecimal("1.0").hashCode());
    assertEquals(31, new BigDecimal("1").hashCode());
    HashSet<BigDecimal> hashSet = new HashSet<>();
    assertTrue(hashSet.add(new BigDecimal("1.0")));
    assertTrue(hashSet.add(new BigDecimal("1.00")));
    assertFalse(hashSet.contains(new BigDecimal("1")));
    System.out.println("使用 stripTrailingZeros 方法过滤结尾多余的0");
    assertTrue(hashSet.add(new BigDecimal("1.0").stripTrailingZeros()));
    assertTrue(hashSet.contains(new BigDecimal("1").stripTrailingZeros()));

    System.out.println(
        "使用 TreeSet 替换 HashSet。TreeSet 不使用 hashCode 方法，也不使 用 equals 比较元素，而是使用 compareTo 方法，所以不会有问题。");
    assertEquals(0, new BigDecimal("1.0").compareTo(new BigDecimal("1")));
    TreeSet<BigDecimal> treeSet = new TreeSet<>();
    assertTrue(treeSet.add(new BigDecimal("1.0")));
    assertFalse(treeSet.add(new BigDecimal("1.00")));
    System.out.println("treeSet = " + treeSet);
    assertTrue(treeSet.contains(new BigDecimal("1")));
  }

  @Test
  public void scale(){
    BigDecimal bigDecimal = new BigDecimal("1.234");
    System.out.println(bigDecimal.setScale(2,RoundingMode.UP));
  }


  @Test
  public void round() {
    BigDecimal bigDecimal = new BigDecimal("1.24");
    System.out.println("bigDecimal.setScale(1,RoundingMode.HALF_EVEN) = " + bigDecimal
        .setScale(1, RoundingMode.HALF_EVEN));

  }

  BigDecimal round(BigDecimal val, BigDecimal x, BigDecimal y) {
    BigDecimal remainder = val.remainder(x);
    BigDecimal base = val.subtract(remainder);
    return remainder.compareTo(y) < 0 ? base : base.add(x);
  }

  @Test
  public void bigVal(){
    BigDecimal bigVal = new BigDecimal("1201379530.400000");
    System.out.println(bigVal);
  }

}
