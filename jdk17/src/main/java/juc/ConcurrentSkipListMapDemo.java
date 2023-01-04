package juc;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {

    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Integer> cslm = new ConcurrentSkipListMap<>();
        cslm.put("leesf", 24);
        cslm.put("dyd", 24);
        System.out.println("");
        cslm.put("eye", 24);
        cslm.put("dog", 24);

        for (String key :cslm.keySet()) {
            System.out.print("[" + key + "," + cslm.get(key) + "] ");
        }
        System.out.println();
        cslm.remove("leesf");
        for (String key :cslm.keySet()) {
            System.out.print("[" + key + "," + cslm.get(key) + "] ");
        }
    }
}
