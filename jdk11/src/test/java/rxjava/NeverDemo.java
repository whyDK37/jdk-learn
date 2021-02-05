package rxjava;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

public class NeverDemo {

  @Test
  void never() {
    Observable<String> never = Observable.never();

    never.subscribe(
        v -> System.out.println("This should never be printed!"),
        error -> System.out.println("Or this!"),
        () -> System.out.println("This neither!"));
  }

}
