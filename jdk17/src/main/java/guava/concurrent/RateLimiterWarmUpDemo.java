package guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;


/**
 * This implements the following function where coldInterval = coldFactor * stableInterval.
 *
 * <pre>
 *          ^ throttling
 *          |
 *    cold  +                  /
 * interval |                 /.
 *          |                / .
 *          |               /  .   ← "warmup period" is the area of the trapezoid between
 *          |              /   .     thresholdPermits and maxPermits
 *          |             /    .
 *          |            /     .
 *          |           /      .
 *   stable +----------/  WARM .
 * interval |          .   UP  .
 *          |          . PERIOD.
 *          |          .       .
 *        0 +----------+-------+--------------→ storedPermits
 *          0 thresholdPermits maxPermits
 * </pre>
 * <p>
 * Before going into the details of this particular function, let's keep in mind the basics:
 *
 * <ol>
 *   <li>The state of the RateLimiter (storedPermits) is a vertical line in this figure.
 *   <li>When the RateLimiter is not used, this goes right (up to maxPermits)
 *   <li>When the RateLimiter is used, this goes left (down to zero), since if we have
 *       storedPermits, we serve from those first
 *   <li>When _unused_, we go right at a constant rate! The rate at which we move to the right is
 *       chosen as maxPermits / warmupPeriod. This ensures that the time it takes to go from 0 to
 *       maxPermits is equal to warmupPeriod.
 *   <li>When _used_, the time it takes, as explained in the introductory class note, is equal to
 *       the integral of our function, between X permits and X-K permits, assuming we want to
 *       spend K saved permits.
 * </ol>
 *
 * <p>In summary, the time it takes to move to the left (spend K permits), is equal to the area of
 * the function of width == K.
 *
 * <p>Assuming we have saturated demand, the time to go from maxPermits to thresholdPermits is
 * equal to warmupPeriod. And the time to go from thresholdPermits to 0 is warmupPeriod/2. (The
 * reason that this is warmupPeriod/2 is to maintain the behavior of the original implementation
 * where coldFactor was hard coded as 3.)
 *
 * <p>It remains to calculate thresholdsPermits and maxPermits.
 *
 * <ul>
 *   <li>The time to go from thresholdPermits to 0 is equal to the integral of the function
 *       between 0 and thresholdPermits. This is thresholdPermits * stableIntervals. By (5) it is
 *       also equal to warmupPeriod/2. Therefore
 *       <blockquote>
 *       thresholdPermits = 0.5 * warmupPeriod / stableInterval
 *       </blockquote>
 *   <li>The time to go from maxPermits to thresholdPermits is equal to the integral of the
 *       function between thresholdPermits and maxPermits. This is the area of the pictured
 *       trapezoid, and it is equal to 0.5 * (stableInterval + coldInterval) * (maxPermits -
 *       thresholdPermits). It is also equal to warmupPeriod, so
 *       <blockquote>
 *       maxPermits = thresholdPermits + 2 * warmupPeriod / (stableInterval + coldInterval)
 *       </blockquote>
 * </ul>
 */
public class RateLimiterWarmUpDemo {

  public static void main(String[] args) {
    final RateLimiter limiter = RateLimiter.create(10.0, 2000L, TimeUnit.MILLISECONDS);

    acquire(limiter);
    System.out.println("limiter.getRate() = " + limiter.getRate());
    limiter.setRate(10);
    acquire(limiter);

  }

  private static void acquire(RateLimiter limiter) {
    for (int i = 1; i < 10; i = i + 2) {
      double waitTime = limiter.acquire(i);
      System.out
          .println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
    }
  }
}
