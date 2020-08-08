package util;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class HashMapHashCollision {

  @Test
  public void hashMapHashCollision() {
    HashMap<Integer, String> map = new HashMap<>();
    map.put(null, "null value");
    map.put(0, "0");
    System.out.println(map);
  }

}
