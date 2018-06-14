package cn.zytx.common.json;

/**
 * 代表一个JsonObject/JsonArray
 * @author xiongshiyan at 2018/6/10
 */
public interface Json<T extends Json> {
    /**
     * Json对象转换为字符串
     */
    @Override
    String toString();

    @Override
    boolean equals(Object other);

    @Override
    int hashCode();

    /**
     * 解析Json字符串
     * @param jsonString Json字符串
     * @return JsonObject或者JsonArray
     */
    T parse(String jsonString);

    /**
     * 是否严格，像Json没有键而去获取是抛异常还是返回Null
     * @return true if isStrict
     */
    default boolean isStrict(){return true;}

    /**
     * 设置是否严格
     * @param isStrict true if isStrict
     */
    T setStrict(boolean isStrict);

    /**
     * 具体的实现类
     */
    Object unwrap();
}
