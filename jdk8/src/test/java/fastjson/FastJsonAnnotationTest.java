package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.spi.Module;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FastJsonAnnotationTest {

  @Test
  public void config() {
    SerializeConfig config = new SerializeConfig();

    Commodity commodity = new Commodity();
    commodity.setId(1L);
    commodity.setCreateTime(new Date());
    commodity.setUpdateTime(new Date());
    String jsonString = JSON.toJSONString(commodity, config);
    System.out.println("序列化结果:" + jsonString);

    Commodity commodity1 = JSON.parseObject("{\"updateTime\":\"1642932419127\",\"id\":\"1\"}",
        Commodity.class);
    System.out.println("反序列化结果:" + commodity1);

    JSONObject jsonObject = JSON.parseObject(jsonString);
  }

  @Test
  public void jsonFieldTest() {
    // 序列化
    Commodity commodity = getCommodity();
    String jsonString = JSON.toJSONString(commodity);
    System.out.println("序列化结果:{}" + jsonString);

    // 反序列化
    String json = "{\"createTime\":\"2021-1-12 05:12:03\",\"parts\":[{\"creator\":\"Head-01\",\"head\":\"Head-01\",\"type\":\"head\"},{\"creator\":\"Head-02\",\"head\":\"Head-02\",\"type\":\"head\"},{\"body\":\"Body-01\",\"creator\":\"Body-01\",\"type\":\"body\"}]}";
    Commodity commodityDest = JSON.parseObject(json, Commodity.class);
    System.out.println("反序列化结果:{}" + commodityDest);
    HeadFit one = (HeadFit) commodityDest.getParts().get(0);
    System.out.println("反序列化第一条记录:{}" + one);
  }

  private Commodity getCommodity() {
    Commodity commodity = new Commodity();
    commodity.setCreateTime(new Date());

    List<BaseFit> parts = new ArrayList<>();
    HeadFit headFit_01 = new HeadFit();
    headFit_01.setHead("Head-01");
    headFit_01.setCreator("Head-01");
    headFit_01.setType(EnumType.head);

    HeadFit headFit_02 = new HeadFit();
    headFit_02.setHead("Head-02");
    headFit_02.setCreator("Head-02");
    headFit_02.setType(EnumType.head);

    BodyFit bodyFit = new BodyFit();
    bodyFit.setBody("Body-01");
    bodyFit.setCreator("Body-01");
    bodyFit.setType(EnumType.body);

    parts.add(headFit_01);
    parts.add(headFit_02);
    parts.add(bodyFit);

    commodity.setParts(parts);
    return commodity;
  }

  public enum EnumType {
    head, body
  }

  public static class Commodity {

    /**
     * 时间,JSON格式字符串为非标准格式时间字符串
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss", deserializeUsing = LenientStringToDateProcessor.class)
    Date createTime;

    Date updateTime;
    /**
     * 对象属性集合,JSON格式字符串中包含了不同子类
     */
    @JSONField(deserializeUsing = PartProcessor.class)
    List parts;
    private Long id;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Date getCreateTime() {
      return createTime;
    }

    public void setCreateTime(Date createTime) {
      this.createTime = createTime;
    }

    public Date getUpdateTime() {
      return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
      this.updateTime = updateTime;
    }

    public List getParts() {
      return parts;
    }

    public void setParts(List parts) {
      this.parts = parts;
    }

    @Override
    public String toString() {
      return "Commodity{" +
          "createTime=" + createTime +
          ", updateTime=" + updateTime +
          ", parts=" + parts +
          ", id=" + id +
          '}';
    }
  }

  public static class HeadFit extends BaseFit {

    String head;

    public String getHead() {
      return head;
    }

    public void setHead(String head) {
      this.head = head;
    }

    @Override
    public String toString() {
      return "HeadFit{" +
          "head='" + head + '\'' +
          ", type=" + type +
          ", creator='" + creator + '\'' +
          '}';
    }
  }

  public static class BodyFit extends BaseFit {

    String body;

    public String getBody() {
      return body;
    }

    public void setBody(String body) {
      this.body = body;
    }

    @Override
    public String toString() {
      return "BodyFit{" +
          "body='" + body + '\'' +
          ", type=" + type +
          ", creator='" + creator + '\'' +
          '}';
    }
  }

  public static class BaseFit {

    EnumType type;
    String creator;

    public EnumType getType() {
      return type;
    }

    public void setType(EnumType type) {
      this.type = type;
    }

    public String getCreator() {
      return creator;
    }

    public void setCreator(String creator) {
      this.creator = creator;
    }

    @Override
    public String toString() {
      return "BaseFit{" +
          "type=" + type +
          ", creator='" + creator + '\'' +
          '}';
    }
  }

  public static class LenientStringToDateProcessor extends DateCodec {

    @Override
    public <T> T cast(DefaultJSONParser parser, Type clazz, Object fieldName, Object val) {
      try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 不要求传入字符串严格符合时间格式
        format.setLenient(false);
        if (val instanceof String) {
          String temp = (String) val;
          val = format.parse(temp);
        }
      } catch (Exception e) {
      }
      return super.cast(parser, clazz, fieldName, val);
    }
  }

  public static class PartProcessor implements ObjectDeserializer {

    /**
     * 由于集合序列化后为子类,再进行反序列化时,无法还原原对象,需要修改反序列化方法,手动修改反序列化逻辑
     *
     * @param parser
     * @param type
     * @param fieldName
     * @return
     */
    @Override
    public List<BaseFit> deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
      List<BaseFit> results = new ArrayList<>();
      List<JSONObject> baseFits = parser.parseArray(JSONObject.class);
      for (JSONObject base : baseFits) {
        /*
         * 通过父对象的类型标识字段,选择反序列化方式
         */
        EnumType enumType = base.getObject("type", EnumType.class);
        if (EnumType.head.equals(enumType)) {
          HeadFit headFit = base.toJavaObject(HeadFit.class);
          results.add(headFit);

        } else if (EnumType.body.equals(enumType)) {
          BodyFit bodyFit = base.toJavaObject(BodyFit.class);
          results.add(bodyFit);
        }
      }
      return results;
    }

    @Override
    public int getFastMatchToken() {
      return 0;
    }
  }
}

