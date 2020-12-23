package script.groovy;

import groovy.json.internal.LazyMap;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroovyUtilsTest {

    public static void main(String[] args) throws IOException {
        GroovyUtilsTest test = new GroovyUtilsTest();
        test.main();
        System.in.read();
    }

    @Test
    public void main() {
        String json = "{\n" +
                "    \"qty\": 10,\n" +
                "    \"weight\": 0.5,\n" +
                "    \"volume\": 0.5,\n" +
                "    \"businessDate\": \"2020-02-13 14:43:52\",\n" +
                "    \"goodsNo\": \"1234567890\",\n" +
                "    \"startOneAddress\": \"14\",\n" +
                "    \"startTwoAddress\": \"1140\",\n" +
                "    \"startThreeAddress\": \"\",\n" +
                "    \"startFourAddress\": \"\",\n" +
                "    \"endOneAddress\": \"14\",\n" +
                "    \"endTwoAddress\": \"1140\",\n" +
                "    \"endThreeAddress\": \"\",\n" +
                "    \"endFourAddress\": \"\",\n" +
                "    \"productSign\": \"9\",\n" +
                "    \"actionCode\": \"2\",\n" +
                "    \"isSupport\": 1,\n" +
                "    \"guaranteeValue\": 1001,\n" +
                "    \"productCode\": \"lq-m-0004\",\n" +
                "    \"largePieceType\": 1\n" +
                "}";

        LazyMap lazyMap = GroovyUtils.parseObjectByJson(json);
        System.out.println(lazyMap.get("qty").getClass());
        assertEquals(10, lazyMap.get("qty"));

        System.out.println(GroovyUtils.evalExpression("actionCode==null?0:actionCode", lazyMap));

//        assertEquals("message.qty", GroovyUtils.evalExpression("message.qty", lazyMap));
//        assertEquals("0", GroovyUtils.evalExpressionToString("0", lazyMap));
    }
}