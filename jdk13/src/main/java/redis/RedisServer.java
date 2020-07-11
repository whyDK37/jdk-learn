package redis;

public class RedisServer {

  public long lfu_decay_time = 100L;
  public long unixtime = System.currentTimeMillis();
  public double lfu_log_factor = 100;
}
