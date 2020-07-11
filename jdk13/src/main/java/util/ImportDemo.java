package util;

import java.util.*;

/**
 * import * 会影响编译速度，不会影响运行速度。
 * 可以通过 idea 查看反编译的类，import java.util.*; 会变成  import java.util.Collection;
 */
public class ImportDemo {
    public static void main(String[] args) {
        System.out.println(Collection.class);
    }
}
