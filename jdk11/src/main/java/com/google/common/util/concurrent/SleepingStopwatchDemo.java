package com.google.common.util.concurrent;

import com.google.common.util.concurrent.RateLimiter.SleepingStopwatch;

public class SleepingStopwatchDemo {

  public static void main(String[] args) {
    SleepingStopwatch sleepingStopwatch = SleepingStopwatch.createFromSystemTimer();
    sleepingStopwatch.sleepMicrosUninterruptibly(1000L);
    var a="";
    System.out.println(a);
  }

}
