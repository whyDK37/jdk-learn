package reactor;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoCreator {

  @Test
  void create() {
    Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
    Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
    Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
  }
}
