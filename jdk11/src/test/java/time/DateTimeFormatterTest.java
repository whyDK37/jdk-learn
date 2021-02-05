package time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateTimeFormatterTest {

  private static DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
      .appendValue(ChronoField.YEAR) //年
      .appendLiteral("/")
      .appendValue(ChronoField.MONTH_OF_YEAR) //月
      .appendLiteral("/")
      .appendValue(ChronoField.DAY_OF_MONTH) //日
      .appendLiteral(" ")
      .appendValue(ChronoField.HOUR_OF_DAY) //时
      .appendLiteral(":")
      .appendValue(ChronoField.MINUTE_OF_HOUR) //分
      .appendLiteral(":")
      .appendValue(ChronoField.SECOND_OF_MINUTE) //秒
      .appendLiteral(".")
      .appendValue(ChronoField.MILLI_OF_SECOND) //毫秒
      .toFormatter();

  @Test
  public void test() {
    System.out.println("使用刚才定义的DateTimeFormatterBuilder构建的DateTimeFormatter来解析这个时间");
    LocalDateTime localDateTime = LocalDateTime.parse("2020/1/2 22:34:56.789", dateTimeFormatter);
    System.out.println("解析成功");
    System.out.println(localDateTime.format(dateTimeFormatter));
    System.out.println("使用yyyyMM格式解析20160901是否可以成功呢？会抛异常");
    Exception exception = null;
    try {
      String dt = "20160901";
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMM");
      System.out.println("result:" + dateTimeFormatter.parse(dt));
    } catch (Exception e) {
      e.printStackTrace();
      exception = e;
    }
    Assertions.assertNotNull(exception);
  }

}
