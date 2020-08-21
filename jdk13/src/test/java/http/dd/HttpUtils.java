package http.dd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class HttpUtils {

  private static CloseableHttpClient httpclient;

  private static RequestConfig config = RequestConfig.custom()
      .setConnectTimeout(10000) // 设置连接超时时间 10秒钟
      .setSocketTimeout(10000) // 设置读取超时时间10秒钟
      .build();

  static {
    httpclient = HttpClientBuilder.create().build();
  }

  public static HttpEntity post(String url, Map<String, String> headers, Map<String, String> values)
      throws IOException {

    //post 请求
    HttpPost httppost = new HttpPost(url);

    httppost.setConfig(config);

    // set header
    for (Map.Entry<String, String> stringStringEntry : headers.entrySet()) {
      httppost.addHeader(stringStringEntry.getKey(), stringStringEntry.getValue());
    }

//        在集合中放入我们表单中的name --- value 键值对
    List<BasicNameValuePair> pair = new ArrayList<>();
    for (Map.Entry<String, String> stringStringEntry : values.entrySet()) {
      pair.add(new BasicNameValuePair(stringStringEntry.getKey(), stringStringEntry.getValue()));
    }

    httppost.setEntity(new UrlEncodedFormEntity(pair));

    CloseableHttpResponse response = httpclient.execute(httppost);
    return response.getEntity();//获取响应的对象内容
  }


  public static HttpEntity get(String url)
      throws IOException {

    //post 请求
    HttpGet httpGet = new HttpGet(url);

    httpGet.setConfig(config);

    CloseableHttpResponse response = httpclient.execute(httpGet);
    return response.getEntity();//获取响应的对象内容
  }
}
