package reactor;


import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class ParallelFluxBenchmark {


  @Test
  @Benchmark
  @Warmup(iterations = 1, time = 2)
//  @Threads(2)
  @Fork(2)
  @BenchmarkMode(Mode.Throughput)
//  @Measurement(iterations = 2, time = 2)
  public void flux() {
    Flux<String> ids = ifhrIds();

    Flux<String> combinations =
        ids.parallel()
//            .runOn(Schedulers.elastic())
            .flatMap(this::ifhrName).sequential();

    combinations.collectList();
  }

  @Benchmark
  @Warmup(iterations = 1, time = 2)
  @Fork(2)
  @BenchmarkMode(Mode.Throughput)
  public void completableFuture() throws ExecutionException, InterruptedException {

    String[] ids = ids();

    CompletableFuture<String>[] futures = new CompletableFuture[ids.length];
    for (int i = 0; i < ids.length; i++) {
      final String id = ids[i];
      futures[i] = CompletableFuture.supplyAsync(() -> ifhrName(id).block());
    }
    CompletableFuture.allOf(futures).join();
    List<String> names = new ArrayList<>();
    for (CompletableFuture<String> future : futures) {
      names.add(future.get());
    }
  }

  @Benchmark
  @Warmup(iterations = 1, time = 2)
  @Fork(2)
  @BenchmarkMode(Mode.Throughput)
  public void stream() {
    ArrayList<String> strings = Lists.newArrayList(ids());
    strings.parallelStream().map(this::ifhrName)
        .collect(Collectors.toList());
  }

  private Mono<String> ifhrName(String id) {
//    System.out.println(Thread.currentThread().getName());
    return Mono.just(id + "ifhrName");
  }

  private Flux<String> ifhrIds() {
    return Flux.just(ids());
  }

  public String[] ids() {
    return new String[]{"a", "b", "c"};
  }


}
