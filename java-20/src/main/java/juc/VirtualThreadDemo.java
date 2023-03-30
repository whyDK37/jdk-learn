package juc;

public class VirtualThreadDemo {
    public static void main(String[] argv) throws InterruptedException {
        Thread thread = Thread.ofVirtual()
                .name("virtualThread")
                .start(() -> System.out.println("Hello"));
        System.out.println("thread.getName() = " + thread.getName());
        System.out.println("thread.getClass() = " + thread.getClass());
        thread.join();
    }
}