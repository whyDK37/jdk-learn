package http.dd;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DBMain {

  public static void main(String[] args) throws IOException, InterruptedException {
    StringBuilder url = new StringBuilder("http://o2oyw")
        .append(".jddj")
        .append(".com")
        .append("/dql/host_execute");

//        form data
    StringBuilder dbHostSub = new StringBuilder()
        .append(".mysql")
        .append(".jddb")
        .append(".com");

//    order
//    Dump.dumpData(url.toString(), "3107", "dj20190104s" + dbHostSub, "3358", "yzt_order", "order_main", "select * from %s where order_id > %d order by order_id;");
//    TimeUnit.SECONDS.sleep(5);
//    Dump.dumpData(url.toString(), "3107", "dj20190104s" + dbHostSub, "3358", "yzt_order", "order_product", "select * from %s where id > %d order by id;");
//    TimeUnit.SECONDS.sleep(5);

//    base
    Dump.dumpData(url.toString(), "3634", "dj20181227m" + dbHostSub, "3358", "yzt_base",
        "user_info", "select * from %s where id > %d order by id;");
    TimeUnit.SECONDS.sleep(5);
    Dump.dumpData(url.toString(), "3634", "dj20181227m" + dbHostSub, "3358", "yzt_base",
        "vender_manager", "select * from %s where id > %d order by id;");
    TimeUnit.SECONDS.sleep(5);
    Dump.dumpData(url.toString(), "3634", "dj20181227m" + dbHostSub, "3358", "yzt_base",
        "vender_manager", "select * from %s where id > %d order by id;");
    TimeUnit.SECONDS.sleep(5);
    Dump.dumpData(url.toString(), "3634", "dj20181227m" + dbHostSub, "3358", "yzt_base",
        "vender_channel", "select * from %s where id > %d order by id;");
    TimeUnit.SECONDS.sleep(5);
    Dump.dumpData(url.toString(), "3634", "dj20181227m" + dbHostSub, "3358", "yzt_base",
        "vender_config", "select * from %s where id > %d order by id;");
    TimeUnit.SECONDS.sleep(5);
    Dump.dumpData(url.toString(), "3634", "dj20181227m" + dbHostSub, "3358", "yzt_base",
        "station_info", "select * from %s where id > %d order by id;");
    TimeUnit.SECONDS.sleep(5);

  }
}
