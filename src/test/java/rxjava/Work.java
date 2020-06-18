package rxjava;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Work {

  private void Background_computation() throws InterruptedException {
    // method 1
    Flowable.fromCallable(() -> {
      Thread.sleep(1000); //  imitate expensive computation
      return "do over";
    })
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.single())
        .subscribe(System.out::println, Throwable::printStackTrace);
    // 由于处理异步，需要等待异步执行完成再结束主线程
    Thread.sleep(2000); // <--- wait for the flow to finish
  }

}