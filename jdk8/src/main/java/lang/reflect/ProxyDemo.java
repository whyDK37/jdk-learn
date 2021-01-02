package lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {

  public static void main(String[] args) {
    ClassLoader classLoader = ProxyDemo.class.getClassLoader();
    Object proxy = Proxy
        .newProxyInstance(classLoader, new Class<?>[]{Runnable.class}, new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("toString")){
              return null;
            }
            System.out.println(proxy);
            System.out.println(method);
            return null;
          }
        });

    Runnable runnable = (Runnable) proxy;
    runnable.run();

  }

}
