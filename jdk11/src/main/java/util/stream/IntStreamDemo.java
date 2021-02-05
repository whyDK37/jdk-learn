package util.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamDemo {

  public static void main(String[] args) {

    int[] ints = IntStream.of(1, 2, 4, 5, 6, 3, 7, 84, 5)
        .filter(value -> value < 50)
        .distinct()
        .sorted()
        .toArray();
    System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));

    System.out.println("IntStream.of(1, 2, 4, 5, 6, 3, 7, 84, 5).min() = " + IntStream
        .of(1, 2, 4, 5, 6, 3, 7, 84, 5).min());

    int[] nums = {1, 2, 3};
    System.out.println("外部迭代");
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    System.out.println(sum);

    System.out.println("内部迭代");
    int sum2 = IntStream.of(nums).parallel().map(IntStreamDemo::doubleNum).sum();
    System.out.println(sum2);

    System.out.println("没有调用终止操作，中间操作不会执行");
    IntStream.of(nums).map(IntStreamDemo::doubleNum);
  }

  public static int doubleNum(int i) {
    return i * 2;
  }

}
