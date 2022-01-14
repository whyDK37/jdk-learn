package reactor;

import com.google.common.collect.Lists;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * https://www.woolha.com/tutorials/project-reactor-processing-flux-in-parallel
 */
public class ParallelProcess {

  @Test
  void sequential() {
    Flux.range(1, 99)
        .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
  }

  @Test
  void parallel() throws InterruptedException {
    Scheduler scheduler = Schedulers.fromExecutor(Executors.newFixedThreadPool(4));
    Flux.range(1, 99)
        .parallel(4)
        .runOn(scheduler)
        .checkpoint("do subscribe")
        .doOnNext(System.out::println)
        .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));

    System.out.println("done...");
  }

  public static void main(String[] args) {

    Scheduler scheduler = Schedulers.fromExecutor(Executors.newFixedThreadPool(4));
    Flux<Integer> integerFlux = Flux.fromIterable(Lists.newArrayList(1, 2, 3));

    integerFlux.parallel()
        .runOn(scheduler)
        .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));

    Mono<List<Integer>> listMono = integerFlux.collectList();
    System.out.println(listMono.block());

    System.out.println("done");
  }

  @Test
  public void parallelFluxToFlux() {
    Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

    Flux<Integer> ids = Flux.range(1, 999);//new String[]{"11", "1", "2", "3"});

    Flux<String> combinations = ids.parallel(3)
        .runOn(s)
        .flatMap(id -> {
          Mono<String> nameTask = ifhrName(id);
          Mono<Integer> statTask = ifhrStat(id);

          return nameTask.zipWith(statTask,
              (name, stat) -> {
                System.out.println(Thread.currentThread().getName());
                return "" + name + " has stats " + stat;
              });
        }).sorted(Comparator.naturalOrder());

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
