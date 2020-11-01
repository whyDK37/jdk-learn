package juc;

public class VolatileDemo {

  volatile boolean changed = false;

  void change() {
    changed = true;
  }

  void onChange() {
    if (changed) {
      changed = false;
    }
  }

}
