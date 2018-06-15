package cn.zytx.common.json;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

/**
 * 代表一个Json Array , 本质上可以看做一个list
 * @author xiongshiyan at 2018/6/10
 */
public interface JsonArray extends Json<JsonArray>{
    /**
     * 返回JsonArray中的元素个数
     * @return size of elements
     */
    int size();

    /**
     * 根据索引返回对象
     * @param index 索引
     * @return 该位置的对象
     */
    Object get(int index);

    /**
     * 根据索引返回String对象
     * @param index 索引
     * @return 该位置的String对象
     */
    String getString(int index);

    /**
     * 根据索引返回Boolean对象
     * @param index 索引
     * @return 该位置的Boolean对象
     */
    Boolean getBoolean(int index);

    /**
     * 根据索引返回Integer对象
     * @param index 索引
     * @return 该位置的Integer对象
     */
    Integer getInteger(int index);

    /**
     * 根据索引返回Long对象
     * @param index 索引
     * @return 该位置的Long对象
     */
    Long getLong(int index);

    /**
     * 根据索引返回Double对象
     * @param index 索引
     * @return 该位置的Double对象
     */
    Double getDouble(int index);

    /**
     * 根据索引返回Float对象
     * @param index 索引
     * @return 该位置的Float对象
     */
    Float getFloat(int index);

    /**
     * 根据索引返回BigInteger对象
     * @param index 索引
     * @return 该位置的BigInteger对象
     */
    BigInteger getBigInteger(int index);

    /**
     * 根据索引返回BigDecimal对象
     * @param index 索引
     * @return 该位置的BigDecimal对象
     */
    BigDecimal getBigDecimal(int index);

    /**
     * 根据索引返回JsonObject对象
     * @param index 索引
     * @return 该位置的JsonObject对象
     */
    JsonObject getJsonObject(int index);

    /**
     * 根据索引返回JsonArray对象
     * @param index 索引
     * @return 该位置的JsonArray对象
     */
    JsonArray getJsonArray(int index);

    /**
     * 根据索引删除
     * @param index 索引
     * @return this
     */
    JsonArray remove(int index);

    /**
     * 清空
     * @return this
     */
    JsonArray clear();

    /**
     * 在末尾放置一个对象进JsonArray
     * @param o 要放置的对象
     * @return this
     */
    JsonArray put(Object o);

    /**
     * 在索引放置一个对象进JsonArray
     * @param index 索引位置
     * @param o 要放置的对象
     * @return this
     */
    JsonArray put(int index, Object o);

    /**
     * 将集合中的元素放进JsonArray的末尾
     * @param os 集合
     * @return this
     */
    JsonArray putAll(Collection<?> os);

    /**
     * 根据list解析成为一个JsonArray
     * @param list list
     * @return this
     */
    JsonArray fromList(List<Object> list);
}
