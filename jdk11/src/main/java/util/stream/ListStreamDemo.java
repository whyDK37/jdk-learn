package util.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import pojo.User;

/**
 * @author why
 */
public class ListStreamDemo {

  public static void main(String[] args) {

    List<User> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(new User()
          .setId(i)
          .setGrade(i % 3)
          .setName("name " + i));
    }

    System.out.println("list map to list");
    System.out.println(list.parallelStream().map((Function<User, Object>) User::getId)
        .collect(Collectors.toList()));

    System.out.println("list to map");
    System.out.println(list.stream().collect(Collectors.toMap(User::getId, User::getName)));

    System.out.println("list to map, 分组");
    System.out.println(list.stream().collect(Collectors.groupingBy(User::getGrade)));
    System.out.println(list.stream().collect(Collectors
        .groupingBy(User::getGrade, Collectors.mapping(User::getName, Collectors.toList()))));

    System.out.println("对应的集合元素个数");
    System.out
        .println(
            list.stream().collect(Collectors.groupingBy(User::getGrade, Collectors.counting())));
  }

}
