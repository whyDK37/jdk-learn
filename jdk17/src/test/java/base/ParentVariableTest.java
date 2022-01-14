package base;

import java.lang.reflect.Field;

public class ParentVariableTest {
    static class Parent {
        int count = 1;

        public int getCount() {
            return count;
        }
    }

    static class Child extends Parent {
        String count = "hello";

        @Override
        public int getCount() {
            return super.getCount();
        }
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        System.out.println(parent.getCount());
        System.out.println(child.getCount());

        System.out.println("parent.count = " + parent.count);
        System.out.println("child.count = " + child.count);


        parent = child;
        parent.count = 2;
        System.out.println("parent.count = " + parent.count);
        System.out.println("child.count = " + child.count);

        Field[] declaredFields = child.getClass().getFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }

    }
}
