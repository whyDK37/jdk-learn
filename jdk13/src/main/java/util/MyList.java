package util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public interface MyList<E> extends List<E> {

  default void sort(Comparator<? super E> c) {
    Object[] a = this.toArray();
    Arrays.sort(a, (Comparator) c);
    ListIterator<E> i = this.listIterator();
    for (Object e : a) {
      i.next();
      i.set((E) e);
    }
  }
}
