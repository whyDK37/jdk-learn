package reactor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class FluxDemo {

  CoreSubscriber<Integer> subscriber = new CoreSubscriber<>() {//这里传入CoreSubscriber对象作为订阅者
    @Override
    public void onSubscribe(Subscription s) {
      System.out.println("onSubscribe, " + s.getClass());
      s.request(5);
    }

    @Override
    public void onNext(Integer integer) {
      System.out.println("onNext：" + integer);
    }

    @Override
    public void onError(Throwable t) {
    }

    @Override
    public void onComplete() {
      System.out.println("onComplete");
    }
  };

  @Test
  public void pubSub() {
    Flux<String> seq1 = Flux.just("foo", "bar", "foobar");

    List<String> iterable = Arrays.asList("foo", "bar", "foobar");

    Flux<String> seq2 = Flux.fromIterable(iterable);

    Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 3);

    Mono<String> noData = Mono.empty();

    Mono<String> data = Mono.just("foo");
  }

  @Test
  public void subscribe() {

    Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        .subscribe(subscriber);
  }

  @Test
  public void testMap() {
    Flux.just(1, 2, 3, 4, 5)
        .map(i -> i * i)
        .subscribe(subscriber);
  }

  @Test
  public void publishOn() throws InterruptedException {
    Flux.just(1, 2, 3, 4, 5)
        .publishOn(Schedulers.elastic())
        .doOnNext(new Consumer<Integer>() {
          @Override
          public void accept(Integer integer) {
            System.out.println("next " + Thread.currentThread().getName());
          }
        }).subscribe(new Consumer<Integer>() {
      @Override
      public void accept(Integer integer) {
        System.out.println("subscribe " + Thread.currentThread().getName());
      }
    });

    TimeUnit.SECONDS.sleep(10);
  }
}
