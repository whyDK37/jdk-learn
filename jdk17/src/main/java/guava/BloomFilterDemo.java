package guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import java.nio.charset.Charset;

public class BloomFilterDemo {

  public static void main(String[] args) {
    BloomFilter<String> filter = BloomFilter.create(
        Funnels.stringFunnel(Charset.forName("utf-8")),
        500,
        0.01D
    );

    for (int i = 0; i < 10; i++) {
      System.out.println(filter.put(String.valueOf(i)));
    }

    System.out.println();
    for (int i = 0; i < 1; i++) {
      System.out.println(filter.put(String.valueOf(i)));
    }

  }

}
