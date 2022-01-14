package guava.cache;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class CacheBenchmark {

  @State(Scope.Benchmark)
  public static class CacheState {

    Cache<Integer, String> cache;
    String obj = "object";

    @Setup(Level.Iteration)
    public void setup() throws Exception {
      cache = CacheBuilder.newBuilder()
          .expireAfterAccess(1, TimeUnit.DAYS)
          .build();
    }
  }

  @Benchmark
  public void test(CacheState state, Blackhole bh) throws Exception {
    System.out.println(state.cache);
    bh.consume(state.cache.get(Objects.hashCode(state.obj), () -> "ok"));
  }
}