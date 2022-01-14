//package lang;
//
//import org.junit.jupiter.api.Test;
//
//
///**
// * ThreadLocalMap 有两个地方可以回收无用个位置 1. set 方法，if (k == null) 调用  replaceStaleEntry 删除腐朽的对象。 2. getEntry
// * 方法，如果不能直接获取对象，会调用 getEntryAfterMiss方法，循环获取对象。 当 if (k == null) 调用 expungeStaleEntry(i); 擦除腐朽的对象
// */
//class MyThreadLocalMapTest {
//
//  @Test
//  void test() {
//    MyThreadLocalMap<Integer> myThreadLocalMap = new MyThreadLocalMap<>(1, "1");
//    System.out.println(myThreadLocalMap.getEntry(1).value);
//
//    myThreadLocalMap.set(1, "2");
//    System.out.println(myThreadLocalMap.getEntry(1).value);
//
//    myThreadLocalMap.set(17, "17");
//    System.out.println(myThreadLocalMap.getEntry(17).value);
//
//    System.gc();
//    System.out.println(myThreadLocalMap.getEntry(17).value);
//
//    myThreadLocalMap.set(2, "2");
//    System.out.println(myThreadLocalMap.getEntry(2).value);
//
//    myThreadLocalMap.remove(17);
//
//  }
//
//  @Test
//  void modulo() {
//    int i = 2, len = 16;
//    for (i = 0; i < len; i++) {
//      System.out.println(((i + 1 < len) ? i + 1 : 0));
//    }
//  }
//
//}