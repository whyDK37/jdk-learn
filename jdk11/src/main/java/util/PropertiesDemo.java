package util;

import java.util.Map;
import java.util.Properties;

public class PropertiesDemo {

  public static void main(String[] args) {
    Properties properties = new Properties();
    properties.put("a", "a");

    Map map = properties;
    map.put("1", 3);

    // properties 没有遵守里氏替换原则
    System.out.println("properties.getProperty(\"1\") = " + properties.getProperty("1"));
  }

}
