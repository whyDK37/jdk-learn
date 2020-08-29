package o2o;

public class Token {

  String appId;
  String secret;
  String token;

  public Token(String appId, String secret, String token) {
    this.appId = appId;
    this.secret = secret;
    this.token = token;
  }

  public String getAppId() {
    return appId;
  }

  public String getSecret() {
    return secret;
  }

  public String getToken() {
    return token;
  }
}
