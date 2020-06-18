package guava;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ListsDemo {

  public static void main(String[] args) {

    System.out.println("第一个参数不变，第二个参数是和数组引用相同的对象，所以修改数组就是修改 list");
    Integer[] rest = {2, 3, 4};
    List<Integer> integers = Lists.asList(1, rest);
    System.out.println(integers);
    System.out.println("修改数组，list 也会变化");
    rest[0] = -1;
    System.out.println(integers);

    System.out.println("笛卡尔积");
    System.out.println(Lists
        .cartesianProduct(ImmutableList.of(
            ImmutableList.of(1, 2),
            ImmutableList.of("A", "B", "C"))));

    List<List<String>> cartesianProduct1 = Lists
        .cartesianProduct(ImmutableList.of("1", "2"),
            ImmutableList.of("A", "B", "C"),
            ImmutableList.of("一", "二", "三"));
    System.out.println("cartesianProduct1 = " + cartesianProduct1);

    System.out.println("数据转换 transform");
    ArrayList<Integer> fromList = Lists.newArrayList(1, 2, 3);
    List<String> transform = Lists
        .transform(fromList, new Function<>() {
          @Nullable
          @Override
          public String apply(@Nullable Integer input) {
            return input + "-t";
          }
        });
    System.out.println("transform = " + transform);
    System.out.println("修改原 list 会影响 transform 的内容， transForm 是一个视图，并不能修改数据");
    fromList.add(4);
    System.out.println("transform = " + transform);

    System.out.println("partition");
    ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    List<List<Integer>> partition = Lists
        .partition(list, 4);
    System.out.println(partition);
    System.out.println("修改原 list，会影响返回结果，结果是一个视图");
    list.add(0);
    System.out.println(partition);

    System.out.println("字符串的字符视图，不可变");
    ImmutableList<Character> charactersOf = Lists.charactersOf("我是不变的");
    System.out.println(charactersOf);

    System.out.println("翻转视图");
    List<Integer> reverse = Lists.reverse(list);
    System.out.println("reverse = " + reverse);
    list.add(10);
    System.out.println("reverse = " + reverse);


  }

}
