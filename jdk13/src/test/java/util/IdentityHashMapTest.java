package util;

import beans.Person;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IdentityHashMapTest {

  @Test
  public void test() {
    IdentityHashMap<Person, String> imp = new IdentityHashMap<>();
    for (int i = 0; i < 100; i++) {
      imp.put(new Person("kitty", i), "kitty_" + i);
    }
    Assertions.assertEquals(100, imp.size());
    System.out.println("imp.size() = " + imp.size());
    for (Entry<Person, String> me : imp.entrySet()) {
      System.out.println(me.getKey() + " --> " + me.getValue());
    }

    Assertions.assertNull(imp.put(null, "1"));
    Assertions.assertEquals("1", imp.put(null, "2"));
  }
}
