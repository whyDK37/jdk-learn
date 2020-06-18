package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.jupiter.api.Test;

public class DateTest {

  @Test
  public void defaultTime() {
    System.out.println("我得到的是 1970 年 1 月 1 日 8 点。因为我机器当前的时区是中国上海，相比 UTC 时差 +8 小时：");
    System.out.println(new Date(0));
    System.out.println(TimeZone.getDefault().getID() + ":" + TimeZone.getDefault());
  }

  @Test
  public void timeZone() throws ParseException {
    String stringDate = "2020-01-02 22:00:00";
    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println("默认时区解析时间表示");
    Date date1 = inputFormat.parse(stringDate);
    System.out.println(date1 + ":" + date1.getTime());
    System.out.println("纽约时区解析时间表示");
    inputFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
    Date date2 = inputFormat.parse(stringDate);
    System.out.println(date2 + ":" + date2.getTime());

    stringDate = "2020-01-02 22:00:00";
    inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println("同一Date");
    Date date = inputFormat.parse(stringDate);
    System.out.println("默认时区格式化输出：");
    System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss Z]").format(date));

    System.out.println("纽约时区格式化输出");
    TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
    System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss Z]").format(date));
  }

  @Test
  public void wrongDemo() throws ParseException {
    Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
    System.out.println("defaultLocale:" + Locale.getDefault());
    Calendar calendar = Calendar.getInstance();
    calendar.set(2019, Calendar.DECEMBER, 29, 0, 0, 0);
    SimpleDateFormat YYYY = new SimpleDateFormat("YYYY-MM-dd");
    System.err.println("得到的输出却是 2020 年 12 月 29 日, 小写 y 是年，而大写 Y 是 week year，也就是所在的周属于哪一年。");
    System.out.println("格式化: " + YYYY.format(calendar.getTime()));
    System.out.println("weekYear:" + calendar.getWeekYear());
    System.out.println("firstDayOfWeek:" + calendar.getFirstDayOfWeek());
    System.out.println("minimalDaysInFirstWeek:" + calendar.getMinimalDaysInFirstWeek());

    System.out.println("当需要解析的字符串和格式不匹配的时候，SimpleDateFormat 表现得很宽容，");
    String dateString = "20160901";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
    System.err.println("居然输出了 2091 年 1 月 1 日，原因是把 0901 当成了月份，相当于 75 年：");
    System.out.println("result:" + dateFormat.parse(dateString));
  }
}
