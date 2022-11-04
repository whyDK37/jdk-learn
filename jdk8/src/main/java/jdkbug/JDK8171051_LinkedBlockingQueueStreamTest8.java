package jdkbug;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://bugs.openjdk.org/browse/JDK-8171051
 * 在 jdk 8 运行，stream 会出现死循环。
 * jdk 15 以上没有问题
 */
public class JDK8171051_LinkedBlockingQueueStreamTest8 {
    public static void main(String[] args) throws Exception {
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(1000);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    queue.offer(new Object());
                    queue.remove();
                }
            }).start();
        }
        while (true) {
            System.out.println("begin scan, i still alive");
            queue.stream()
                    .filter(o -> o == null)
                    .findFirst()
                    .isPresent();
            Thread.sleep(100);
            System.out.println("finish scan, i still alive");
        }
    }
}