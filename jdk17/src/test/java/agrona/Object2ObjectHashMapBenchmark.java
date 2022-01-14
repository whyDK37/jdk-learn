package agrona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.agrona.collections.Object2ObjectHashMap;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * <pre>
 *
 * Benchmark                                         (n)  Mode  Cnt      Score      Error  Units
 * Object2ObjectHashMapBenchmark.Object2ObjectHash     5  avgt   25    158.503 ±   11.193  ns/op
 * Object2ObjectHashMapBenchmark.Object2ObjectHash    10  avgt   25    361.243 ±   32.335  ns/op
 * Object2ObjectHashMapBenchmark.Object2ObjectHash    25  avgt   25    771.581 ±   40.158  ns/op
 * Object2ObjectHashMapBenchmark.Object2ObjectHash    50  avgt   25   1661.937 ±   98.615  ns/op
 * Object2ObjectHashMapBenchmark.Object2ObjectHash    75  avgt   25   3224.569 ±  464.121  ns/op
 * Object2ObjectHashMapBenchmark.Object2ObjectHash   100  avgt   25   4330.793 ±  456.277  ns/op
 * Object2ObjectHashMapBenchmark.Object2ObjectHash   150  avgt   25   5100.925 ±  165.733  ns/op
 * Object2ObjectHashMapBenchmark.Object2ObjectHash   500  avgt   25  12798.152 ±  527.451  ns/op
 * Object2ObjectHashMapBenchmark.Object2ObjectHash  1000  avgt   25  27566.619 ± 1114.536  ns/op
 * Object2ObjectHashMapBenchmark.hashMap               5  avgt   25    123.715 ±   10.751  ns/op
 * Object2ObjectHashMapBenchmark.hashMap              10  avgt   25    251.019 ±   26.752  ns/op
 * Object2ObjectHashMapBenchmark.hashMap              25  avgt   25    818.614 ±   66.063  ns/op
 * Object2ObjectHashMapBenchmark.hashMap              50  avgt   25   2097.781 ±  310.467  ns/op
 * Object2ObjectHashMapBenchmark.hashMap              75  avgt   25   2897.500 ±  158.146  ns/op
 * Object2ObjectHashMapBenchmark.hashMap             100  avgt   25   5424.873 ±  813.870  ns/op
 * Object2ObjectHashMapBenchmark.hashMap             150  avgt   25   5627.925 ±  296.040  ns/op
 * Object2ObjectHashMapBenchmark.hashMap             500  avgt   25  20609.286 ± 1240.668  ns/op
 * Object2ObjectHashMapBenchmark.hashMap            1000  avgt   25  52135.222 ± 2712.547  ns/op
 *
 * Process finished with exit code 0
 *
 *
 *
 * </pre>
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Object2ObjectHashMapBenchmark {

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(Object2ObjectHashMapBenchmark.class.getSimpleName())
        .resultFormat(ResultFormatType.JSON)
        .result("D:/Object2ObjectHashMapBenchmark-" + System.currentTimeMillis() + ".json")
        .forks(1)
        .build();

    new Runner(opt).run();
  }

  @Param({"5", "10", "25", "50", "75", "100", "150", "500", "1000"})
  int n = 100;
  List<Value> data;

  @Setup
  public void init() {
    data = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      data.add(new Value(i * 1001, i));
    }
    Collections.shuffle(data);
  }

  public static class Value {

    int key, value;

    public Value(int key, int value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Value value1 = (Value) o;
      return key == value1.key &&
          value == value1.value;
    }

    @Override
    public int hashCode() {
      return Objects.hash(key, value);
    }
  }

  @Benchmark
  public void hashMap(Blackhole b) {
    HashMap<Object, Object> map = new HashMap<>();
    for (int i = 0; i < data.size(); i++) {
      Value value = data.get(i);
      b.consume(map.put(value.key, value.value));
    }
  }

  @Benchmark
  public void Object2ObjectHash(Blackhole b) {
    Object2ObjectHashMap<Object, Object> map = new Object2ObjectHashMap<>();
    for (int i = 0; i < data.size(); i++) {
      Value value = data.get(i);
      b.consume(map.put(value.key, value.value));
    }
  }
}
