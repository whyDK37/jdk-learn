package guava;

import com.google.common.collect.ForwardingList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author why
 */
public class ForwardingDemo {

  public static void main(String[] args) {
    List<Integer> integers = new ForwardingList<Integer>() {
      @Override
      protected List<Integer> delegate() {
        return new ArrayList<>();
      }
    };

    integers.add(1);
  }
}
