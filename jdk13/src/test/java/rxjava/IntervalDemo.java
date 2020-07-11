package rxjava;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class IntervalDemo {

  @Test
  void interval() throws InterruptedException {
    Observable<Long> clock = Observable.interval(1, TimeUnit.SECONDS);

    clock.subscribe(time -> {
      if (time % 2 == 0) {
        System.out.println("Tick");
      } else {
        System.out.println("Tock");
      }
    });

    TimeUnit.SECONDS.sleep(5);
  }

}
