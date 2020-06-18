package guava;

import com.google.common.collect.ForwardingList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddLoggingList<E> extends ForwardingList<E> {

  // backing list
  final List<E> delegate;

  public AddLoggingList(List<E> delegate) {
    this.delegate = delegate;
  }

  public static void main(String[] args) {
    AddLoggingList<Integer> addLoggingList = new AddLoggingList<>(new ArrayList<>());
    addLoggingList.add(0, 1);
  }

  @Override
  protected List<E> delegate() {
    return delegate;
  }

  @Override
  public void add(int index, E elem) {
    System.out.println("log:" + index + "->" + elem);
    super.add(index, elem);
  }

  @Override
  public boolean add(E elem) {
    return standardAdd(elem); // implements in terms of add(int, E)
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    return standardAddAll(c); // implements in terms of add
  }
}
