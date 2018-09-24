package top.jfunc.json.util;

import java.lang.reflect.Method;

public class BeanUtil {
    /**
     * 根据field 找到相应的getter，可能返回null
     */
    public static Method getGetter(Class<?> clazz , String fieldName){
        String prop = fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
        try {
            return clazz.getMethod("get" + prop);
        } catch (NoSuchMethodException e) {
            try {
                //boolean 类型的
                return clazz.getMethod("is" + prop);
            } catch (NoSuchMethodException e1) {
                return null;
            }
        }
    }
}
