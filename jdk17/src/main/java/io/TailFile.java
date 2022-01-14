package io;

import java.io.File;
import java.io.RandomAccessFile;

public class TailFile {

  public static void main(String[] args) {

    tailLog(new File("/Users/why/Downloads/tail.txt"));
  }

  // See JLogTailer
  public static void tailLog(File file) {
    boolean running = true;
    int updateInterval = 1000;
    long filePointer = file.length();

    try {
      while (running) {
        Thread.sleep(updateInterval);
        long length = file.length();
        if (length < filePointer) {
          System.out.println("Log file was reset. Restarting logging from start of file.");
          filePointer = length;
        } else if (length > filePointer) {
          RandomAccessFile localRandomAccessFile = new RandomAccessFile(file, "r");
          localRandomAccessFile.seek(filePointer);
          String str = null;
          while ((str = localRandomAccessFile.readLine()) != null) {
            // TODO add log cache logic
            System.out.println(str);
          }
          filePointer = localRandomAccessFile.getFilePointer();
          localRandomAccessFile.close();
        }
      }
    } catch (Exception ex) {
    }
  }

}
