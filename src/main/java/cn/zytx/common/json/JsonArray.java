package cn.zytx.common.json;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

/**
 * 代表一个Json Array
 * @author xiongshiyan at 2018/6/10
 */
public interface JsonArray extends Json<JsonArray>{
    int size();

    Object get(int index);

    String getString(int index);
    Boolean getBoolean(int index);
    Integer getInteger(int index);
    Long getLong(int index);
    Double getDouble(int index);
    Float getFloat(int index);
    BigInteger getBigInteger(int index);
    BigDecimal getBigDecimal(int index);

    JsonObject getJsonObject(int index);
    JsonArray getJsonArray(int index);

    JsonArray remove(int index);
    JsonArray clear();

    JsonArray put(Object o);
    JsonArray put(int index, Object o);
    JsonArray putAll(Collection<?> os);

    JsonArray fromList(List<Object> list);
}
