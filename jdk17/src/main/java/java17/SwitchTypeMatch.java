package java17;

public class SwitchTypeMatch {

  public static void main(String[] args) {

    testFooBar(null);

    System.out.println(formatterPatternSwitch(1));
    System.out.println(formatterPatternSwitch(1L));
    System.out.println(formatterPatternSwitch(1.1));
    System.out.println(formatterPatternSwitch("1.1"));
    System.out.println(formatterPatternSwitch(null));
  }

  static String formatterPatternSwitch(Object o) {
    return switch (o) {
      case Integer i -> String.format("int %d", i);
      case Long l    -> String.format("long %d", l);
      case Double d  -> String.format("double %f", d);
      case String s  -> String.format("String %s", s);
      case null -> String.format("null");
      default        -> o.toString();
    };
  }
  static void testFooBar(String s) {
    switch (s) {
      case null         -> System.out.println("null");
      case "Foo", "Bar" -> System.out.println("Great");
      default           -> System.out.println("Ok");
    }
  }
}
