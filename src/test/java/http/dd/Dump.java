package http.dd;

import static http.dd.Consts.headers;
import static http.dd.Consts.root;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.FileUtils;

public class Dump {

  public static void dumpData(String url, String id, String dbHost, String dbPort,
      String dbName, String table, String sql) throws IOException, InterruptedException {
    TableDataIterator iterator = new TableDataIterator(url + "/" + id,
        readDataId(dbName, table),
        id,
        dbHost,
        dbPort,
        dbName,
        table,
        sql,
        headers);
    while (true) {
      writeDataId(dbName, table, iterator.getDataId());
      String next = iterator.next();
      if (!iterator.hasNext()) {
        break;
      }

      System.out.println("iterator.getSql() = " + iterator.getSql());
      System.out.println(next);
      TimeUnit.SECONDS.sleep(5);
      FileUtils.write(new File(root, fileName(dbName, table) + ".txt"), next, Charsets.UTF_8, true);
      FileUtils
          .write(new File(root, fileName(dbName, table) + ".txt"), "\r\n", Charsets.UTF_8, true);
    }
  }

  private static void writeDataId(String db, String table, long dataId) throws IOException {
    FileUtils.write(new File(root, fileName(db, table) + ".id"), dataId + "", Charsets.UTF_8);
  }

  private static int readDataId(String db, String table) throws IOException {
    File file = new File(root, fileName(db, table) + ".id");
    if (!file.exists()) {
      return 0;
    }

    List<String> strings = FileUtils.readLines(file, Charsets.UTF_8);
    if (strings.isEmpty()) {
      return 0;
    }

    return Integer.parseInt(strings.get(0));
  }

  private static String fileName(String db, String table) {
    return db + "-" + table;
  }
}
