package lang.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Deque;
import java.util.LinkedList;

public class WeakReferenceDemo {

  private static final ReferenceQueue<Data> REFERENCE_QUEUE = new ReferenceQueue<>();

  private static void checkQueue() throws InterruptedException {
    Reference<? extends Data> inq = REFERENCE_QUEUE.remove();
    if (inq != null) {
      System.out.println("queue remove---" + inq.getClass().getSimpleName());
    }
  }

  public static void main(String[] args) {
    //另起一个线程监视REFERENCE_QUEUE
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          while (true) {
            checkQueue();
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    thread.setDaemon(false);
    thread.start();

///////////////////////////////////////////////////////////////////////////////////
    /*
     * SoftReference:在内存不足时才会回收这样软引用对象
     * */
//    Deque<SoftReference<Data>> sa = new LinkedList<>();
//    for (int i = 0; i < 5; i++) {
//      sa.add(new MySoftReference(new Data("Soft " + i), REFERENCE_QUEUE));
//      System.out.println("created---" + sa.getLast().get());
//    }
//
//    //由于无法触发内存不足，这里手动回收软引用。
//    for (SoftReference<Data> reference : sa) {
//      reference.clear();
//      //clear()方法不会enqueue，所以需要手动入队。
//      reference.enqueue();
//    }

///////////////////////////////////////////////////////////////////////////////////
    /*
     * WeakReference:在GC发现只具有弱引用的对象会立即对其会回收
     * */
    Deque<MyWeakReference<Data>> wa = new LinkedList<>();
    for (int i = 0; i < 5; i++) {
      wa.add(new MyWeakReference(new Data("Weak " + i), REFERENCE_QUEUE));
      System.out.println("created---" + wa.getLast().get());
    }

///////////////////////////////////////////////////////////////////////////////////
//    Deque<MyPhantomReference<Data>> pa = new LinkedList<>();
//    for (int i = 0; i < 5; i++) {
//      pa.add(new MyPhantomReference(new Data("Phantom " + i), REFERENCE_QUEUE));
//      System.out.println("created---" + pa.getLast());
//    }

///////////////////////////////////////////////////////////////////////////////////
//        System.gc(); //第一次gc
///////////////////////////////////////////////////////////////////////////////////
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.gc();//第二次gc
///////////////////////////////////////////////////////////////////////////////////
//        sa.clear();
//        pa.clear();
//        wa.clear();
//        System.gc();//第三次gc
///////////////////////////////////////////////////////////////////////////////////
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.gc();//第四次gc
  }
}

class MySoftReference<T> extends SoftReference<T> {

  public MySoftReference(T referent, ReferenceQueue<? super T> q) {
    super(referent, q);
  }

  @Override
  protected void finalize() {
    System.out.println("finalize---MySoftReference");
  }
}

class MyWeakReference<T> extends WeakReference<T> {

  MyWeakReference(T referent, ReferenceQueue<? super T> q) {
    super(referent, q);
  }

  @Override
  protected void finalize() {
    System.out.println("finalize---MyWeakReference");
  }
}

class MyPhantomReference<T> extends PhantomReference<T> {

  MyPhantomReference(T referent, ReferenceQueue<? super T> q) {
    super(referent, q);
  }

  @Override
  protected void finalize() {
    System.out.println("finalize---MyPhantomReference");
  }
}

class Data {

  private final String id;

  Data(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return id;
  }

  @Override
  protected void finalize() {
    System.out.println("finalize data---" + id);
  }
}
