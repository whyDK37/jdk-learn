package agrona;

import org.agrona.collections.Int2IntHashMap;
import org.junit.jupiter.api.Test;

class Int2IntHashMapDemo {

  @Test
  void test() {
    Int2IntHashMap map = new Int2IntHashMap(-1);
    System.out.println(map.get(-1));
    map.put(-1, 12);
    System.out.println(map.get(-1));
  }
}
