package top.jfunc.json.strategy;

import net.sf.json.processors.PropertyNameProcessor;
import top.jfunc.json.annotation.JsonField;
import top.jfunc.json.util.BeanUtil;

import java.lang.reflect.Method;

/**
 * 根据JsonField注解改变名字
 * @author 熊诗言
 */
public class JsonFieldPropertyNameProcessor implements PropertyNameProcessor{
    @Override
    public String processPropertyName(Class javaBeanClass, String name) {

        Method getter = BeanUtil.getGetter(javaBeanClass, name);
        if(null == getter){
            return name;
        }
        JsonField annotation = getter.getAnnotation(JsonField.class);
        if(null != annotation && !"".equals(annotation.value())){
            return annotation.value();
        }

        return name;
    }
}
