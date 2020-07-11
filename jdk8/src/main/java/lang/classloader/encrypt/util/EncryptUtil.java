package lang.classloader.encrypt.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class EncryptUtil {

  public static void main(String[] args) throws IOException {
    File file = new File("D:\\workspace\\mygit\\jdk-learn\\jdk8\\target\\classes\\lang\\classloader\\encrypt\\MyClass.class");
    File target = new File("D:\\workspace\\mygit\\jdk-learn\\jdk8\\target\\classes\\lang\\classloader\\encrypt\\MyClass.class_");
    byte[] bytes = FileUtils.readFileToByteArray(file);
    byte[] bytes1 = CodecClass.decodeClassBytes(bytes);

    FileUtils.writeByteArrayToFile(target,bytes1);
  }

}
