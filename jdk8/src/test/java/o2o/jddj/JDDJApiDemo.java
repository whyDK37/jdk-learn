package o2o.jddj;


import com.alibaba.fastjson.JSON;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import o2o.HttpUtils;
import o2o.MD5Utils;
import o2o.Token;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.jupiter.api.Test;

public class JDDJApiDemo {

  @Test
  void skuCategoryList() throws Exception {
    Map<String, Object> param = new HashMap<>();
    Token token = new Token("", "", "a57119b8-2f39-417c-9f8c-");

    String response = sendPostRaw(JDDJApi.getAllSkuCategoryAttr.getUrl(), JSON.toJSONString(param),token);
    System.out.println(response);
  }

  public String sendPostRaw(String url, String jsonBody,Token token) throws Exception {
    Map<String, String> param = buildParamMap(jsonBody,token);
    List<Header> headers = new ArrayList<>();
    headers.add(new BasicHeader("connection", "close"));

    return HttpUtils.httpsPost(url, param, headers);
  }


  /**
   * 构建加密串
   *
   * @param jsonParam
   * @return
   * @throws Exception
   */
  private TreeMap<String, String> buildParamMap(String jsonParam,Token token) throws Exception {
    //根据orgCode获取token等
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    TreeMap<String, String> param = new TreeMap<>();
    param.put("token", token.getToken());// 北京  华 冠军队
    param.put("app_key", token.getAppId());//商家key
    param.put("timestamp", simpleDateFormat.format(new Date()));
    param.put("format", "json");
    param.put("v", "1.0");
    param.put("jd_param_json", jsonParam);
    param.put("sign", getSign(param, token.getSecret()));
    return param;
  }

  private static String getSign(TreeMap<String, String> param, String secret) throws Exception {
    return MD5Utils.md5(concatParams(param, secret)).toUpperCase();
  }

  private static String concatParams(TreeMap<String, String> treeMap, String secret) {
    StringBuilder sb = new StringBuilder(secret);
    for (Map.Entry<String, String> entry : treeMap.entrySet()) {
      if ("sign".equals(entry.getKey())) {
        continue;//忽略sign
      }
      sb.append(entry.getKey()).append(entry.getValue());
    }
    sb.append(secret);
    return sb.toString();
  }
}
