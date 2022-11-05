package juc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;

public class MapCompute {

    private static final ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        map.put("abc", 1);

        remove("abc");

        System.out.println(map.get("abc"));
        System.out.println(map.containsKey("abc"));
    }

    private static void remove(String key) {
        map.compute(key, (s, integer) -> {
            if (integer == null) {
                return null;
            }
            integer -= integer;
            if (integer == 0) {
                return null;
            }
            return integer;
        });
    }
}
