package util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
    /**
     * 空格
     */
    static final Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");

    public static void main(String[] args) {
        final Matcher matcher = pattern.matcher(" a ");
        System.out.println(">" + matcher.replaceAll("") + "<");

    }
}
