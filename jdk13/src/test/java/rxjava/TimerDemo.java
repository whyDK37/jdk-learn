package rxjava;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class TimerDemo {

  @Test
  void timer() throws InterruptedException {
    Observable<Long> eggTimer = Observable.timer(2, TimeUnit.SECONDS);

    eggTimer.blockingSubscribe(v -> System.out.println("Egg is ready!"));

  }

}
