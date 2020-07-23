package script.groovy;

import com.alibaba.fastjson.JSON;
import groovy.json.JsonSlurper;
import groovy.json.internal.LazyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GroovyUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(GroovyUtils.class);
    private static Map<String, CompiledScript> concurrentHashMap = new ConcurrentHashMap<>();

    private static ScriptEngine engine = null;

    static {
        ScriptEngineManager factory = new ScriptEngineManager();
        engine = factory.getEngineByName("groovy");
        assert engine != null;
    }

    public static Object evalExpression(String expression, Bindings bindings) {
        if (expression == null) {
            return null;
        }
        try {
            final CompiledScript compiledScript = getCompiledScript(expression, expression);
            return compiledScript.eval(bindings);
        } catch (ScriptException e) {
            LOGGER.error("脚本执行异常,expression:[{}], bindings:[{}] ", expression, JSON.toJSONString(bindings), e);
            return expression;
        }
    }

    public static Object evalExpression(String expression, Map<String, Object> env) {
        Bindings bindings = new SimpleBindings();
        bindings.putAll(env);
        return evalExpression(expression, bindings);
    }

    public static <T> T evalExpression(String expression, Map<String, Object> env, Class<T> clazz) {
        Object obj = evalExpression(expression, env);
        if (obj != null && obj.getClass() == clazz) {
            return (T) obj;
        }
        return null;
    }

    public static String evalExpressionToString(String expression, Map<String, Object> env) {
        Object obj = evalExpression(expression, env);
        if (obj == null) {
            return null;
        }
        return obj + "";
    }

    public static LazyMap parseObjectByJsonURL(String url) {
        if (url == null) {
            throw new IllegalArgumentException("the url must be not empty");
        }
        try {
            JsonSlurper jsonSlurper = new JsonSlurper();
            Object object = jsonSlurper.parse(new URL(url));
            if (object != null && object instanceof LazyMap) {
                return (LazyMap) object;
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL Exception", e);
        }
        return null;
    }

    public static LazyMap parseObjectByJson(String jsonStr) {
        if (jsonStr == null) {
            throw new IllegalArgumentException("the url must be not empty");
        }
        JsonSlurper jsonSlurper = new JsonSlurper();
        Object object = jsonSlurper.parse(jsonStr.getBytes());
        if (object != null && object instanceof LazyMap) {
            return (LazyMap) object;
        }
        return null;
    }

    public static LazyMap parseObjectByJsonText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("the text must be not empty");
        }
        JsonSlurper jsonSlurper = new JsonSlurper();
        Object object = jsonSlurper.parseText(text);
        if (object instanceof LazyMap) {
            return (LazyMap) object;
        }
        return null;
    }

    /**
     * 编译脚本并缓存脚本，达到编译一次，多次执行
     */
    private static CompiledScript getCompiledScript(String scriptName, String logicRule) throws ScriptException {
        CompiledScript script = concurrentHashMap.get(scriptName);
        if (script == null) {
            script = ((Compilable) engine).compile(logicRule);
            concurrentHashMap.putIfAbsent(scriptName, script);
        }
        return script;
    }
}
