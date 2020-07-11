package util.concurrent;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class VolatileDemo2 {

  //    static int flag = 0;
  static int flag = 0;

  public static void main(String[] args) {
    new Thread() {

      public void run() {
        int localFlag = flag;
        while (true) {
//                    可以使用 synchronized 关键字在读取值的代码块强制同步内存数据。
          synchronized (this) {
            if (localFlag != flag) {
              System.out.println("读取到了修改后的标志位：" + flag);
              localFlag = flag;
            }
          }
        }
      }

      ;

    }.start();

    new Thread(() -> {
      int localFlag = flag;
      while (true) {
        System.out.println("标志位被修改为了：" + ++localFlag);
        flag = localFlag;
        try {
          TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();
  }

}
