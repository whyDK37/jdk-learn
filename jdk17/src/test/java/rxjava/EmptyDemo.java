package rxjava;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

public class EmptyDemo {

  @Test
  void empty() {
    Observable<String> empty = Observable.empty();

    empty.subscribe(
        v -> System.out.println("This should never be printed!"),
        error -> System.out.println("Or this!"),
        () -> System.out.println("Done will be printed."));
  }

}
