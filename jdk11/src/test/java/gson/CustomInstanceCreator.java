package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;
import org.junit.jupiter.api.Test;

/**
 * https://futurestud.io/tutorials/gson-advanced-custom-instance-creator
 */
public class CustomInstanceCreator {

  @Test
  void test() {
    String userSimpleJson = "{\n"
        + "  \"age\": 26,\n"
        + "  \"email\": \"norman@fs.io\",\n"
        + "  \"isDeveloper\": true,\n"
        + "  \"name\": \"Norman\"\n"
        + "} "; // the JSON from the server, see above

    GsonBuilder gsonBuilder = new GsonBuilder();
//    gsonBuilder.registerTypeAdapter(
//        UserContext.class,
//        new UserContextInstanceCreator(getApplicationContext())
//    );
    Gson customGson = gsonBuilder.create();

    UserContext customObject = customGson.fromJson(userSimpleJson, UserContext.class);
    System.out.println(customObject);
  }

  private Context getApplicationContext() {
    return new Context();
  }

  private class UserContextInstanceCreator implements InstanceCreator<UserContext> {

    private Context context;

    public UserContextInstanceCreator(Context context) {
      this.context = context;
    }

    @Override
    public UserContext createInstance(Type type) {
      // create new object with our additional property
      UserContext userContext = new UserContext(context);

      // return it to gson for further usage
      return userContext;
    }
  }

  public class UserContext {

    private String name;
    private String email;
    private boolean isDeveloper;
    private int age;

    // additional attribute, which is not part of the data model
    private Context context;

    public UserContext() {
      System.out.println();
    }
    public UserContext(Context context) {
      this.context = context;
    }

    @Override
    public String toString() {
      return "UserContext{" +
          "name='" + name + '\'' +
          ", email='" + email + '\'' +
          ", isDeveloper=" + isDeveloper +
          ", age=" + age +
          ", context=" + context +
          '}';
    }
  }

  public class Context {

  }
}
