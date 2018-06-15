package cn.zytx.common.json;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Set;

/**
 * 代表一个Json Object , 本质上可以看作一个map
 * @author xiongshiyan at 2018/6/10
 */
public interface JsonObject extends Json<JsonObject>, Serializable{

    /**
     * 根据key获取对象
     * @param key key
     * @return 该key对应的对象
     */
    Object get(String key);

    /**
     * 根据key获取对象
     * @param key key
     * @param defaultObject 该key对应的对象为null返回 默认对象
     * @return 该key对应的对象
     */
    Object get(String key, Object defaultObject);

    /**
     * 根据key获取JsonObject对象
     * @param key key
     * @return 该key对应的JsonObject对象
     */
    JsonObject getJsonObject(String key);

    /**
     * 根据key获取JsonArray对象
     * @param key key
     * @return 该key对应的JsonArray对象
     */
    JsonArray getJsonArray(String key);

    /**
     * 根据key获取String对象
     * @param key key
     * @return 该key对应的String对象
     */
    String getString(String key);

    /**
     * 根据key获取String对象
     * @param key key
     * @param defaultValue 该key对应的对象为null 返回默认String对象
     * @return 该key对应的Boolean对象
     */
    String getString(String key, String defaultValue);

    /**
     * 根据key获取Boolean对象
     * @param key key
     * @return 该key对应的Boolean对象
     */
    Boolean getBoolean(String key);

    /**
     * 根据key获取Boolean对象
     * @param key key
     * @param defaultValue 该key对应的对象为null 返回默认Boolean对象
     * @return 该key对应的Boolean对象
     */
    Boolean getBoolean(String key, Boolean defaultValue);

    /**
     * 根据key获取Integer对象
     * @param key key
     * @return 该key对应的Integer对象
     */
    Integer getInteger(String key);

    /**
     * 根据key获取Integer对象
     * @param key key
     * @param defaultValue 该key对应的对象为null 返回默认Integer对象
     * @return 该key对应的Integer对象
     */
    Integer getInteger(String key, Integer defaultValue);

    /**
     * 根据key获取Long对象
     * @param key key
     * @return 该key对应的Long对象
     */
    Long getLong(String key);

    /**
     * 根据key获取Long对象
     * @param key key
     * @param defaultValue 该key对应的对象为null 返回默认Long对象
     * @return 该key对应的Long对象
     */
    Long getLong(String key, Long defaultValue);

    /**
     * 根据key获取Float对象
     * @param key key
     * @return 该key对应的Float对象
     */
    Float getFloat(String key);

    /**
     * 根据key获取Float对象
     * @param key key
     * @param defaultValue 该key对应的对象为null 返回默认Float对象
     * @return 该key对应的Float对象
     */
    Float getFloat(String key, Float defaultValue);

    /**
     * 根据key获取Double对象
     * @param key key
     * @return 该key对应的Double对象
     */
    Double getDouble(String key);

    /**
     * 根据key获取Double对象
     * @param key key
     * @param defaultValue 该key对应的对象为null 返回默认Double对象
     * @return 该key对应的Double对象
     */
    Double getDouble(String key, Double defaultValue);

    /**
     * 根据key获取BigInteger对象
     * @param key key
     * @return 该key对应的BigInteger对象
     */
    BigInteger getBigInteger(String key);

    /**
     * 根据key获取BigInteger对象
     * @param key key
     * @param defaultValue 该key对应的对象为null 返回默认BigInteger对象
     * @return 该key对应的BigInteger对象
     */
    BigInteger getBigInteger(String key, BigInteger defaultValue);


    /**
     * 根据key获取BigDecimal对象
     * @param key key
     * @return 该key对应的BigDecimal对象
     */
    BigDecimal getBigDecimal(String key);

    /**
     * 根据key获取BigDecimal对象
     * @param key key
     * @param defaultValue 该key对应的对象为null 返回默认BigDecimal对象
     * @return 该key对应的BigDecimal对象
     */
    BigDecimal getBigDecimal(String key, BigDecimal defaultValue);

    /**
     * 根据key获取泛型对象
     * @param key key
     * @param clazz 泛型化class
     * @return 该key对应的泛型对象
     */
    <T> T get(String key, Class<T> clazz);

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
