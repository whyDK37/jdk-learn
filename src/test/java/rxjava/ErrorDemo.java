package rxjava;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import org.junit.jupiter.api.Test;

public class ErrorDemo {

  @Test
  void error() {
    Observable<String> error = Observable.error(new IOException());

    error.subscribe(
        v -> System.out.println("This should never be printed!"),
        Throwable::printStackTrace,
        () -> System.out.println("This neither!"));


  }

  @Test
  void errorResumeNext() {
    Observable<String> observable = Observable.fromCallable(() -> {
      if (Math.random() < 0.5) {
        throw new IOException();
      }
      throw new IllegalArgumentException();
    });

    Observable<String> result = observable.onErrorResumeNext(error -> {
      if (error instanceof IllegalArgumentException) {
        return Observable.empty();
      }
      return Observable.error(error);
    });

    for (int i = 0; i < 10; i++) {
      result.subscribe(
          v -> System.out.println("This should never be printed!"),
          Throwable::printStackTrace,
          () -> System.out.println("Done"));
    }
  }

  @Test
  void doOnError() {
    Observable.error(new IOException("Something went wrong"))
        .doOnError(error -> System.err.println("The error message is: " + error.getMessage()))
        .subscribe(
            x -> System.out.println("onNext should never be printed!"),
            Throwable::printStackTrace,
            () -> System.out.println("onComplete should never be printed!"));
  }

  @Test
  void onErrorComplete() {
    Completable.fromAction(() -> {
      throw new IOException();
    }).onErrorComplete(error -> {
      // Only ignore errors of type java.io.IOException.
      return error instanceof IOException;
    }).subscribe(
        () -> System.out.println("IOException was ignored"),
        error -> System.err.println("onError should not be printed!"));
  }

  @Test
  void onErrorResumeNext() {
    Observable<Integer> numbers = Observable.generate(() -> 1, (state, emitter) -> {
      emitter.onNext(state);

      return state + 1;
    });

    numbers.scan(Math::multiplyExact)
        .onErrorResumeNext(Observable.empty())
        .subscribe(
            System.out::println,
            error -> System.err.println("onError should not be printed!"));
  }

  @Test
  void onErrorReturn() {
    Single.just("2A")
        .map(v -> Integer.parseInt(v, 10))
        .onErrorReturn(error -> {
          if (error instanceof NumberFormatException) {
            return 0;
          } else {
            throw new IllegalArgumentException();
          }
        })
        .subscribe(
            System.out::println,
            error -> System.err.println("onError should not be printed!"));
  }

  @Test
  void onErrorReturnItem() {
    Single.just("2A")
        .map(v -> Integer.parseInt(v, 10))
        .onErrorReturnItem(0)
        .subscribe(
            System.out::println,
            error -> System.err.println("onError should not be printed!"));
  }

  @Test
  void retry() {
    Observable<Long> source = Observable.interval(0, 1, TimeUnit.SECONDS)
        .flatMap(x -> {
          if (x >= 2) {
            return Observable.error(new IOException("Something went wrong!"));
          } else {
            return Observable.just(x);
          }
        });

    source.retry((retryCount, error) -> retryCount < 3)
        .blockingSubscribe(
            x -> System.out.println("onNext: " + x),
            error -> System.err.println("onError: " + error.getMessage()));
  }

  @Test
  void retryUntil() {
    LongAdder errorCounter = new LongAdder();
    Observable<Long> source = Observable.interval(0, 1, TimeUnit.SECONDS)
        .flatMap(x -> {
          if (x >= 2) {
            return Observable.error(new IOException("Something went wrong!"));
          } else {
            return Observable.just(x);
          }
        })
        .doOnError((error) -> errorCounter.increment());

    source.retryUntil(() -> errorCounter.intValue() >= 3)
        .blockingSubscribe(
            x -> System.out.println("onNext: " + x),
            error -> System.err.println("onError: " + error.getMessage()));
  }

  @Test
  void retryWhen() {
    Observable<Long> source = Observable.interval(0, 1, TimeUnit.SECONDS)
        .flatMap(x -> {
          if (x >= 2) {
            return Observable.error(new IOException("Something went wrong!"));
          } else {
            return Observable.just(x);
          }
        });

    source.retryWhen(errors -> {
      return errors.map(error -> 1)

          // Count the number of errors.
          .scan(Math::addExact)

          .doOnNext(errorCount -> System.out.println("No. of errors: " + errorCount))

          // Limit the maximum number of retries.
          .takeWhile(errorCount -> errorCount < 3)

          // Signal resubscribe event after some delay.
          .flatMapSingle(errorCount -> Single.timer(errorCount, TimeUnit.SECONDS));
    }).blockingSubscribe(
        x -> System.out.println("onNext: " + x),
        Throwable::printStackTrace,
        () -> System.out.println("onComplete"));
  }

}
