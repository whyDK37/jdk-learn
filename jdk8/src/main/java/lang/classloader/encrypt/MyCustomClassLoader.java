package lang.classloader.encrypt;

import static lang.classloader.encrypt.util.CodecClass.decodeClassBytes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import org.apache.commons.io.FileUtils;

public class MyCustomClassLoader extends ClassLoader {

  // 加密的 class
  private Collection<String> encryptClass = new HashSet<>();
  // 忽略的类，未加密的类
  private Collection<String> skipClass = new HashSet<>();

  public void init() {
    skipClass.add("lang.classloader.encrypt.EncryptApp");
    encryptClass.add("lang.classloader.encrypt.MyClass");
  }

  @Override
  public Class<?> loadClass(String name) throws ClassNotFoundException {
    // 由父类加载的类
    if (name.startsWith("java.")
        && !encryptClass.contains(name)
        && !skipClass.contains(name)) {
      return super.loadClass(name);
    }
    // 未加密的类
    else if (skipClass.contains(name)) {
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
        throw new ClassNotFoundException(name, e);
      }
    }
    // 加密的类
    return findClass(name);
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    // 加载类文件内容
    byte[] bytes = getClassFileBytesInDir(name);
    // 解密
    byte[] decodedBytes = decodeClassBytes(bytes);
    // 初始化类，由 jvm 实现
    return defineClass(name, decodedBytes, 0, bytes.length);
  }

  // 读取加密class文件
  private static byte[] getClassFileBytesInDir(String className) throws ClassNotFoundException {
    try {
      return FileUtils.readFileToByteArray(
          new File(className.replace(".", "//") + ".class_"));
    } catch (IOException e) {
      throw new ClassNotFoundException(className, e);
    }
  }
}