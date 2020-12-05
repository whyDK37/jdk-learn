package util;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

public class HashMapHashCollision {

  @Test
  public void hashMapHashCollision() {
    HashMap<String, String> map = new HashMap<>();
    List<String> strings = CreateHashCodeSomeUtil.hashCodeSomeList(10);
    for (String string : strings) {
      map.put(string, string);
    }
    System.out.println(map);
  }

  @Test
  public void sameHashCodeString() {
    for (int i = 0; i < 5; i++) {
      System.out.println("size:" + i + 1);
      List<String> strings = CreateHashCodeSomeUtil.hashCodeSomeList(i + 1);
      for (String string : strings) {
        System.out.println("string = " + string + ", hashCode=" + string.hashCode());
      }
      System.out.println();
    }
  }

  public int StringHashCode(String str) {
    char[] value = str.toCharArray();
    int h = 0;
    if (h == 0 && value.length > 0) {
      char val[] = value;

      for (int i = 0; i < value.length; i++) {
        h = 31 * h + val[i];
      }
    }
    return h;
  }

}
