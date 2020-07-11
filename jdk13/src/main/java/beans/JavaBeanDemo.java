package beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import pojo.User;

public class JavaBeanDemo {

  public static void main(String[] args) throws IntrospectionException {
    BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);

    beanInfo.getPropertyDescriptors();
    beanInfo.getMethodDescriptors();
    beanInfo.getEventSetDescriptors();
    for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
      System.out.println(propertyDescriptor);
    }


  }

}
