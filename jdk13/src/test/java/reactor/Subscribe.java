package reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Subscribe {

  @Test
  void subscribe() {
    Flux.just(1, 2)
        .concatWith(Mono.error(new IllegalStateException()))
        .subscribe(System.out::println, System.err::println);
  }

  @Test
  void onErrorReturn() {
    Flux.just(1, 2)
        .concatWith(Mono.error(new IllegalStateException()))
        .onErrorReturn(0)
        .subscribe(System.out::println);
  }

  @Test
  void retry() {
    Flux.just(1, 2)
        .concatWith(Mono.error(new IllegalStateException()))
        .retry(1)
        .subscribe(System.out::println, System.err::println);
  }
}
