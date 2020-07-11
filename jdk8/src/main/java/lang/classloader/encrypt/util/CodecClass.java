package lang.classloader.encrypt.util;

public class CodecClass {

  /**
   * 解密/解密 class文件
   *
   * @param bytes
   * @return
   */
  public static byte[] decodeClassBytes(byte[] bytes) {
    byte[] decodedBytes = new byte[bytes.length];
    for (int i = 0; i < bytes.length; i++) {
      decodedBytes[i] = (byte) (bytes[i] ^ 0xFF);
    }
    return decodedBytes;
  }
}
