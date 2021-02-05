package util.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    ForkJoinPool forkJoinPool = new ForkJoinPool();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 440000; i++) {
      list.add(1);
    }

    BatchInsertTask batchInsertTask = new BatchInsertTask(list, 25);
    long t1 = System.currentTimeMillis();
    ForkJoinTask<Integer> reslut = forkJoinPool.submit(batchInsertTask);
    System.out.println(reslut.get());
    long t2 = System.currentTimeMillis();
    System.out.println(t2 - t1);
  }

}

class BatchInsertTask extends RecursiveTask<Integer> {

  List<Integer> records;
  int minSize;

  public BatchInsertTask(List<Integer> records, int minSize) {
    this.records = records;
    this.minSize = minSize;
  }

  @Override
  protected Integer compute() {
    //当要插入的数据少于3，则直接插入
    if (records.size() <= this.minSize) {
      return computeDirectly();
    } else {
      //如果要插入的数据大于等于3，则进行分组插入
      int size = records.size();

      //第一个分组
      BatchInsertTask aTask = new BatchInsertTask(records.subList(0, size / 2), this.minSize);
      //第二个分组
      BatchInsertTask bTask = new BatchInsertTask(records.subList(size / 2, records.size()),
          this.minSize);
      //两个任务并发执行起来
      invokeAll(aTask, bTask);
      invokeAll();
      //两个分组的插入的行数加起来
      return aTask.join() + bTask.join();
    }
  }

  /**
   * 真正插入数据的逻辑
   */
  private int computeDirectly() {
//        try {
//            Thread.sleep((long) (100));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    System.out
        .println(Thread.currentThread().getName() + ",插入了：" + Arrays.toString(records.toArray()));
    return records.size();
  }
}