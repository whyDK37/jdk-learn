package util.time;

import java.time.Duration;

public class DurationDemo {

  public static void main(String[] args) {
    System.out.println(Duration.ofSeconds(2));

    System.out.println(Duration.parse("PT2S"));
  }

}
