package top.jfunc.json;

/**
 * 1.JavaBean序列化为String
 * 2.String反序列化为JavaBean
 * @author xiongshiyan at 2018/6/10
 */
public interface Serializable {
    /**
     * 序列化，把一个JavaBean序列化为String
     * @param javaBean JavaBean对象
     * @return String
     */
    String serialize(Object javaBean);

    /**
     * 反序列化，把一个字符串反序列化为一个JavaBean
     * @param jsonString Json String
     * @param clazz JavaBean Class
     */
    <T> T deserialize(String jsonString, Class<T> clazz);
}
