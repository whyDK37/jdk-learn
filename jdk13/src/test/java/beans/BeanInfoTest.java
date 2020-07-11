package beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class BeanInfoTest {

  public static void main(String[] args) throws IntrospectionException {
    BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
    System.out.println(beanInfo);
    for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
      System.out.println(propertyDescriptor);
    }
  }

}
