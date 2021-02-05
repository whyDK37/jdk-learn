package util;

import java.util.UUID;

/**
 * <pre>
 * 标准的UUID格式如下：
 * xxxxxxxx-xxxx-Mxxx-Nxxx-xxxxxxxxxxxx
 *
 * 除连字符-外，上面每个字符都是一个十六进制的数字，共有5个部分组成，
 * 第一部分8个，第二部分4个，第三部分4个，第四部分4个，第五部分12个，8-4-4-4-12，一共32个十六进制字符，因此一共是128位。
 *
 * 其中，M表示UUID的版本，N表示UUID的变体。
 * </pre>
 */
public class UUIDTest {

  public static void main(String[] args) {
    System.out.println(System.currentTimeMillis() / 1000);
    System.out.println("version 4");
    UUID uuid = UUID.randomUUID();
    System.out.println("uuid.version() = " + uuid.version());
    System.out.println("uuid.variant() = " + uuid.variant());
    System.out.println("uuid.toString() = " + uuid.toString());

    System.out.println("version 3");
    UUID ver3 = UUID.nameUUIDFromBytes("w".getBytes());
    System.out.println("uuid.version() = " + ver3.version());
    System.out.println("uuid.variant() = " + ver3.variant());
    System.out.println("uuid.toString() = " + ver3.toString());
  }
}
