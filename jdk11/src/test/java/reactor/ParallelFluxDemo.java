package reactor;


import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class ParallelFluxDemo {

  @Test
  void p0() {
    Flux.range(1, 10)
        .parallel(2)
        .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));

    Flux.range(1, 10)
        .parallel(2)
        .runOn(Schedulers.parallel())
        .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
  }

  @Test
  void p1() {

    Flux.range(1, 10)
        .parallel(2)
        .runOn(Schedulers.parallel())
        .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
  }

  @Test
  void parallel() throws InterruptedException {
    Scheduler scheduler = Schedulers.fromExecutor(Executors.newFixedThreadPool(4));
    Flux.range(1, 20)
        .parallel(2)
        .runOn(scheduler)
        .doOnNext(i -> System.out.println(Thread.currentThread().getName() + " -> " + i))
        .sequential()
        .blockLast();

    System.out.println("done");
  }

  @Test
  void parallelWithFlatMap() {
    Flux.just(1)
        .repeat(10)
        .flatMap(i -> Mono.fromCallable(() -> {
          blockingTask(i);
          return i;
        }).subscribeOn(Schedulers.elastic()), 3)
        .subscribe(new Consumer<Integer>() {
          @Override
          public void accept(Integer i) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
          }
        });
  }

  @Test
  void parallelWithResult() {
    Scheduler scheduler = Schedulers.fromExecutor(Executors.newFixedThreadPool(4));
    Flux<String> ids = ifhrIds();

    Flux<String> combinations =
        ids.parallel()
            .runOn(scheduler)
            .flatMap(id -> {
              Mono<String> nameTask = ifhrName(id);
              Mono<Integer> statTask = ifhrStat(id);
              System.out.println(Thread.currentThread().getName());
              if ("a".equals(id)) {
                return Mono.empty();
              } else {
                return nameTask;
              }
//          return Mono.empty();
//          return nameTask.zipWith(statTask, (name, stat) -> "Name " + name + " has stats " + stat);
            }).sequential();

    Mono<List<String>> result = combinations.collectList();

    List<String> results = result.block();
    System.out.println(results);
  }

  private Mono<Integer> ifhrStat(String id) {
    return Mono.just(id.hashCode());
  }

  private Mono<String> ifhrName(String id) {
    return Mono.just(id + "ifhrName");
  }

  private Flux<String> ifhrIds() {
    return Flux.just("a", "b", "c");
  }

  private void blockingTask(int i) throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " -> " + i);
    TimeUnit.MILLISECONDS.sleep(10L);
  }

  public static void print(String s) {
    System.out.println(Thread.currentThread().getName() + " > " + s);
  }

}
