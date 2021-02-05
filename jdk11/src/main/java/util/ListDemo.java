package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListDemo {

  public static void main(String[] args) {

    int[] arr1 = {1, 2, 3};
    System.out.println("基本类型的数组会当成一个 list 中的一个元素。");
    System.out.println("Arrays.asList(arr1).size() = " + Arrays.asList(arr1).size());
    List list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
    System.out.println("list1.size() = " + list1.size());
    Integer[] arr2 = {1, 2, 3};
    List list2 = Arrays.asList(arr2);
    System.out.println("list2.size() = " + list2.size());
  }

}
