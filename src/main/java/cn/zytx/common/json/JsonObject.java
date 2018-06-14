package cn.zytx.common.json;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Set;

/**
 * 代表一个Json Object
 * @author xiongshiyan at 2018/6/10
 */
public interface JsonObject extends Json<JsonObject>, Serializable{
    /////////////////////get-related method////////////////////////

    Object get(String key);
    Object get(String key, Object defaultObject);

    JsonObject getJsonObject(String key);
    JsonArray getJsonArray(String key);

    String getString(String key);
    String getString(String key, String defaultValue);

    Boolean getBoolean(String key);
    Boolean getBoolean(String key, Boolean defaultValue);

    Integer getInteger(String key);
    Integer getInteger(String key, Integer defaultValue);

    Long getLong(String key);
    Long getLong(String key, Long defaultValue);

    Float getFloat(String key);
    Float getFloat(String key, Float defaultValue);

    Double getDouble(String key);
    Double getDouble(String key, Double defaultValue);

    BigInteger getBigInteger(String key);
    BigInteger getBigInteger(String key, BigInteger defaultValue);

    BigDecimal getBigDecimal(String key);
    BigDecimal getBigDecimal(String key, BigDecimal defaultValue);

    <T> T get(String key, Class<T> clazz);

    ///////////////////////map-related method////////////////////////
    Set<String> keySet();
    int size();
    boolean isEmpty();
    boolean containsKey(String key);
    boolean containsValue(Object value);
    void clear();
    Object remove(String key);
    JsonObject fromMap(Map<String, Object> map);

    /////////////////////put/change-related method////////////////////////

    JsonObject put(String key, Object value);

    JsonObject putAll(Map<? extends String, ? extends Object> m);
}
