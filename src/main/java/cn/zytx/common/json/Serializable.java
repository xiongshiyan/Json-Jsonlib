package cn.zytx.common.json;

/**
 * 序列化，反序列化能力
 * @author xiongshiyan at 2018/6/10
 */
public interface Serializable {
    /**
     * 序列化，把一个JavaBean序列化为String
     */
    String serialize(Object javaBean);

    /**
     * 反序列化，把一个字符串反序列化为一个JavaBean
     */
    <T> T deserialize(String jsonString, Class<T> clazz);
}
