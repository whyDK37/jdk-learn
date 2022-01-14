package util.function;

import java.util.function.Predicate;

public class PredicateDemo {

  public static void main(String[] args) {
    Predicate<String> equal = Predicate.isEqual("1");
    System.out.println(equal.equals(1));
  }

}
