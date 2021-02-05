package rxjava;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

public class DefferDemo {

  @Test
  void deffer() throws InterruptedException {
    Observable<Long> observable = Observable.defer(() -> {
      long time = System.currentTimeMillis();
      return Observable.just(time);
    });

    observable.subscribe(System.out::println);

    Thread.sleep(1000);

    observable.subscribe(System.out::println);
  }

}
