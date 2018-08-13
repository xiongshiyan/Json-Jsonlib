package top.jfunc.json;

/**
 * 代表一个JsonObject/JsonArray
 * @author xiongshiyan at 2018/6/10
 */
public interface Json<T extends Json> {
    /**
     * Json对象转换为字符串
     * @return String
     */
    @Override
    String toString();

    /**
     * 解析Json字符串
     * @param jsonString Json字符串
     * @return JsonObject或者JsonArray
     */
    T parse(String jsonString);

    /**
     * 是否相等
     * @param other 另外一个Json
     * @return true if ==
     */
    @Override
    boolean equals(Object other);

    /**
     * 计算hashCode值
     * @return hashCode
     */
    @Override
    int hashCode();

    /**
     * 是否严格，像Json没有键而去获取是抛异常还是返回Null
     * @return true if isStrict
     */
    default boolean isStrict(){return true;}

    /**
     * 设置是否严格
     * @param isStrict true if isStrict
     * @return Json本身，主要用于方法连缀
     */
    T setStrict(boolean isStrict);

    /**
     * 具体的实现类
     * @return 实现JsonObject和JsonArray的对象
     */
    Object unwrap();
}
