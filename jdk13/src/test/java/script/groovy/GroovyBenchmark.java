package script.groovy;

import groovy.json.internal.LazyMap;
import org.openjdk.jmh.annotations.Benchmark;

public class GroovyBenchmark {

    @Benchmark
    public void groovy() {
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
        GroovyUtils.evalExpression("actionCode==null?0:actionCode", lazyMap);
    }

    @Benchmark
    public void java() {
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
        Object actionCode = lazyMap.get("actionCode");
        Object o = actionCode == null ? 0 : actionCode;
    }

}