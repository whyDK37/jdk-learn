package nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class FileChannelMapDemo {

  public static void main(String[] args) throws IOException {
    File file = new File("D:\\fm.txt");

    //Create the file

    if (file.createNewFile()) {
      System.out.println("File is created!");
    } else {
      System.out.println("File already exists.");
    }

    RandomAccessFile randomAccessSourceFile = new RandomAccessFile(file, "rw");

    FileChannel sourceFileChannel = randomAccessSourceFile.getChannel();
    System.out.println(sourceFileChannel.size());

    MappedByteBuffer map = sourceFileChannel.map(MapMode.READ_WRITE, 0, 1024*1024*1024);
    System.out.println(map.isLoaded());
    System.out.println(Integer.MAX_VALUE);

  }

}
