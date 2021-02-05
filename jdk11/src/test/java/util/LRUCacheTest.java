package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LRUCacheTest {

  @Test
  void test() {
    LRUCache cache = new LRUCache(2 /* capacity */);

    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(cache.get(1), 1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    assertEquals(cache.get(2), -1);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    assertEquals(cache.get(1), -1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4
  }
}