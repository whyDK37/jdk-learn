package reactor;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class FluxCreator {

  @Test
  void simple() {
    System.out.println("*******");
    Flux.just("Hello", "World")
        .switchIfEmpty(subscriber -> {
          subscriber.onNext("a");
          subscriber.onNext("b");
          subscriber.onNext("c");
        })
        .take(2)
        .publishOn(Schedulers.newParallel("in"))
        .subscribeOn(Schedulers.newParallel("out"))
        .subscribe(System.out::println);

    Flux.fromArray(new Integer[]{1, 2, 3});
    Flux.empty();
    Flux.range(1, 10);
    Flux.interval(Duration.of(10, ChronoUnit.SECONDS));
    Flux.interval(Duration.ofMillis(1000)).subscribe(System.out::println);
  }

  @Test
  void generate() {
    System.out.println("*******");
    Flux.generate(sink -> {
      sink.next("Hello");
      sink.complete();
    }).subscribe(System.out::println);

    final Random random = new Random();
    Flux.generate(ArrayList::new, (list, sink) -> {
      int value = random.nextInt(100);
      list.add(value);
      sink.next(value);
      if (list.size() == 10) {
        sink.complete();
      }
      return list;
    }).subscribe(System.out::println);
  }

  @Test
  void create() {
    System.out.println("*******");
    Flux.create(sink -> {
      for (int i = 0; i < 10; i++) {
        sink.next(i);
      }
      sink.complete();
    }).subscribe(System.out::println);
  }
}
