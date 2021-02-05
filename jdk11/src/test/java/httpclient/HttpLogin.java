package httpclient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

// 失败的响应
// <html><head><meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head><body><script language="javascript">alert("登录失败，用户名或密码错误，请重试！");history.back();</script></body></html>


public class HttpLogin {

  static String loginUrl = "http://jiaoxue.cugbonline.cn/meol/jpk/course/layout/newpage/login.jsp";

  static String loginPage = "https://www.cugbonline.cn:8443/cas/login";

  public static void main(String[] args) throws IOException {

    RequestConfig requestConfig = RequestConfig.custom()
        .build();
    CloseableHttpClient httpClient = HttpClientBuilder.create()
        .setDefaultRequestConfig(requestConfig).build();

    // 获取页面参数，用于下一步登录
    Map<String, String> formParam = getFormParam(httpClient);

    // 登录系统

    // 定时刷课

    // 登陆 Url
    //enterLid: 10834
    //IPT_LOGINUSERNAME: 2019010120085
    //IPT_LOGINPASSWORD: 231084198709033115

    // 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
    HttpPost request = new HttpPost(loginUrl);
    StringEntity params = new StringEntity(
        "enterLid=10834&IPT_LOGINUSERNAME=2019010120085&IPT_LOGINPASSWORD=231084198709033115");
    setHeader(request);

    List<BasicNameValuePair> pair = new ArrayList<BasicNameValuePair>();
    pair.add(new BasicNameValuePair("enterLid", "10834"));
    pair.add(new BasicNameValuePair("IPT_LOGINUSERNAME", "2019010120085"));
    pair.add(new BasicNameValuePair("IPT_LOGINPASSWORD", "231084198709033115"));

    request.setEntity(new UrlEncodedFormEntity(pair));

    CloseableHttpResponse response = httpClient.execute(request);

    HttpEntity entity = response.getEntity();
    System.out.println(entity);
    Header[] allHeaders = response.getAllHeaders();
    for (Header header : allHeaders) {
      System.out.println(header.getName());
      System.out.println(header.getValue());
    }

    StatusLine statusLine = response.getStatusLine();

    String resString = getResponseString(entity, "GBK");
    System.out.println(resString);

  }


  private static String getResponseString(HttpEntity entity, String charset) throws IOException {
    InputStream is = entity.getContent(); // Create an InputStream with the response
    BufferedReader reader = new BufferedReader(new InputStreamReader(is,
        charset), 8);
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) // Read line by line
    {
      sb.append(line).append("\n");
    }

    String resString = sb.toString(); // Result is here
    return resString;
  }

  private static Map<String, String> getFormParam(
      CloseableHttpClient httpClient) throws IOException {
    HttpGet get = new HttpGet(loginPage);
    HttpEntity entity = httpClient.execute(get).getEntity();

    String resString = getResponseString(entity, "UTF-8");

    Map<String, String> values = new HashMap<>();
    int hidden = resString.indexOf("row btn-row");
    String hs = resString.substring(hidden, hidden + 300);
    System.out.println("hs = " + hs);

    // 解析input
    int lt = hs.indexOf("lt");
    values.put("lt", hs.substring(lt + 11, lt + 11 + 76));
    System.out.println("values = " + values);
    return values;
  }


  //Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
  //Accept-Encoding: gzip, deflate
  //Accept-Language: zh-CN,zh;q=0.9
  //Cache-Control: max-age=0
  //Connection: keep-alive
  //Content-Length: 85
  //Content-Type: application/x-www-form-urlencoded
  //Cookie: JSESSIONID=65A33244A3EA66453A1A870D3B16B88E.TM1; DWRSESSIONID=21J5908NxQNy75sW*AC8L7I3unn
  //DNT: 1
  //Host: jiaoxue.cugbonline.cn
  //Origin: http://jiaoxue.cugbonline.cn
  //Referer: http://jiaoxue.cugbonline.cn/meol/jpk/course/layout/newpage/loginframe.jsp?courseId=10834
  //Upgrade-Insecure-Requests: 1
  //User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36 Edg/86.0.622.69
  private static void setHeader(HttpPost request) {
    request.addHeader("Accept",
        "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
    request.addHeader("Accept-Encoding", "gzip, deflate");
    request.addHeader("Accept-Language", "zh-CN,zh;q=0.9");
    request.addHeader("Cache-Control", "max-age=0");
    request.addHeader("Connection", "keep-alive");
    request.addHeader("Content-Type", "application/x-www-form-urlencoded");
    request.addHeader("DNT", "1");
    request.addHeader("Host", "jiaoxue.cugbonline.cn");
    request.addHeader("Origin", "http://jiaoxue.cugbonline.cn");
    request.addHeader("Referer",
        "http://jiaoxue.cugbonline.cn/meol/jpk/course/layout/newpage/loginframe.jsp?courseId=10834");
    request.addHeader("Upgrade-Insecure-Requests", "1");
    request.addHeader("User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36 Edg/86.0.622.69");
    request.addHeader("content-type", "application/x-www-form-urlencoded");
  }
}