package time;

import static java.time.temporal.TemporalAdjusters.lastInMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * https://lw900925.github.io/java/java8-newtime-api.html
 */
public class Time {

  public static void main(String[] args) {

    localDate();
    localTime();
    localDateTime();
    duration();
    period();

    zone();

    otherCalender();

  }

  private static void otherCalender() {
    LocalDate date = LocalDate.now();
    JapaneseDate japaneseDate = JapaneseDate.from(date);
    System.out.println("japaneseDate = " + japaneseDate);

    Chronology jpChronology = Chronology.ofLocale(Locale.JAPANESE);
    ChronoLocalDate jpChronoLocalDate = jpChronology.dateNow();
    System.out.println("jpChronoLocalDate = " + jpChronoLocalDate);

  }

  private static void zone() {
    ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
    ZoneId systemZoneId = ZoneId.systemDefault();

    LocalDateTime localDateTime = LocalDateTime.now();
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, shanghaiZoneId);
    System.out.println("zonedDateTime = " + zonedDateTime);

    ZoneOffset zoneOffset = ZoneOffset.of("+09:00");
    localDateTime = LocalDateTime.now();
    OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
    System.out.println("offsetDateTime = " + offsetDateTime);
  }

  private static void period() {
    Period period = Period.of(2, 3, 6);
    // 2017-01-05 到 2017-02-05 这段时间
    period = Period.between(
        LocalDate.of(2017, 1, 5),
        LocalDate.of(2017, 2, 5));

    System.out.println("period.getMonths() = " + period.getMonths());
    System.out.println("period.getDays() = " + period.getDays());

  }

  private static void localDate() {
    LocalDate date = LocalDate.of(2017, 1, 5);          // 2017-01-05

    LocalDate date1 = date.withYear(2016);              // 修改为 2016-01-05
    LocalDate date2 = date.withMonth(2);                // 修改为 2017-02-05
    LocalDate date3 = date.withDayOfMonth(1);           // 修改为 2017-01-01

    LocalDate date4 = date.plusYears(1);                // 增加一年 2018-01-05
    LocalDate date5 = date.minusMonths(2);              // 减少两个月 2016-11-05
    LocalDate date6 = date.plus(5, ChronoUnit.DAYS);    // 增加5天 2017-01-10

    LocalDate date7 = date.with(nextOrSame(DayOfWeek.SUNDAY));      // 返回下一个距离当前时间最近的星期日
    LocalDate date9 = date.with(lastInMonth(DayOfWeek.SATURDAY));   // 返回本月最后一个星期六

    String strDate6 = "2017-01-05";

    System.out.println("LocalDate.parse(strDate6, DateTimeFormatter.ofPattern(\"yyyy-MM-dd\")) = "
        + LocalDate.parse(strDate6, DateTimeFormatter.ofPattern("yyyy-MM-dd")));

  }

  private static void localDateTime() {
    LocalDateTime dateTime = LocalDateTime.now();
    String strDate1 = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);    // 20170105
    String strDate2 = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);    // 2017-01-05
    String strDate3 = dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);    // 14:20:16.998
    String strDate4 = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));   // 2017-01-05
    String strDate5 = dateTime.format(DateTimeFormatter.ofPattern("今天是：YYYY年 MMMM DD日 E",
        Locale.CHINESE)); // 今天是：2017年 一月 05日 星期四

    System.out.println("strDate1 = " + strDate1);
    System.out.println("strDate2 = " + strDate2);
    System.out.println("strDate3 = " + strDate3);
    System.out.println("strDate4 = " + strDate4);
    System.out.println("strDate5 = " + strDate5);

    String strDate7 = "2017-01-05 12:30:05";
    LocalDateTime dateTime1 = LocalDateTime.parse(strDate7, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

  }

  private static void duration() {

    LocalDateTime from = LocalDateTime.of(2017, Month.JANUARY, 5, 10, 7,
        0);    // 2017-01-05 10:07:00
    LocalDateTime to = LocalDateTime.of(2017, Month.FEBRUARY, 5, 10, 7,
        0);     // 2017-02-05 10:07:00
    Duration duration = Duration.between(from,
        to);     // 表示从 2017-01-05 10:07:00 到 2017-02-05 10:07:00 这段时间

    long days = duration.toDays();              // 这段时间的总天数
    long hours = duration.toHours();            // 这段时间的小时数
    long minutes = duration.toMinutes();        // 这段时间的分钟数
    long seconds = duration.getSeconds();       // 这段时间的秒数
    long milliSeconds = duration.toMillis();    // 这段时间的毫秒数
    long nanoSeconds = duration.toNanos();      // 这段时间的纳秒数
  }

  private static void localTime() {
    LocalTime of = LocalTime.of(1, 2);
    System.out.println(of);
  }

}
