package util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class PriorityQueueTest {

  @Test
  public void test() {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(1);
    priorityQueue.add(0);
    priorityQueue.add(2);
    System.out.println(priorityQueue);
  }
}