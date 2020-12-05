package util;

import java.util.IdentityHashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IdentityHashMapTest {

  /**
   * 每个key，通过 System.identityHashCode(x) 方法获取 hash 值。
   */
  @Test
  public void put() {
    IdentityHashMap<String, String> map = new IdentityHashMap<>();

    map.put(String.valueOf(1), "我是谁");
    map.put(String.valueOf(1), "我在哪");
    System.out.println(map);
    Assertions.assertEquals(2, map.size());
  }

  @Test
  void nextKeyIndexTest() {
    int len = 16;
    int idx = 0;
    for (int i = 0; i < 20; i++) {
      idx = nextKeyIndex(idx, len);
      System.out.printf("%d, ", idx);
    }
  }

  private static int nextKeyIndex(int i, int len) {
    return (i + 2 < len ? i + 2 : 0);
  }

}
