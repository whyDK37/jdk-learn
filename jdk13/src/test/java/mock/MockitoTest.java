package mock;

import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MockitoTest {

  @Test
  public void spyList() throws InterruptedException {
    List<Integer> spyList = spy(List.class);

    System.out.println("spy 对象，只有 mock 的方法才会被替换，没有 mock 的调用原对象的实现");
    when(spyList.get(0)).thenReturn(0);
    spyList.add(1);
    spyList.add(1);
    System.out.println("spyList.get(0) = " + spyList.get(0));
    System.out.println("spyList.get(1) = " + spyList.get(1));

  }

  @Test
  public void mockList() {

    List mockedList = mock(List.class);
    when(mockedList.get(0)).thenReturn(0);
    when(mockedList.get(1)).thenThrow(new IndexOutOfBoundsException("mocked"));

    Assertions.assertSame(0, mockedList.get(0));
    //输出null, 这是因为get(999)没有被mock
    Assertions.assertSame(null, mockedList.get(999));
    //抛异常
    Exception exception = null;
    try {
      System.out.println(mockedList.get(1));
    } catch (Exception e) {
      e.printStackTrace();
      exception = e;
    }
    Assertions.assertNotNull(exception);
    exception = null;

    doThrow(new RuntimeException()).when(mockedList).clear();
//following throws RuntimeException:
    try {
      mockedList.clear();
    } catch (Exception e) {
      e.printStackTrace();
      exception = e;
    }
    Assertions.assertNotNull(exception);


  }

  private Object isValid() {
    return "self";
  }
}