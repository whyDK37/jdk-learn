package util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreateDemo {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    //
    list.stream();
    list.parallelStream();

    //
    Arrays.stream(new int[]{2, 3, 5});

    //
    IntStream.of(1, 2, 3);
    IntStream.rangeClosed(1, 10);

    //
    new Random().ints().limit(10);

    //
    Random random = new Random();
    Stream.generate(() -> random.nextInt()).limit(20);

  }

}
