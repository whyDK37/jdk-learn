package lang.classloader;

public class ClassloaderParent {
    public static void main(String[] args) {
        System.out.println(ClassloaderParent.class.getClassLoader());
        System.out.println(ClassloaderParent.class.getClassLoader().getParent());
        System.out.println(ClassloaderParent.class.getClassLoader().getParent().getParent());
    }
}
