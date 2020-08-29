package o2o.ele;

import static o2o.ele.EleApi.sku_category_list;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.UUID;
import o2o.HttpUtils;
import o2o.MD5Utils;
import o2o.Token;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class EleApiDemo {

  public final static String ELE_HOST = "https://api-be.ele.me";

  /**
   * 获取商品类目列表 https://open-retail.ele.me/#/apidoc/me.ele.retail:sku.category.list-3?aopApiCategory=item_all
   */
  @Test
  void skuCategoryList() throws Exception {

    Token token = new Token("369" + "05", "" + "dd",
        "a57119b8-2f39-417c-9f8c-" + "3e");

    Map<String, Object> param = new HashMap<>();
    param.put("keyword", null);
    param.put("depth", 1);
    param.put("parent_id", 0);

    String response = sendPostRaw(sku_category_list.getMethod(), JSON.toJSONString(param), token);
    System.out.println(response);
  }

  public String sendPostRaw(String method, String jsonBody, Token token) throws Exception {
    Map<String, String> param = initParams(method, jsonBody, token);
    List<Header> headers = new ArrayList<>();
    Header header1 = new BasicHeader("accept", "*/*");
    Header header2 = new BasicHeader("connection", "Keep-Alive");
    Header header3 = new BasicHeader("Content-Type", "application/x-www-form-urlencoded");
    Header header4 = new BasicHeader("user-agent",
        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
    headers.add(header1);
    headers.add(header2);
    headers.add(header3);
    headers.add(header4);

    String result = HttpUtils.httpsPost(ELE_HOST, param, headers);
    if (StringUtils.isBlank(result)) {
      throw new Exception("返回值是空的");
    }
    return result;
  }


  private static String encodeUnicode(String body) {
    if (StringUtils.isBlank(body)) {
      return "";
    }
    char[] bytes = body.toCharArray();
    StringBuilder unicode = new StringBuilder();
    for (int i = 0; i < bytes.length; i++) {
      char c = bytes[i];
      // 标准ASCII范围内的字符，直接输出
      int bound = 127;
      if (c <= bound) {
        unicode.append(c);
        continue;
      }
      String hexString = Integer.toHexString(bytes[i]);
      unicode.append("\\u");
      // 不够四位进行补0操作
      if (hexString.length() < 4) {
        unicode.append("0000", hexString.length(), 4);
      }
      unicode.append(hexString);
    }
    return unicode.toString();
  }

  private Map<String, String> initParams(String method, String body, Token token)
      throws Exception {
    // vendor channel
    Map<String, String> params = new HashMap<>();
    params.put("cmd", method);
    params.put("encrypt", "");//如果encrypt没有，直接用""，不要用null表示
    params.put("secret", token.getSecret());// 北京  华 冠军
    params.put("source", token.getAppId());
    params.put("ticket", UUID.randomUUID().toString().toUpperCase());
    //在body中添加需要输入的参数
    params.put("body", encodeUnicode(body));
    params.put("version", "3");
    params.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));//当前时间戳

    String sign = getSign(params);
    params.put("sign", sign);
    params.remove("secret");
    return params;
  }


  /**
   * 根据参数获取签名
   *
   * @return String
   */
  private static String getSign(Map<String, String> data) throws Exception {
    TreeMap<String, String> arr = new TreeMap<>();
    Object body = data.get("body");
    arr.put("body", encodeUnicode(Objects.isNull(body) ? "" : body.toString()));
    arr.put("cmd", data.get("cmd"));
    arr.put("encrypt", "");
    arr.put("secret", data.get("secret"));
    arr.put("source", data.get("source"));
    arr.put("ticket", data.get("ticket"));
    arr.put("timestamp", data.get("timestamp"));
    arr.put("version", data.get("version"));
    StringBuilder strSignTmp = new StringBuilder();
    for (String s : arr.keySet()) {
      String key = s.toString();
      strSignTmp.append(key).append("=").append(arr.get(key)).append("&");
    }
    String strSign = strSignTmp.toString().substring(0, strSignTmp.length() - 1);
//        logger.info("com.yzt.open.rpc.utils.o2o.ele.EleClientUtils.getSign.strSign={}", strSign);
    return MD5Utils.md5(strSign).toUpperCase();
  }
}
