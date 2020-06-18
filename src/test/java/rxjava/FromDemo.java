package rxjava;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class FromDemo {


  @Test
  public void dispose() throws InterruptedException {
    Disposable d = Observable.just("Hello world!")
        .delay(1, TimeUnit.SECONDS)
        .subscribeWith(new DisposableObserver<>() {
          @Override
          public void onStart() {
            System.out.println("Start!");
          }

          @Override
          public void onNext(String t) {
            System.out.println("onNext:" + t);
          }

          @Override
          public void onError(Throwable t) {
            t.printStackTrace();
          }

          @Override
          public void onComplete() {
            System.out.println("Done!");
          }
        });

    Thread.sleep(500);
    // the sequence can now be disposed via dispose()
    d.dispose();
  }

  @Test
  public void fromIterable() {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

    Observable<Integer> observable = Observable.fromIterable(list);

    observable.subscribe(System.out::println, Throwable::printStackTrace,
        () -> System.out.println("Done"));
  }

  @Test
  public void fromArray() {
    Integer[] array = new Integer[10];
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }

    Observable<Integer> observable = Observable.fromArray(array);

    observable.subscribe(System.out::println, Throwable::printStackTrace,
        () -> System.out.println("Done"));
  }

  @Test
  public void fromCallable() {
    Callable<String> callable = () -> {
      System.out.println("callable Hello World!");
      return "Hello World!";
    };

    Observable<String> observable = Observable.fromCallable(callable);

    observable.subscribe(System.out::println, Throwable::printStackTrace,
        () -> System.out.println("Done"));
  }

  @Test
  public void fromAction() {
    Action action = () -> System.out.println("Hello World!");

    Completable completable = Completable.fromAction(action);

    completable.subscribe(() -> System.out.println("Done"), Throwable::printStackTrace);
  }

  @Test
  public void fromRunnable() {
    Runnable runnable = () -> System.out.println("Hello World!");

    Completable completable = Completable.fromRunnable(runnable);

    completable.subscribe(() -> System.out.println("Done"), Throwable::printStackTrace);
  }

  @Test
  void fromFuture() {
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    Future<String> future = executor.schedule(() -> "Hello world!", 1, TimeUnit.SECONDS);

    Observable<String> observable = Observable.fromFuture(future);

    observable.subscribe(
        System.out::println,
        Throwable::printStackTrace,
        () -> System.out.println("Done"));

    executor.shutdown();
  }

}
