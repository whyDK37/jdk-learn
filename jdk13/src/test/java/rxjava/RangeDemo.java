package rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import org.junit.jupiter.api.Test;

public class RangeDemo {

  @Test
  void range() {
    String greeting = "Hello World!";

    Observable<Integer> indexes = Observable.range(0, greeting.length());

    Observable<Character> characters = indexes.map(new Function<Integer, Character>() {
      @Override
      public Character apply(Integer integer) throws Exception {
        return greeting.charAt(integer);
      }
    });

    characters.subscribe(System.out::println, Throwable::printStackTrace,
        System.out::println);
  }

}
