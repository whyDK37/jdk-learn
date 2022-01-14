package guava.common.util.concurrent;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.collections4.CollectionUtils;

public class ListFutureDemo {

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, TimeoutException {

    ListeningExecutorService executorService = MoreExecutors.listeningDecorator(
        Executors.newFixedThreadPool(4));

    List<ListenableFuture<Integer>> futures = new ArrayList<>();

    futures.add(executorService.submit(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        return null;
      }
    }));
    futures.add(executorService.submit(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(15);
        if (true) {
          throw new RuntimeException("run time");
        }
        return 1;
      }
    }));

    final ListenableFuture<List<Integer>> resultsFuture = Futures.allAsList(futures);
    final ListenableFuture<List<Integer>> resultsFutureSuccess = Futures.successfulAsList(futures);

    List<Integer> responsesSuccess = new ArrayList<>(
        resultsFutureSuccess.get(10L, TimeUnit.SECONDS));
    System.out.println("responsesSuccess = " + responsesSuccess);
    responsesSuccess.removeIf(Objects::isNull);
    if (CollectionUtils.isEmpty(responsesSuccess)) {
      try {
        resultsFuture.get(10L, TimeUnit.SECONDS);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }


  }

}
