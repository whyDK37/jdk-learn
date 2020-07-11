package util.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalDemo {

  public static void main(String[] args) {
    String str = "my name is 007";

    //
    System.out.println("并行流打印，顺序是乱的");
    str.chars().parallel().forEach(i -> System.out.print((char) i));
    System.out.println();
    System.out.println("并行流打印，顺序打印");
    str.chars().parallel().forEachOrdered(i -> System.out.print((char) i));
    System.out.println();

    System.out.println("流转成集合");
    List<String> list = Stream.of(str.split(" "))
        .collect(Collectors.toList());
    System.out.println(list);

    System.out.println("合并结果，竖线分割");
    System.out.println(Stream.of(str.split(" "))
        .reduce((s1, s2) -> s1 + "|" + s2).orElse(null));
    System.out.println(Stream.of(str.split(" "))
        .reduce("@", (s1, s2) -> s1 + "|" + s2));
    System.out.println(Stream.of(str.split(" "))
        .reduce("#", (s, s2) -> s + "|-" + s2, (s, s2) -> s + "|+" + s2));

    System.out.println("计算所有单词的长度");
    Integer length = Stream.of(str.split(" ")).map(String::length)
        .reduce(0, Integer::sum);
    System.out.println(length);

    System.out.println("获取最大的单词");
    Optional<String> max = Stream.of(str.split(" "))
        .max(Comparator.comparingInt(String::length));
    System.out.println(max.get());

    System.out.println("获取第一个随机值");
    OptionalInt findFirst = new Random().ints().findFirst();
    System.out.println(findFirst.getAsInt());
  }

}
