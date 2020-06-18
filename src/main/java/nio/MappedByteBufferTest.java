package nio;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class MappedByteBufferTest {

  public static void main(String[] args) throws Exception {
    File file = new File("D:\\GoogleStyle.xml");
    long len = file.length();
    byte[] ds = new byte[(int) len];
    MappedByteBuffer mappedByteBuffer = new FileInputStream(file).getChannel()
        .map(FileChannel.MapMode.READ_ONLY, 0,
            len);
    for (int offset = 0; offset < len; offset++) {
      byte b = mappedByteBuffer.get();
      ds[offset] = b;
    }
    Scanner scan = new Scanner(new ByteArrayInputStream(ds)).useDelimiter(" ");
    while (scan.hasNext()) {
      System.out.print(scan.next() + " ");
    }
  }
}