package util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://stackoverflow.com/questions/21117636/how-to-implement-a-least-frequently-used-lfu-cache
 * <p>
 * Your LFUCache object will be instantiated and called as such: LFUCache obj = new
 * LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
public class LFUCache {

  private final int initialCapacity;

  private static LinkedHashMap<Integer, CacheEntry> cacheMap = new LinkedHashMap<>();
  /* LinkedHashMap is used because it has features of both HashMap and LinkedList.
   * Thus, we can get an entry in O(1) and also, we can iterate over it easily.
   * */

  public LFUCache(int capacity) {
    this.initialCapacity = capacity;
  }

  class CacheEntry {

    private int data;
    private int frequency;

    // default constructor
    private CacheEntry() {
    }

    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }

    public int getFrequency() {
      return frequency;
    }

    public void setFrequency(int frequency) {
      this.frequency = frequency;
    }

  }


  public void put(int key, int data) {
    if (!isFull()) {
      CacheEntry temp = new CacheEntry();
      temp.setData(data);
      temp.setFrequency(0);

      cacheMap.put(key, temp);
    } else {
      int entryKeyToBeRemoved = getLFUKey();
      cacheMap.remove(entryKeyToBeRemoved);

      CacheEntry temp = new CacheEntry();
      temp.setData(data);
      temp.setFrequency(0);

      cacheMap.put(key, temp);
    }
  }

  private int getLFUKey() {
    int key = 0;
    int minFreq = Integer.MAX_VALUE;

    for (Map.Entry<Integer, CacheEntry> entry : cacheMap.entrySet()) {
      if (minFreq > entry.getValue().frequency) {
        key = entry.getKey();
        minFreq = entry.getValue().frequency;
      }
    }

    return key;
  }


  private boolean isFull() {
    return cacheMap.size() == initialCapacity;
  }

  public int get(int key) {
    if (cacheMap.containsKey(key)) {
      CacheEntry temp = cacheMap.get(key);
      temp.frequency++;
      return temp.data;
    }
    // cache miss
    return -1;
  }
}
