package reactor;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class Hot {

  public static void main(String[] args) throws InterruptedException {
    final Flux<Long> source = Flux.interval(Duration.ofMillis(1000))
        .take(10)
        .publish()
        .autoConnect();
    source.subscribe();
    Thread.sleep(5000);
    source.toStream().forEach(System.out::println);
  }
}
