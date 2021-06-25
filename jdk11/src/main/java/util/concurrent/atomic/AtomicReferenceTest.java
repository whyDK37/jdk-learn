package util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

  public static void main(String[] args) {
    SensitiveValue sensitiveValue = new SensitiveValue("main");
    System.out.println(sensitiveValue.getValue());
    System.out.println(sensitiveValue.getValue());

  }

  static final class SensitiveValue{
    private transient final AtomicReference<String> value;

    SensitiveValue(String value) {
      this.value = new AtomicReference<>(value);
    }

    public String getValue(){
      return value.getAndSet(null);
    }
  }

}
