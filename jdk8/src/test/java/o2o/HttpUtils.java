package o2o;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLContext;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.platform.commons.util.StringUtils;

public class HttpUtils {


  private static RequestConfig.Builder requestConfigBuilder;

  static {
    requestConfigBuilder = RequestConfig.custom()
        .setConnectTimeout(3000)
        .setConnectionRequestTimeout(3000)
        .setSocketTimeout(10000).setCookieSpec(CookieSpecs.STANDARD);
  }


  public static String httpsGet(String url, Map<String, String> map, List<Header> headers)
      throws Exception {
    StringBuilder result = new StringBuilder();
    SSLContext sslcontext = SSLContexts.custom().useTLS().build();
    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,
        new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    try (CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build()) {

      StringBuilder urlBuilder = new StringBuilder(url);
      for (Entry<String, String> stringStringEntry : map.entrySet()) {
        urlBuilder.append("&").append(stringStringEntry.getKey()).append("=")
            .append(stringStringEntry.getValue());
      }
      url = urlBuilder.toString();
      HttpGet httpGet = new HttpGet(url);
      httpGet.setConfig(requestConfigBuilder.build());
      if (headers != null) {
        for (Header header : headers) {
          httpGet.addHeader(header);
        }
      }
      httpGet.addHeader(new BasicHeader("flag", "o2o/ele"));
      try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
          try (InputStreamReader isr = new InputStreamReader(
              entity.getContent()); BufferedReader bufferedReader = new BufferedReader(isr)) {
            String text;
            while ((text = bufferedReader.readLine()) != null) {
              result.append(text);
            }
          }
        }
        EntityUtils.consume(entity);
      }
    }
    return decodeUnicode(result.toString());
  }

  public static String httpsPost(String url, Map<String, String> map, List<Header> headers)
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
        for (Map.Entry<String, String> entry : map.entrySet()) {
          Object val = entry.getValue();
          nvps.add(new BasicNameValuePair(entry.getKey(), val != null ? val.toString() : ""));
        }
      }

      UrlEncodedFormEntity se = new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8);
      se.setContentEncoding("UTF-8");
      if (headers != null) {
        for (Header header : headers) {
          httpPost.addHeader(header);
        }
      }
      httpPost.addHeader(new BasicHeader("flag", "o2o/ele"));
      httpPost.setEntity(se);
      try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
          try (InputStreamReader isr = new InputStreamReader(
              entity.getContent()); BufferedReader bufferedReader = new BufferedReader(isr)) {
            String text;
            while ((text = bufferedReader.readLine()) != null) {
              result.append(text);
            }
          }
        }
        EntityUtils.consume(entity);
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

}
