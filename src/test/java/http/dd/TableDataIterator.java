package http.dd;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

public class TableDataIterator implements Iterator<String> {

  private final String table;
  private boolean hasNext = true;

  String url;

  long dataId;
  String id;
  String host;
  String port;
  String db;
  String sql;

  Map<String, String> headers;
  Map<String, String> values = new HashMap<>(32);

  public TableDataIterator(String url, int dataId, String id, String host, String port, String db,
      String table,
      String sql, Map<String, String> headers) {
    this.url = url;
    this.dataId = dataId;
    this.id = id;
    this.host = host;
    this.port = port;
    this.db = db;
    this.table = table;
    this.sql = sql;
    this.headers = headers;

    values.put("id", id);
    values.put("host", host);
    values.put("port", port);
    values.put("db", db);
  }

  @Override
  public boolean hasNext() {
    return hasNext;
  }

  @Override
  public String next() {
    values.put("sql", getSql());
    HttpEntity entity = null;//获取响应的对象内容
    try {
      entity = HttpUtils.post(url, headers, values);
    } catch (IOException e) {
      e.printStackTrace();
      hasNext = false;
    }

    String s = null;//进行相应内容文本展示并编码
    try {
      s = EntityUtils.toString(entity, Consts.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
      hasNext = false;
    }
    JSONObject jsonObject = JSON.parseObject(s);
    JSONArray data = jsonObject.getJSONArray("data");
    if (data.isEmpty()) {
      hasNext = false;
    } else {
      JSONObject jsonObject1 = data.getJSONObject(data.size() - 1);
      if (jsonObject1.containsKey("order_id")) {
        dataId = jsonObject1.getLong("order_id");
      } else {
        dataId = (jsonObject1.getLong("id"));
      }
    }

    return s;
  }

  public long getDataId() {
    return dataId;
  }

  public String getSql() {
    return String.format(sql, table, dataId);
  }
}
