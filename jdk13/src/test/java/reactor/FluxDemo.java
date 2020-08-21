package reactor;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxDemo {

  @Test
  public void pubSub() {
    Flux<String> seq1 = Flux.just("foo", "bar", "foobar");

    List<String> iterable = Arrays.asList("foo", "bar", "foobar");

    Flux<String> seq2 = Flux.fromIterable(iterable);

    Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 3);

    Mono<String> noData = Mono.empty();

    Mono<String> data = Mono.just("foo");
  }
}
