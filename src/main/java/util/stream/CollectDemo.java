package util.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.collections4.MapUtils;

class Student {

  private String name;

  private int age;

  private Gender gender;

  private Grade grade;

  public Student(String name, int age, Gender gender, Grade grade) {
    super();
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Grade getGrade() {
    return grade;
  }

  public void setGrade(Grade grade) {
    this.grade = grade;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "[name=" + name + ", age=" + age + ", gender=" + gender
        + ", grade=" + grade + "]";
  }

}

enum Gender {
  MALE, FEMALE
}

enum Grade {
  ONE, TWO, THREE, FOUR;
}

public class CollectDemo {

  public static void main(String[] args) {
    List<Student> students = Arrays.asList(
        new Student("A1", 10, Gender.MALE, Grade.ONE),
        new Student("A2", 9, Gender.MALE, Grade.THREE),
        new Student("A3", 8, Gender.FEMALE, Grade.TWO),
        new Student("A4", 13, Gender.FEMALE, Grade.FOUR),
        new Student("A5", 7, Gender.FEMALE, Grade.THREE),
        new Student("A6", 13, Gender.MALE, Grade.ONE),
        new Student("A7", 13, Gender.FEMALE, Grade.THREE),
        new Student("A8", 9, Gender.FEMALE, Grade.TWO),
        new Student("A9", 6, Gender.MALE, Grade.ONE),
        new Student("A10", 6, Gender.MALE, Grade.ONE),
        new Student("A11", 14, Gender.FEMALE, Grade.FOUR),
        new Student("A12", 13, Gender.MALE, Grade.FOUR));

    // s -> s.getAge() --> Student::getAge ,
    Set<Integer> ages = students.stream().map(Student::getAge)
        .collect(Collectors.toCollection(TreeSet::new));
    System.out.println("得到学生的年龄:" + ages);

    // 统计汇总信息
    IntSummaryStatistics agesSummaryStatistics = students.stream()
        .collect(Collectors.summarizingInt(Student::getAge));
    System.out.println("年龄汇总信息 " + agesSummaryStatistics);

    System.out.println("数据分块");
    Map<Boolean, List<Student>> genders = students.stream().collect(
        Collectors.partitioningBy(s -> s.getGender() == Gender.MALE));
    MapUtils.verbosePrint(System.out, "性别分块", genders);

    // 分组
    Map<Grade, List<Student>> grades = students.stream()
        .collect(Collectors.groupingBy(Student::getGrade));
    MapUtils.verbosePrint(System.out, "数据分组，年级", grades);

    //
    Map<Grade, Long> gradesCount = students.stream().collect(Collectors
        .groupingBy(Student::getGrade, Collectors.counting()));
    MapUtils.verbosePrint(System.out, "每个班级学生个数", gradesCount);

  }

}
