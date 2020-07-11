package lang.classloader.encrypt;

public class EncryptApp {
  public void printClassLoader() {
    System.out.println("EncryptApp:" + this.getClass().getClassLoader());
    System.out.println("MyClass.class.getClassLoader() = " + MyClass.class.getClassLoader());
    new MyClass();
  }
}
