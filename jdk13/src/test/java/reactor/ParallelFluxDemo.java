package reactor;


import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
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

  private void blockingTask(int i) throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " -> " + i);
    TimeUnit.MILLISECONDS.sleep(10L);
  }

  public static void print(String s) {
    System.out.println(Thread.currentThread().getName() + " > " + s);
  }

}
