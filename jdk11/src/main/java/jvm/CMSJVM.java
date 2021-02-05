package jvm;

/**
 * 参考 https://www.jianshu.com/p/a322309b1d90
 * 举例不清楚，没有描述清楚测试环境信息
 *
 *  -XX:+UseParNewGC
 * -Xmx20m -Xms20m -Xmn10m  -XX:+UseConcMarkSweepGC -XX:+UseCMSInitiatingOccupancyOnly  -XX:CMSInitiatingOccupancyFraction=75 -XX:+ExplicitGCInvokesConcurrentAndUnloadsClasses -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -XX:+PrintGCTimeStamps
 * <pre>
 *   jps
 *   jstat -gcutils pid 1000
 * </pre>
 */
public class CMSJVM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {

        byte[] b1 = new byte[2 * _1MB];
        byte[] b2 = new byte[2 * _1MB];
        byte[] b3 = new byte[2 * _1MB];
        byte[] b4 = new byte[4 * _1MB];
        System.in.read();
    }
}