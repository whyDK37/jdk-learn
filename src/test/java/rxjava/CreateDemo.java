package rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class CreateDemo {

  @Test
  void create() throws InterruptedException {
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    ObservableOnSubscribe<String> handler = emitter -> {

      Future<Object> future = executor.schedule(() -> {
        emitter.onNext("Hello");
        emitter.onNext("World");
        emitter.onComplete();
        return null;
      }, 1, TimeUnit.SECONDS);

      emitter.setCancellable(() -> future.cancel(false));
    };

    Observable<String> observable = Observable.create(handler);

    observable.subscribe(System.out::println, Throwable::printStackTrace,
        () -> System.out.println("Done"));
    observable.subscribe(System.out::println, Throwable::printStackTrace,
        () -> System.out.println("Done2"));

    Thread.sleep(2000);
    executor.shutdown();
  }
}
