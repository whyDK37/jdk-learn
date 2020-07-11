package lang;

public class DoubleDemo {

  public static void main(String[] args) {
    float a = 0.125f;
    double b = 0.125d;
    System.out.println((a - b) == 0.0);

    double c = 0.8;
    double d = 0.7;
    double e = 0.6;
    System.out.println((c - d));
    System.out.println((d - e));
    System.out.println((c - d) == (d - e));

    // 3
    System.out.println(1.0 / 0);

    // 4
    System.out.println(0.0 / 0.0);


  }


}
