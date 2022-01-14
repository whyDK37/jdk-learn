package util;

import java.util.WeakHashMap;
import org.junit.jupiter.api.Test;

public class WeakHashMapTest {

  @Test
  public void test() {
    WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();

    weakHashMap.put("a", "a");

    System.gc();
    System.out.println("weakHashMap.get(\"a\") = " + weakHashMap.get("a"));
  }

}
