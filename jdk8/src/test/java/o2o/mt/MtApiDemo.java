package o2o.mt;


import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import o2o.HttpUtils;
import o2o.MD5Utils;
import o2o.Token;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.junit.jupiter.api.Test;

public class MtApiDemo {

  @Test
  void getids() throws Exception {
    Map<String, Object> param = new HashMap<>();
    Token token = new Token("893", "", "");
    String response = sendGetRaw(MtApi.getids.getUrl(), param, token);
    System.out.println(response);
  }

  @Test
  void mget() throws Exception {
    Map<String, Object> param = new HashMap<>();
    param.put("app_poi_codes", "1148931,1151275");
    Token token = new Token("893", "13b54f4ee246b5c19b044ee7d23aa3c6", "");
    String response = sendGetRaw(MtApi.mget.getUrl(), param, token);
    System.out.println(response);
  }

  /**
   * 自定义header
   */
  private static List<Header> customerHeader = Lists.newArrayList();

  static {
    customerHeader.add(new Header() {
      @Override
      public String getName() {
        return "flag";
      }

      @Override
      public String getValue() {
        return "mt";
      }

      @Override
      public HeaderElement[] getElements() throws ParseException {
        return new HeaderElement[0];
      }
    });
  }

  public String sendPostRaw(String url, Map<String, Object> paramMap, Token token)
      throws Exception {
    Map<String, String> param = initParams(url, paramMap, token);
    String postUrl =
        url + "?app_id=" + param.get("app_id") + "&timestamp=" + param.get("timestamp") + "&sig="
            + param.get("sig");
    param.remove("app_id");
    param.remove("timestamp");
    param.remove("sig");
    return HttpUtils.httpsPost(postUrl, param, customerHeader);
  }

  public String sendGetRaw(String url, Map<String, Object> paramMap, Token token) throws Exception {
    Map<String, String> param = initParams(url, paramMap, token);
    String postUrl =
        url + "?app_id=" + param.get("app_id") + "&timestamp=" + param.get("timestamp") + "&sig="
            + param.get("sig");
    param.remove("app_id");
    param.remove("timestamp");
    param.remove("sig");
    return HttpUtils.httpsGet(postUrl, param, customerHeader);
  }


  private TreeMap<String, String> initParams(String url, Map<String, Object> paramMap, Token token)
      throws Exception {
    //get appid and consumer_secret by orgCode
    TreeMap<String, String> params = new TreeMap<>();
    params.put("app_id", token.getAppId());
    params.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));//当前时间戳
    if (paramMap != null && !paramMap.isEmpty()) {
      for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
        if (entry.getValue() != null) {
          params.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
      }
    }
    String sign = getSign(url, params, token.getSecret());
    params.put("sig", sign);
    return params;
  }


  private String getSign(String url, TreeMap<String, String> arr, String secret) throws Exception {

    String strSign = builderUrl(url, arr) + secret;
    return MD5Utils.md5(strSign);
  }


  private static String builderUrl(String url, TreeMap<String, String> arr) {
    StringBuilder strSignTmp = new StringBuilder(url);
    strSignTmp.append("?");
    Iterator it = arr.keySet().iterator();
    int i = 0;
    int last = arr.size() - 1;
    while (it.hasNext()) {
      String key = it.next().toString();
      strSignTmp.append(key).append("=").append(arr.get(key));
      if (i < last) {
        strSignTmp.append("&");
      }
      i++;
    }
    return strSignTmp.toString();
  }
}
