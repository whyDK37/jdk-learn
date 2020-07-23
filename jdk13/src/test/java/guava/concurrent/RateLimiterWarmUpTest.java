package guava.concurrent;

import static java.lang.Math.min;

import org.junit.jupiter.api.Test;

public class RateLimiterWarmUpTest {

  double thresholdPermits = 10.0;
  double stableIntervalMicros = 100000.0;
  double slope = 20000.0;

  @Test
  public void storedPermitsToWaitTimeTest() {
    System.out.println("体形的面积计算");
    System.out.println("storedPermitsToWaitTime(20, 1) = " + storedPermitsToWaitTime(20, 1));
    System.out.println();
    System.out.println("storedPermitsToWaitTime(20, 2) = " + storedPermitsToWaitTime(20, 2));
    System.out.println();
    System.out.println("storedPermitsToWaitTime(20, 3) = " + storedPermitsToWaitTime(20, 3));
    System.out.println();
    System.out.println("storedPermitsToWaitTime(20, 4) = " + storedPermitsToWaitTime(20, 4));
    System.out.println();
  }

  long storedPermitsToWaitTime(double storedPermits, double permitsToTake) {
    double availablePermitsAboveThreshold = storedPermits - thresholdPermits;
    long micros = 0;
    // measuring the integral on the right part of the function (the climbing line)
    // 如果右边梯形部分有 permits，那么先从右边部分获取permits，计算梯形部分的阴影部分的面积
    System.out.println("availablePermitsAboveThreshold = " + availablePermitsAboveThreshold);
    if (availablePermitsAboveThreshold > 0.0) {
      // 从右边部分获取的 permits 数量
      double permitsAboveThresholdToTake = min(availablePermitsAboveThreshold, permitsToTake);
      System.out.println("permitsAboveThresholdToTake = " + permitsAboveThresholdToTake);
      // TODO(cpovirk): Figure out a good name for this variable.
      // 梯形面积公式：(上底+下底)*高/2
      System.out.println("通过斜率计算梯形上底和下底的长度，再通过梯形面积公式计算预热时间");
      System.out.println("下底permitsToTime(availablePermitsAboveThreshold) = " + permitsToTime(
          availablePermitsAboveThreshold));
      System.out.println(
          "上底permitsToTime(availablePermitsAboveThreshold - permitsAboveThresholdToTake) = "
              + permitsToTime(availablePermitsAboveThreshold - permitsAboveThresholdToTake));
      double length =
          permitsToTime(availablePermitsAboveThreshold)
              + permitsToTime(availablePermitsAboveThreshold - permitsAboveThresholdToTake);
      System.out.println("上底下底之和length = " + length);
      System.out.println(
          "面积(permitsAboveThresholdToTake * length / 2.0) = " + (permitsAboveThresholdToTake * length
              / 2.0));
      micros = (long) (permitsAboveThresholdToTake * length / 2.0);
      permitsToTake -= permitsAboveThresholdToTake;
    }
    // measuring the integral on the left part of the function (the horizontal line)
    // 加上 长方形部分的阴影面积
    micros += (long) (stableIntervalMicros * permitsToTake);
    return micros;
  }

  /**
   * 对于给定的 x 值，计算 y 值
   *
   * @param permits
   * @return
   */
  private double permitsToTime(double permits) {
    return stableIntervalMicros + permits * slope;
  }

}
