package time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

public class TimeAndZoneTest {

  @Test
  public void test() {
    //一个时间表示
    String stringDate = "2020-01-02 22:00:00";
//初始化三个时区
    ZoneId timeZoneSH = ZoneId.of("Asia/Shanghai");
    ZoneId timeZoneNY = ZoneId.of("America/New_York");
    ZoneId timeZoneJST = ZoneOffset.ofHours(9);
    ZoneId timeZone8 = ZoneOffset.ofHours(8);
//格式化器
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    ZonedDateTime date = ZonedDateTime
        .of(LocalDateTime.parse(stringDate, dateTimeFormatter), timeZoneJST);
//使用DateTimeFormatter格式化时间，可以通过withZone方法直接设置格式化使用的时区
    DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
    System.out
        .println(timeZoneSH.getId() + " -> " + outputFormat.withZone(timeZoneSH).format(date));
    System.out
        .println(timeZoneNY.getId() + " -> " + outputFormat.withZone(timeZoneNY).format(date));
    System.out
        .println(timeZoneJST.getId() + " -> " + outputFormat.withZone(timeZoneJST).format(date));
    System.out
        .println(timeZone8.getId() + " -> " + outputFormat.withZone(timeZone8).format(date));
  }

}
