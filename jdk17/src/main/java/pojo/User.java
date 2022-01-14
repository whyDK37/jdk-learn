package pojo;

import java.util.Objects;

public class User {

  private Integer id;
  private String name;

  private Integer grade;

  public Integer getId() {
    return id;
  }

  public User setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public Integer getGrade() {
    return grade;
  }

  public User setGrade(Integer grade) {
    this.grade = grade;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) &&
        Objects.equals(name, user.name) &&
        Objects.equals(grade, user.grade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, grade);
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", grade=" + grade +
        '}';
  }
}
