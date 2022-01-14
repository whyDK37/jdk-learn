package gson;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;
import gson.GsonTest.A.B;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://github.com/google/gson/blob/master/UserGuide.md#TOC-Overview
 */
public class GsonTest {

  @Test
  void demo() {
    // Serialization
    Gson gson = new Gson();
    gson.toJson(1);            // ==> 1
    gson.toJson("abcd");       // ==> "abcd"
    gson.toJson(new Long(10)); // ==> 10
    int[] values = {1};
    gson.toJson(values);       // ==> [1]

// Deserialization
    int one = gson.fromJson("1", int.class);
    Integer onei = gson.fromJson("1", Integer.class);
    Long onel = gson.fromJson("1", Long.class);
    Boolean falseB = gson.fromJson("false", Boolean.class);
    String str = gson.fromJson("\"abc\"", String.class);
    String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);

    // Serialization
    BagOfPrimitives obj = new BagOfPrimitives();
    String json = gson.toJson(obj);
    System.out.println("json = " + json);
    BagOfPrimitives obj2 = gson.fromJson(json, BagOfPrimitives.class);
  }

  @Test
  void array() {
    Gson gson = new Gson();
    int[] ints = {1, 2, 3, 4, 5};
    String[] strings = {"abc", "def", "ghi"};

// Serialization
    gson.toJson(ints);     // ==> [1,2,3,4,5]
    gson.toJson(strings);  // ==> ["abc", "def", "ghi"]

// Deserialization
    int[] ints2 = gson.fromJson("[1,2,3,4,5]", int[].class);
// ==> ints2 will be same as ints
  }

  @Test
  void collection() {
    Gson gson = new Gson();
    Collection<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5);

// Serialization
    String json = gson.toJson(ints);  // ==> json is [1,2,3,4,5]

// Deserialization
    Type collectionType = new TypeToken<Collection<Integer>>() {
    }.getType();
    Collection<Integer> ints2 = gson.fromJson(json, collectionType);
  }

  @Test
  void SerializingAndDeserializingGenericTypes() {

    Gson gson = new Gson();
    Foo<Bar> foo = new Foo<Bar>();
    foo.value = new Bar();
    foo.value.value = "bar value";

    String json = gson.toJson(foo); // May not serialize foo.value correctly

    try {
      Foo<Bar> foo1 = gson.fromJson(json, foo.getClass());// Fails to deserialize foo.value as Bar
      System.out.println(foo1);
      Bar value = foo1.value;
      Assertions.assertTrue(false);
    } catch (Exception e) {
      e.printStackTrace();
    }

    Type fooType = new TypeToken<Foo<Bar>>() {
    }.getType();
    Foo<Bar> foo2 = gson.fromJson(json, fooType);
    System.out.println("foo2.value.value = " + foo2.value.value);
  }

  @Test
  void SerializingAndDeserializingCollectionWithObjectsOfArbitraryTypes() {
    Collection collection = new ArrayList();
    collection.add("hello");
    collection.add(5);
    collection.add(new Event("GREETINGS", "guest"));

  }


  static class BagOfPrimitives {

    private int value1 = 1;
    private String value2 = "abc";
    private transient int value3 = 3;

    BagOfPrimitives() {
      // no-args constructor
    }
  }

  class A {

    public String a;

    class B {

      public String b;

      public B() {
        // No args constructor for B
      }
    }
  }

  public class InstanceCreatorForB implements InstanceCreator<B> {

    private final A a;

    public InstanceCreatorForB(A a) {
      this.a = a;
    }

    public A.B createInstance(Type type) {
      return a.new B();
    }
  }

  class Foo<T> {

    T value;
  }

  class Bar {

    String value;
  }

  class Event {

    private String name;
    private String source;

    private Event(String name, String source) {
      this.name = name;
      this.source = source;
    }
  }
}
