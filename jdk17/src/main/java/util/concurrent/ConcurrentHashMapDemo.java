package util.concurrent;

import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

/**
 * @author why
 */
public class ConcurrentHashMapDemo {

  public static void main(String[] args) {
    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    for (int i = 10; i > 0; i--) {
      final String key = UUID.randomUUID().toString();
      concurrentHashMap.put(key, "" + i);
      System.out.println("key = " + key);
    }

    final KeySetView<String, String> strings = concurrentHashMap.keySet("mappedValue");
    for (String string : strings) {
      System.out.println(string);
    }
  }
}

