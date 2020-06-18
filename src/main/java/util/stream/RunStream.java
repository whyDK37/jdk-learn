package util.stream;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * <pre>
 *
 * stream 的调用原理
 * 1. 所有操作是链式调用，一个元素之访问一次
 * 2. 每一个中间操作流返回一个新的流
 *    流里有一个属性 sourceStage 执行一个地方，就是 Head
 * 3. Head->nextStage->nextStage->... -> null  这就是链表操作
 * 4. 有状态操作会把无状态截断，处理完之后再继续执行
 * 5. 并行环境下，有状态的中间操作不一定都会并行操作
 * 6. parallel/ sequetial 这两个操作也是中间操作（也是返回stream）
 *    但是不创建流，只修改 head 的并行标记
 * </pre>
 */
public class RunStream {

  public static void main(String[] args) throws InterruptedException {
    Random random = new Random();
    // 随机生成数字
    Stream<Integer> stream = Stream.generate(random::nextInt)
        // 无限流需要短路操作
        .limit(5)
        // 第一个无状态操作
        .peek(s -> print("peek: " + s))
        // 第二个无状态操作
        .filter(s -> {
          print("filter: " + s);
          return s > 0;
        })
        //
        .sorted((i1, i2) -> {
          print("排序: " + i1 + ", " + i2);
          return i1.compareTo(i2);
        })
        // 调试
        .peek(s -> print("peek2: " + s))
        .parallel()
//        .filter(s -> true)
//        .parallel()
        ;

    // 终止操作
    System.out.println("stream.count() = " + stream.count());
    TimeUnit.SECONDS.sleep(2L);
  }

  /**
   * @param s
   */
  public static void print(String s) {
    System.out.println(Thread.currentThread().getName() + " > " + s);
    try {
      TimeUnit.MILLISECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
