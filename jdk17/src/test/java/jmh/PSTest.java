package jmh;

import org.openjdk.jmh.annotations.*;

/**
 * Created by 刘绍 on 2020/8/1.
 */
public class PSTest {
    @Benchmark
    @Warmup(iterations = 1,time = 2)
    @Threads(2)
    @Fork(2)
    @BenchmarkMode(Mode.Throughput)
    @Measurement(iterations = 2,time = 2)
    public void testForEach() {
        NumsSum.foreach();
    }
}