package rxjava;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class HelloWorld {

  public static void main(String[] args) {
    String greeting = "Hello world!";

    Observable<String> observable = Observable.just(greeting);

    observable.subscribe(item -> System.out.println(item));


  }

  public static void hello(String... args) {
    Flowable.fromArray(args).subscribe(s -> System.out.println("Hello " + s + "!"));
  }


}