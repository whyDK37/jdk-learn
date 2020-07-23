package com.google.common.util.concurrent;

import com.google.common.util.concurrent.RateLimiter.SleepingStopwatch;

public class SleepingStopwatchDemo {

  public static void main(String[] args) {
    SleepingStopwatch fromSystemTimer = SleepingStopwatch.createFromSystemTimer();
  }

}
