package util;

import java.util.TreeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeMapTest {

  @Test
  public void ceilingEntry() {
    TreeMap<Integer, String> map = new TreeMap<>();

    map.put(2, "two");
    map.put(1, "one");
    map.put(3, "two");
    map.put(6, "six");
    map.put(5, "five");

    System.out.println("map = " + map);
    System.out.println("map.ceilingEntry(2) = " + map.ceilingEntry(2));
    System.out.println("map.ceilingEntry(4) = " + map.ceilingEntry(4));
    System.out.println("map.ceilingEntry(9) = " + map.ceilingEntry(9));
    if (map.ceilingEntry(9) == null) {
      System.out.println("map.firstEntry() = " + map.firstEntry());
    }
    Assertions.assertEquals(5, map.ceilingKey(4));
    Assertions.assertNull(map.ceilingKey(9));
  }
}
