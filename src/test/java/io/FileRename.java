package io;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class FileRename {

  public static void main(String[] args) {
    String dir = "D:\\lcf\\javaArchitect\\11_支撑1亿图片的分布式存储系统项目实战";
    File file = new File(dir);
    File[] files = file.listFiles();
    int count = 233;

    Set<Integer> skip = new HashSet<>();

    for (File f : files) {
      while (skip.contains(count)) {
        count++;
      }
      System.out.println(f.getParent() + "\\" + f.getName() + "->" + toFileName(count, f));
      f.renameTo(new File(f.getParent(), toFileName(count, f)));
      count++;
    }
  }

  private static String toFileName(int count, File f) {
    if (count < 10) {
      return "00" + count + ".MP4";
    }
    if (count < 100) {
      return "0" + count + ".MP4";
    }
    return count + ".MP4";
  }
}
