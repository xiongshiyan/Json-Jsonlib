package top.jfunc.json;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Set;

/**
 * 代表一个Json Object , 本质上可以看作一个map
 * @author xiongshiyan at 2018/6/10
 */
public interface JsonObject extends Json<JsonObject>, Serializable {

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

    /**
     * 获取所有的key
     * @return set of keys
     */
    Set<String> keySet();

    /**
     * 有多少个key
     * @return numbers of key
     */
    int size();

    /**
     * 是否是空
     * @return true if 空
     */
    boolean isEmpty();

    /**
     * 是否包含某个key
     * @param key 指定的key
     * @return true if contains
     */
    boolean containsKey(String key);

    /**
     * 是否包含某个value
     * @param value 指定的value
     * @return true if contains
     */
    boolean containsValue(Object value);

    /**
     * 清空
     * @return this
     */
    JsonObject clear();

    /**
     * 去除某个key
     * @param key 指定的key
     * @return key对应的值
     */
    Object remove(String key);

    /**
     * 从给定的map解析出JsonObject
     * @param map map
     * @return 解析的JsonObject
     */
    JsonObject fromMap(Map<String, Object> map);

    /**
     * 放入某个key-value
     * @param key key
     * @param value value
     * @return this
     */
    JsonObject put(String key, Object value);

    /**
     * 将一个map的所有key-value放入
     * @param m map
     * @return this
     */
    JsonObject putAll(Map<? extends String, ? extends Object> m);
}
