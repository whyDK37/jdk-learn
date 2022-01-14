package reactor;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class ParallelFluxDemo {

  public static void print(String s) {
    System.out.println(Thread.currentThread().getName() + " > " + s);
  }

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
    ExecutorService executor = Executors.newFixedThreadPool(40);
    Scheduler scheduler = Schedulers.fromExecutor(executor);
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 27244; i++) {
      list.add(i + "");
    }
    Flux<String> ids = Flux.fromIterable(list);

    Flux<String> combinations =
        ids.parallel(10)
            .runOn(scheduler)
            .flatMap(id -> {
              Mono<String> nameTask = ifhrName(id);
              Mono<Integer> statTask = ifhrStat(id);
              if ("a".equals(id)) {
                return Mono.just(Thread.currentThread().getName());
              } else {
                return Mono.just(Thread.currentThread().getName() + " " + id);
              }
//          return Mono.empty();
//          return nameTask.zipWith(statTask, (name, stat) -> "Name " + name + " has stats " + stat);
            }).sequential();

    Mono<List<String>> result = combinations.collectList();

    List<String> results = result.block();
    results.forEach(System.out::println);
    executor.shutdown();
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

}
