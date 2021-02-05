package jmh;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * 基于JMH检验多种生成随机数方法的效率
 * https://www.codetd.com/article/8564538
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Threads(50)
@Fork(1)
@Warmup(iterations = 3, time = 5)
@Measurement(iterations = 3, time = 5)

public class RandomBenchmark {

  Random random = new Random();
  ThreadLocal<Random> randomThreadLocalHolder = ThreadLocal.withInitial(Random::new);

  @Benchmark
  public int random() {
    return random.nextInt();
  }


  @Benchmark
  public int threadLocalRandom() {
    return ThreadLocalRandom.current().nextInt();
  }

  @Benchmark
  public int randomThreadLocalHolder() {
    return randomThreadLocalHolder.get().nextInt();
  }

  @Benchmark
  public int nettyRandomThreadLocal() {
    return io.netty.util.internal.ThreadLocalRandom.current().nextInt();
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder().include(RandomBenchmark.class.getSimpleName()).build();
    new Runner(opt).run();
  }

}