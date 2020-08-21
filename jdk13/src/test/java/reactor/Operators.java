package reactor;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

public class Operators {

  public static void main(String[] args) {
//        printLine("buffer");
    buffer();
//        printLine("filter");
//        filter();
//        printLine("window");
//        window();
//        printLine("zipWith");
    zipWith();
//        printLine("take");
//        take();
//        printLine("reduce");
//        reduce();
//        printLine("merge");
//        merge();
//        printLine("flatMap");
//        flatMap();
//        printLine("concatMap");
//        concatMap();
//        printLine("combineLatest");
    combineLatest();
  }

  private static void buffer() {
    Flux.range(1, 100).buffer(10).subscribe(System.out::println);
    Flux.interval(Duration.ofMillis(100)).buffer(Duration.ofMillis(1001)).take(1).toStream()
        .forEach(
            System.out::println);
    Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
    Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);
    Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
  }

  private static void filter() {
    Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
  }

  private static void window() {
    Flux.range(1, 100).window(20).subscribe(System.out::println);
    Flux.interval(Duration.ofMillis(100)).window(Duration.ofMillis(1001)).take(2).toStream()
        .forEach(
            System.out::println);
  }

  private static void zipWith() {
    Flux<Tuple2<String, String>> tuple2Flux = Flux.just("a", "b")
        .zipWith(Flux.just("c", "d"));
    System.out.println(tuple2Flux.take(2).blockFirst().getT2());

    Flux.just("a", "b")
        .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
        .subscribe(System.out::println);
  }

  private static void take() {
    Flux.range(1, 1000).take(10).subscribe(System.out::println);
    Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
    Flux.range(1, 1000).takeWhile(i -> i < 10).log("wdh").subscribe(System.out::println);
    Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);
  }

  private static void reduce() {
    Flux.range(1, 100).reduce(Integer::sum).subscribe(System.out::println);
    Flux.range(1, 100).reduceWith(() -> 100, Integer::sum).subscribe(System.out::println);

    List<Reduce> list = new ArrayList<Reduce>();
    list.add(new Reduce(1, 222));
    list.add(new Reduce(1, 111));
    list.add(new Reduce(1, 444));

    Mono<Reduce> reduce = Flux
        .fromStream(list.stream())
        .reduce((x, y) -> new Reduce((x.getCount() + y.getCount()), (x.getFee() + y.getFee())));
    System.out.println(reduce.block().getCount());

    long start1 = System.currentTimeMillis();
    Flux.fromStream(list.stream())
        .reduce((x, y) -> new Reduce((x.getCount() + y.getCount()), (x.getFee() + y.getFee())))
        .subscribe(new Subscriber<Reduce>() {
          @Override
          public void onSubscribe(Subscription subscription) {
            // subscription 表示订阅关系
            System.out.println("onSubscribe," + subscription.getClass());
            subscription.request(0);
          }

          @Override
          public void onNext(Reduce reduce) {
            System.out.println("wdh---->" + reduce.getFee());
          }

          @Override
          public void onError(Throwable t) {

          }

          @Override
          public void onComplete() {
            System.out.println("完成");
            System.out.println((System.currentTimeMillis() - start1));
          }
        });

    long start = System.currentTimeMillis();
    Reduce a = list.stream()
        .reduce((x, y) -> new Reduce((x.getCount() + y.getCount()), (x.getFee() + y.getFee())))
        .orElse(new Reduce(0, 0));
    System.out.println((System.currentTimeMillis() - start));
  }

  private static void merge() {
    Flux.merge(Flux.interval(Duration.ofMillis(0), Duration.ofMillis(100)).take(5), Flux
        .interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5))
        .toStream()
        .forEach(System.out::println);
    Flux.mergeSequential(Flux.interval(Duration.ofMillis(0), Duration.ofMillis(10000)).take(5), Flux
        .interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5))
        .toStream()
        .forEach(System.out::println);
  }

  private static void flatMap() {

    Flux<Long> longFlux = Flux.fromIterable(Arrays.asList(1, 2, 3, 4, 5))
        .flatMap(x -> Flux.interval(Duration.ofMillis(x * 10), Duration.ofMillis(100)).take(x));
    Mono<List<Long>> mono = longFlux.collectList();
    System.out.println(mono.block());
    Flux.just(5, 10)
        .flatMapSequential(
            x -> Flux.interval(Duration.ofMillis(x * 10), Duration.ofMillis(100)).take(x))
        .toStream()
        .forEach(System.out::println);
  }

  private static void concatMap() {
    Flux.just(5, 10)
        .concatMap(x -> Flux.interval(Duration.ofMillis(x * 10), Duration.ofMillis(100)).take(x))
        .toStream()
        .forEach(System.out::println);
  }

  private static void combineLatest() {
    Flux.combineLatest(
        Arrays::toString,
        Flux.interval(Duration.ofMillis(1000)).take(5),
        Flux.interval(Duration.ofMillis(50), Duration.ofMillis(10000)).take(5)
    ).toStream().forEach(System.out::println);
    Flux.interval(Duration.ofMillis(100)).take(1).toStream().forEach(System.out::println);
  }

  private static void printLine(final String operator) {
    System.out.printf("%s %s %s%n",
        "***",
        operator,
        "***"
    );
  }

  static class Reduce {

    int count = 0;
    int fee = 0;

    public Reduce(int count, int fee) {
      super();
      this.count = count;
      this.fee = fee;
    }

    public Reduce() {
      super();
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    public int getFee() {
      return fee;
    }

    public void setFee(int fee) {
      this.fee = fee;
    }

    @Override
    public String toString() {
      return " [count=" + count + ", fee=" + fee + "]";
    }

  }
}
