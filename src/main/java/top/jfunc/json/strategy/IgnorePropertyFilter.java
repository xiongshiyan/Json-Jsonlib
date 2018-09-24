package top.jfunc.json.strategy;

import net.sf.json.util.PropertyFilter;
import top.jfunc.json.annotation.JsonField;
import top.jfunc.json.util.BeanUtil;

import java.lang.reflect.Method;

public class IgnorePropertyFilter implements PropertyFilter{
    private boolean nullHold;
    private String[] ignoreFields;

    public IgnorePropertyFilter(boolean nullHold, String[] ignoreFields) {
        this.nullHold = nullHold;
        this.ignoreFields = ignoreFields;
    }

    @Override
    public boolean apply(Object object, String name, Object value) {
        if(!nullHold && null == value){
            return true;
        }

        if(shouldIgnore(ignoreFields , name)){
            return true;
        }

        Method getter = BeanUtil.getGetter(object.getClass(), name);
        if(null != getter){
            JsonField annotation = getter.getAnnotation(JsonField.class);
            if(null != annotation){
                return !annotation.serialize();
            }
        }

        return false;
    }
    private boolean shouldIgnore(String[] ignoreFields , String fieldName){
        if(ignoreFields == null || ignoreFields.length == 0){
            return false;
        }

        for (int i = 0; i < ignoreFields.length; i++) {
            if(fieldName.equals(ignoreFields[i])){
                return true;
            }
        }
        return false;
    }
}
