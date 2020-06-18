package time;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;

public class LocalDateTimeTest {

  @Test
  public void calcDate() {
    System.out.println("日期计算");
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime.plusDays(30));
    System.out.println("测试操作日期");
    System.out.println(LocalDate.now()
        .minus(Period.ofDays(1))
        .plus(1, ChronoUnit.DAYS)
        .minusMonths(1)
        .plus(Period.ofMonths(1)));

    System.out.println("TemporalAdjusters 调整时间");
    System.out.println("//本月的第一天");
    System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));
    System.out.println("//今年的程序员日");
    System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()).plusDays(255));
    System.out.println("//今天之前的一个周六");
    System.out.println(
        LocalDate.now().with(LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SATURDAY))));
    System.out.println("//本月最后一个工作日");
    System.out.println(
        LocalDate.now()
            .with(LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY))));

    System.out.println("可以直接使用 lambda 表达式进行自定义的时间调整。比如，为当前时间增加 100 天以内的随机天数：");
    System.out.println((LocalDate.now().with(
        temporal -> temporal.plus(ThreadLocalRandom.current().nextInt(100), ChronoUnit.DAYS))));

    System.out.println("//查询是否是今天要举办生日");
    System.out.println((LocalDate.now().query(LocalDateTimeTest::isFamilyBirthday)));

    System.out.println("//计算日期差");
    LocalDate today = LocalDate.of(2019, 12, 12);
    LocalDate specifyDate = LocalDate.of(2019, 10, 1);
    System.out.println(Period.between(specifyDate, today).getDays());
    System.out.println(Period.between(specifyDate, today));
    System.out.println(ChronoUnit.DAYS.between(specifyDate, today));
  }

  public static Boolean isFamilyBirthday(TemporalAccessor date) {
    int month = date.get(MONTH_OF_YEAR);
    int day = date.get(DAY_OF_MONTH);
    if (month == Month.FEBRUARY.getValue() && day == 17) {
      return Boolean.TRUE;
    }
    if (month == Month.SEPTEMBER.getValue() && day == 21) {
      return Boolean.TRUE;
    }
    if (month == Month.MAY.getValue() && day == 22) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
}
