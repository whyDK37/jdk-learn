package util.stream;

import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediate {

  public static void main(String[] args) {
    String str = "my name is 007";

    System.out.println("print each word length");
    Stream.of(str.split(" ")).filter(s -> s.length() > 2)
        .map(String::length).forEach(System.out::println);

    System.out.println("flat map. print each char");
    // flatMap A->B
    // intStream/longStream
    Stream.of(str.split(" "))
        .peek(System.out::println)
        .flatMap(s -> s.chars().boxed())
        .forEach(i -> System.out.println((char) i.intValue()));

    System.out.println("--------------peek------------ 可在中间调试");
    Stream.of(str.split(" ")).peek(System.out::println)
        .forEach(System.out::println);

    System.out.println("Random().ints(), 一定要使用 limit 限制");
    new Random().ints().filter(i -> i > 100 && i < 1000).limit(3)
        .forEach(System.out::println);
  }

}
