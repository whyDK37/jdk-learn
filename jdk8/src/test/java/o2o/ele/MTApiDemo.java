package o2o.ele;

import com.alibaba.fastjson.JSON;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.UUID;
import javax.net.ssl.SSLContext;
import o2o.MD5Utils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class MTApiDemo {

  public final static String MT_HOST = "https://waimaiopen.meituan.com";
  public final static String ELE_HOST = "https://api-be.ele.me";

  /**
   * 获取商品类目列表 https://open-retail.ele.me/#/apidoc/me.ele.retail:sku.category.list-3?aopApiCategory=item_all
   */
  @Test
  void skuCategoryList() throws Exception {
    String method = "sku.category.list";
    Map<String, Object> param = new HashMap<>();
    param.put("keyword", null);
    param.put("depth", 1);
    param.put("parent_id", 0);

    String response = sendPostRaw(method, JSON.toJSONString(param));
    System.out.println(response);
  }

  public String sendPostRaw(String method, String jsonBody) throws Exception {
    Map<String, Object> param = initParams(method, jsonBody);
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

    String result = httpsPost(ELE_HOST, param, headers);
    if (StringUtils.isBlank(result)) {
      throw new Exception("返回值是空的");
    }
    return result;
  }


  private static RequestConfig.Builder requestConfigBuilder;

  static {
    requestConfigBuilder = RequestConfig.custom()
        .setConnectTimeout(3000)
        .setConnectionRequestTimeout(3000)
        .setSocketTimeout(10000).setCookieSpec(CookieSpecs.STANDARD);
  }

  private static String httpsPost(String url, Map<String, Object> map, List<Header> headers)
      throws Exception {
    StringBuilder result = new StringBuilder();
    SSLContext sslcontext = SSLContexts.custom().useTLS().build();
    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,
        new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
    try {
      HttpPost httpPost = new HttpPost(url);
      httpPost.setConfig(requestConfigBuilder.build());
      List<NameValuePair> nvps = new ArrayList<>((map == null || map.isEmpty()) ? 0 : map.size());
      if (map != null && !map.isEmpty()) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
          Object val = entry.getValue();
          nvps.add(new BasicNameValuePair(entry.getKey(), val != null ? val.toString() : ""));
        }
      }

      UrlEncodedFormEntity se = new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8"));
      se.setContentEncoding("UTF-8");
      if (headers != null) {
        for (Header header : headers) {
          httpPost.addHeader(header);
        }
      }
      httpPost.addHeader(new BasicHeader("flag", "o2o/ele"));
      httpPost.setEntity(se);
      CloseableHttpResponse response = httpclient.execute(httpPost);
      try {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
          InputStreamReader isr = null;
          BufferedReader bufferedReader = null;
          try {
            isr = new InputStreamReader(entity.getContent());
            bufferedReader = new BufferedReader(isr);
            String text;
            while ((text = bufferedReader.readLine()) != null) {
              result.append(text);
            }
          } finally {
            if (isr != null) {
              isr.close();
            }
            if (bufferedReader != null) {
              bufferedReader.close();
            }
          }
        }
        EntityUtils.consume(entity);
      } finally {
        response.close();
      }
    } finally {
      httpclient.close();
    }
    return decodeUnicode(result.toString());
  }

  /*
   * unicode编码转中文
   */
  public static String decodeUnicode(String unicode) {
    if (StringUtils.isBlank(unicode)) {
      return null;
    }
    unicode = unicode.replace("\\\\u", "\\u");
    StringBuilder sb = new StringBuilder();
    int i = -1;
    int p = 0;
    while ((i = unicode.indexOf("\\u", p)) != -1) {
      sb.append(unicode.substring(p, i));
      if (i + 5 < unicode.length()) {
        p = i + 6;
        sb.append((char) Integer.parseInt(unicode.substring(i + 2, i + 6), 16));
      }
    }
    //有非中文字符，直接添加
    sb.append(unicode.substring(p));
    return sb.toString();
  }


  private Map<String, Object> initParams(String method, String body)
      throws Exception {
    // vendor channel
    Map<String, Object> params = new HashMap<>();
    params.put("cmd", method);
    params.put("encrypt", "");//如果encrypt没有，直接用""，不要用null表示
    params.put("secret", "cc4f4ebd04bedfdd");// 北京  华 冠军
    params.put("source", "36905");
    params.put("ticket", UUID.randomUUID().toString().toUpperCase());
    //在body中添加需要输入的参数
    params.put("body", encodeUnicode(body));
    params.put("version", "3");
    params.put("timestamp", System.currentTimeMillis() / 1000);//当前时间戳

    String sign = getSign(params);
    params.put("sign", sign);
    params.remove("secret");
    return params;
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
        unicode.append("0000".substring(hexString.length(), 4));
      }
      unicode.append(hexString);
    }
    return unicode.toString();
  }


  /**
   * 根据参数获取签名
   *
   * @return String
   */
  private static String getSign(Map<String, Object> data) throws Exception {
    TreeMap<String, Object> arr = new TreeMap<String, Object>();
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
    Iterator it = arr.keySet().iterator();
    while (it.hasNext()) {
      String key = it.next().toString();
      strSignTmp.append(key).append("=").append(arr.get(key)).append("&");
    }
    String strSign = strSignTmp.toString().substring(0, strSignTmp.length() - 1);
//        logger.info("com.yzt.open.rpc.utils.o2o.ele.EleClientUtils.getSign.strSign={}", strSign);
    return MD5Utils.md5(strSign).toUpperCase();
  }
}
