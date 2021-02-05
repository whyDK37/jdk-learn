package math;

import java.math.BigInteger;

public class BigIntegerDemo {

  public static void main(String[] args) {

    System.out.println("long 溢出不抛出异常，只是数值是负数");
    long l = Long.MAX_VALUE;
    System.out.println(l + 1);
    System.out.println((l + 1) == Long.MIN_VALUE);

    System.out.println("long 溢出是抛出异常");
    try {
      BigInteger i = new BigInteger(String.valueOf(Long.MAX_VALUE));
      System.out.println(i.add(BigInteger.ONE).toString());
      i.add(BigInteger.ONE).longValueExact();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    try {
      l = Long.MAX_VALUE;
      System.out.println(Math.addExact(l, 1));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
