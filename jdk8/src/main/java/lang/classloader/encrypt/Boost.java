package lang.classloader.encrypt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Boost {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    MyCustomClassLoader myCustomClassLoader = new MyCustomClassLoader();
    myCustomClassLoader.init();

    Class<?> startupClass = myCustomClassLoader.loadClass("lang.classloader.encrypt.EncryptApp");

    // 必须通过反射的方式获取方法，
    // 因为当前线程的classloader，和加载 EncryptApp 的不一样，
    // 所以不能类型转换，必须用object
    Object encryptApp = startupClass.getConstructor().newInstance();
    String methodName = "printClassLoader";
    Method method = encryptApp.getClass().getMethod(methodName);
    method.invoke(encryptApp);
  }

}
