package jmh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 刘绍 on 2020/8/1.
 */
public class NumsSum{

    static List<Integer> nums = new ArrayList<>();
    static {
        Random r = new Random();
      for (int i = 0; i < 10000; i++) {
        nums.add(1000000 + r.nextInt(1000000));
      }
    }

    public static void foreach() {
        nums.forEach(v->isPrime(v));
    }

    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
          if (num % i == 0) {
            return false;
          }
        }
        return true;
    }
}
