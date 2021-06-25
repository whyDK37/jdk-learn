package util;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionalTest {

  @Test
  public void test(){
    Object o = Optional.ofNullable(null).orElse(null);
    Assertions.assertNull(o);
  }
}
