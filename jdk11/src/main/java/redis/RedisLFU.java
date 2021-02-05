//package redis;
//
//public class RedisLFU {
//
//  RedisServer server;
//
//  void updateLFU(RedisObj val) {
//    long counter = LFUDecrAndReturn(val);
//    counter = LFULogIncr(counter);
//    val.lru = (LFUGetTimeInMinutes() << 8) | counter;
//  }
//
//  /* If the object decrement time is reached decrement the LFU counter but
//   * do not update LFU fields of the object, we update the access time
//   * and counter in an explicit way when the object is really accessed.
//   * And we will times halve the counter according to the times of
//   * elapsed time than server.lfu_decay_time.
//   * Return the object frequency counter.
//   *
//   * This function is used in order to scan the dataset for the best object
//   * to fit: as we check for the candidate, we incrementally decrement the
//   * counter of the scanned objects if needed. */
//  long LFUDecrAndReturn(RedisObj o) {
//    long ldt = o.lru >> 8;
//    long counter = o.lru & 255;
//    long num_periods = server.lfu_decay_time > 0 ? LFUTimeElapsed(ldt) / server.lfu_decay_time : 0;
//    if (num_periods > 0) {
//      counter = (num_periods > counter) ? 0 : counter - num_periods;
//    }
//    return counter;
//  }
//
//  /* Return the current time in minutes, just taking the least significant
//   * 16 bits. The returned time is suitable to be stored as LDT (last decrement
//   * time) for the LFU implementation. */
//
//  long LFUGetTimeInMinutes() {
//    return (server.unixtime / 60) & 65535;
//  }
//
//  /* Given an object last access time, compute the minimum number of minutes
//   * that elapsed since the last access. Handle overflow (ldt greater than
//   * the current 16 bits minutes time) considering the time as wrapping
//   * exactly once. */
//
//  long LFUTimeElapsed(long ldt) {
//    long now = LFUGetTimeInMinutes();
//    if (now >= ldt) {
//      return now - ldt;
//    }
//    return 65535 - ldt + now;
//  }
//
//  /* Logarithmically increment a counter. The greater is the current counter value
//   * the less likely is that it gets really implemented. Saturate it at 255. */
//  long LFULogIncr(long counter) {
//    if (counter == 255) {
//      return 255;
//    }
//    double r = (double) rand() / RAND_MAX;
//    double baseval = counter - LFU_INIT_VAL;
//    if (baseval < 0) {
//      baseval = 0;
//    }
//    double p = 1.0 / (baseval * server.lfu_log_factor + 1);
//    if (r < p) {
//      counter++;
//    }
//    return counter;
//  }
//
//}
