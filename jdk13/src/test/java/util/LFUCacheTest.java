package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LFUCacheTest {

  @Test
  public void LFUCache() {
    LFUCache cache = new LFUCache(2 /* capacity */);

    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(cache.get(1), 1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    assertEquals(cache.get(2), -1);       // returns -1 (not found)
    assertEquals(cache.get(3), 3);       // returns 3.
    cache.put(4, 4);    // evicts key 1.
    assertEquals(cache.get(1), -1);       // returns -1 (not found)
    assertEquals(cache.get(3), 3);       // returns 3
    assertEquals(cache.get(4), 4);       // returns 4
  }

  @Test
  public void LFUCache3() {
    LFUCache cache = new LFUCache(3 /* capacity */);

    cache.put(2, 2);
    cache.put(1, 1);
    assertEquals(cache.get(2), 2);
    assertEquals(cache.get(1), 1);
    assertEquals(cache.get(2), 2);

    cache.put(3, 3);
    cache.put(4, 4);
    assertEquals(cache.get(3), -1);
    assertEquals(cache.get(2), 2);
    assertEquals(cache.get(1), 1);
    assertEquals(cache.get(4), 4);

  }
}