package rxjava;

import io.reactivex.Flowable;
import org.junit.jupiter.api.Test;

public class GenerateDemo {

  @Test
  void generate() {
    int startValue = 1;
    int incrementValue = 1;
    Flowable<Integer> flowable = Flowable.generate(() -> startValue, (s, emitter) -> {
      int nextValue = s + incrementValue;
      emitter.onNext(nextValue);
      return nextValue;
    });
    flowable.subscribe(System.out::println);
  }
}
