package util.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * https://mp.weixin.qq.com/s/ QVzlkJLsA7oN5lZrBx43kA
 *
 * @author wanghuanyu
 */
public class ConcurrentHashDeadLoopDemo {

  public static void main(String[] args) {
    Map<String, Integer> map = new ConcurrentHashMap<>(16);
    map.computeIfAbsent(
        "AaAa",
        key -> {
          return map.computeIfAbsent(
              "BBBB",
              key2 -> 42);
        }
    );
  }
}

