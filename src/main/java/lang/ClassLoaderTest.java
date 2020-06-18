package lang;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import pojo.User;

public class ClassLoaderTest {

  public static void main(String[] args)
      throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    ClassLoader myLoader = new ClassLoader() {
      @Override
      public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.startsWith("java.")){
          return super.loadClass(name);
        }
        try {
          String classPath = name.replace('.', '/') + ".class";
          //返回读取指定资源的输入流
          URL resource = getClass().getClassLoader().getResource(classPath);
          InputStream is = resource != null ? resource.openStream() : null;
          if (is == null) {
            return super.loadClass(name);
          }
          byte[] b = new byte[is.available()];
          is.read(b);

          //将一个byte数组转换为Class类的实例
          return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
          throw new ClassNotFoundException(name);
        }
      }
    };

    Object user = myLoader.loadClass("pojo.User").newInstance();
    System.out.println("user.getClass() = " + user.getClass());
    System.out.println("user.getClass().getClassLoader() = " + user.getClass().getClassLoader());
    System.out.println(user instanceof User);
    System.out.println(user);

    User u = new User();
    System.out.println("u.getClass() = " + u.getClass());
    System.out.println("u.getClass().getClassLoader() = " + u.getClass().getClassLoader());
    System.out.println(u.equals(user));


  }
}