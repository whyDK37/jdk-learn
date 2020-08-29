package o2o;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sout {

  public static void main(String[] args) throws IOException {
    System.out.println(
        "\u534e\u7ef4\u7ebf\u4e0a\u5546\u5bb6");
//
//BufferedReader是可以按行读取文件
    FileInputStream inputStream = new FileInputStream("E:\\dj\\data\\yzt_base-vender_channel.txt");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    String str;
    while ((str = bufferedReader.readLine()) != null) {
      System.out.println(convertUnicodeToCh(str));
    }

    //close
    inputStream.close();
    bufferedReader.close();
  }


  /**
   * 将unicode字符串转为正常字符串
   *
   * @param str unicode字符串（比如"\u67e5\u8be2\u6210\u529f"）
   * @return 转换后的字符串（比如"查询成功"）
   */
  private static String convertUnicodeToCh(String str) {
    Pattern pattern = Pattern.compile("(\\\\u(\\w{4}))");
    Matcher matcher = pattern.matcher(str);

    // 迭代，将str中的所有unicode转换为正常字符
    while (matcher.find()) {
      String unicodeFull = matcher.group(1); // 匹配出的每个字的unicode，比如\u67e5
      String unicodeNum = matcher.group(2); // 匹配出每个字的数字，比如\u67e5，会匹配出67e5

      // 将匹配出的数字按照16进制转换为10进制，转换为char类型，就是对应的正常字符了
      char singleChar = (char) Integer.parseInt(unicodeNum, 16);

      // 替换原始字符串中的unicode码
      str = str.replace(unicodeFull, singleChar + "");
    }
    return str;
  }

}
