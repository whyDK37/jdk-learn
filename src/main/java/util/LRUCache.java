package util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
public class LRUCache {

  private final int capacity;
  LinkedHashMap<Integer, Integer> cache;

  public LRUCache(int capacity) {
    cache = new LinkedHashMap<>(capacity, 0.75F, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
      }
    };
    this.capacity = capacity;
  }

  public int get(int key) {
    Integer value = cache.get(key);
    return value == null ? -1 : value;
  }

  public void put(int key, int value) {
    cache.put(key, value);
  }
}
