package util.spi;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

public class ServiceLoaderTest {

  public static void main(String[] args) {
    Thread t = new Thread();
    t.getContextClassLoader();
    ServiceLoader<MessageServiceProvider> serviceLoader = ServiceLoader
        .load(MessageServiceProvider.class);
    System.out.println(ServiceLoader.class.getClassLoader());

    for (MessageServiceProvider service : serviceLoader) {
      System.out.println(service.getClass().getClassLoader());
      service.sendMessage("Hello");
    }






//
//    // using Java 8 Optional to get the first service
//    Optional<MessageServiceProvider> firstService = serviceLoader.findFirst();
//    if (firstService.isPresent()) {
//      firstService.get().sendMessage("Hello Friend");
//    }
//
//    // using Java 8 forEach() method
//    serviceLoader.forEach((service) -> service.sendMessage("Have a Nice Day!"));
//
//    // Total Number of Loaded Services
//    System.out.println(serviceLoader.stream().count());
  }
}
