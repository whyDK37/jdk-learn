package http.dd;

import java.util.HashMap;
import java.util.Map;

public class Consts {

  public static final String root = "E:\\dj\\data";
  public static final String Cookie = "session=50217dce-8e8b-4455-b68a-b5cc0c34e70f.4BxNLfkm_PccV2MkHIlrzNQYJwI; X-CSRF=IjI5YTA2ZTBjMjNhM2I0YWQ3ZmM4ODRlNTM1NjhiNmNiMzZiMDFjZWUi.EXbkbQ.n9wqIKkcRcASDp8DFrBHXytxgKo";

  public static final String Accept = "application/json, text/javascript, */*; q=0.01";
  public static final String AcceptEncoding = " gzip, deflate";
  public static final String AcceptLanguage = "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6";
  public static final String Connection = "keep-alive";
  public static final String ContentType = "application/x-www-form-urlencoded; charset=UTF-8";
  public static final String DNT = "1";
  public static final String Host = "o2oyw.jddj.com";
  public static final String Origin = "http://o2oyw" + "." + "jddj" + "." + "com";
  public static final String Referer = "http://o2oyw" + "." + "jddj" + "." + "com/dql/host_tab";
  public static final String UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36 Edg/79.0.309.71";
  public static final String XRequestedWith = "XMLHttpRequest";


  public static final Map<String, String> headers = new HashMap<>(32);

  static {
    headers.put("Cookie", Cookie);
    headers.put("Accept", Accept);
    headers.put("Accept-encoding", AcceptEncoding);
    headers.put("Accept-language", AcceptLanguage);
    headers.put("Connection", Connection);
    headers.put("Content-type", ContentType);
    headers.put("DNT", DNT);
    headers.put("Host", Host);
    headers.put("Origin", Origin);
    headers.put("Referer", Referer);
    headers.put("beans.User-agent", UserAgent);
    headers.put("X-Requested-With", XRequestedWith);
  }
}
