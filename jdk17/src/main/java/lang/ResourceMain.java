package lang;

import java.net.URL;

public class ResourceMain {

  public static void main(String[] args) {
    URL resource = ResourceMain.class.getResource("ResourceMain.class");
    System.out.println(resource);
  }

}
