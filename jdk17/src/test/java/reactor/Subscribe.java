package reactor;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Subscribe {

  @Test
  void subscribe() {
    Flux.range(1, 10)
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


  @Test
  public void subscribeOn() throws InterruptedException {
    Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

    final Flux<String> flux = Flux
        .range(1, 100)
        .map(i -> 10 + i)
        .subscribeOn(s)
        .map(i -> "value " + i);

    flux.subscribe(new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(Thread.currentThread().getName() + "->" + s);
      }
    });

    TimeUnit.SECONDS.sleep(4L);
  }

  @Test
  public void sub() {
    Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

    Disposable subscribe = Flux
        .range(1, 100)
        .parallel(4)
        .runOn(s, 3)
        .subscribe(new Consumer<Integer>() {
          @Override
          public void accept(Integer integer) {
            System.out.println(Thread.currentThread().getName() + "->" + integer);
          }
        });
  }


  @Test
  public void subParallel() {
    Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

    Flux<Integer> ids = Flux.range(1, 999);//.fromArray(new String[]{"1", "2", "3"});

    Flux<String> combinations = ids
        .flatMap(id -> {
          Mono<String> nameTask = ifhrName(id);
          Mono<Integer> statTask = ifhrStat(id);

          return nameTask.zipWith(statTask,
              (name, stat) -> {
                System.out.println(Thread.currentThread().getName());
                return "Name " + name + " has stats " + stat;
              });
        });

    Mono<List<String>> result = combinations.collectList();

    List<String> results = result.block();
    System.out.println(results);
  }

  private Mono<Integer> ifhrStat(Integer id) {
    return Mono.just(id.hashCode() * 3);
  }

  private Mono<String> ifhrName(Integer id) {
    return Mono.just("name " + id);
  }

}
