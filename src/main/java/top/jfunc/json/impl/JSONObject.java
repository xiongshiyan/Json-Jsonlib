package top.jfunc.json.impl;

import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JsonConfig;
import top.jfunc.json.Json;
import top.jfunc.json.JsonArray;
import top.jfunc.json.JsonObject;
import top.jfunc.json.strategy.IgnorePropertyFilter;
import top.jfunc.json.strategy.JsonFieldPropertyNameProcessor;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiongshiyan at 2018/6/10
 */
public class JSONObject extends BaseMapJSONObject {

    public JSONObject(Map<String , Object> map){
        super(map);
    }
    public JSONObject(){
        super();
    }
    public JSONObject(String jsonString){
        super(jsonString);
    }

    @Override
    protected Map<String, Object> str2Map(String jsonString) {
        Map<String, Object> o = (Map<String, Object>) net.sf.json.JSONObject.toBean(
                net.sf.json.JSONObject.fromObject(jsonString), Map.class);
        Map<String , Object> temp = new HashMap<>();
        o.forEach((k , v)->{
            if(v instanceof MorphDynaBean){
                Field[] declaredFields = MorphDynaBean.class.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    if("dynaValues".equals(declaredField.getName())){
                        try {
                            declaredField.setAccessible(true);
                            Object o1 = declaredField.get(v);
                            temp.put(k , o1);

                        } catch (IllegalAccessException e) { }
                        break;
                    }
                }
            }
        });
        o.putAll(temp);
        return o;
    }

    @Override
    protected String map2Str(Map<String, Object> map) {
        return net.sf.json.JSONObject.fromObject(map).toString();
    }

    @Override
    public JsonObject getJsonObject(String key) {
        assertKey(key);
        //这里不能使用getJSONObject，因为每一种Json实现不一样，给出的JsonObject类型是不一致的。
        //这里就是各种JsonObject不能混用的原因
        Object temp = this.map.get(key);
        Object t = checkNullValue(key, temp);

        if(t instanceof Map){
            return new JSONObject((Map<String, Object>) t);
        }

        return (JsonObject) t;
    }

    @Override
    public JsonArray getJsonArray(String key) {
        assertKey(key);
        //这里不能使用getJSONObject，因为每一种Json实现不一样，给出的JsonObject类型是不一致的。
        //这里就是各种JsonObject不能混用的原因
        Object temp = this.map.get(key);
        Object t = checkNullValue(key, temp);

        if(t instanceof List){
            return new JSONArray((List<Object>)t);
        }
        return (JsonArray) t;
    }


    @Override
    public JsonObject parse(String jsonString) {
        this.map = str2Map(jsonString);
        return this;
    }

    @Override
    public <T> String serialize(T javaBean, boolean nullHold, String... ignoreFields) {
        JsonConfig config = new JsonConfig();
        //config.setExcludes(new String[]{"excludes-field-name"});
        //config.addIgnoreFieldAnnotation(JsonField.class);
        config.setJsonPropertyFilter(new IgnorePropertyFilter(nullHold , ignoreFields));
        config.setIgnoreTransientFields(true);
        config.registerJsonPropertyNameProcessor(javaBean.getClass(), new JsonFieldPropertyNameProcessor());
        return net.sf.json.JSONObject.fromObject(javaBean , config).toString();
    }


    @Override
    public <T> T deserialize(String jsonString, Class<T> clazz) {
        return (T)net.sf.json.JSONObject.toBean(net.sf.json.JSONObject.fromObject(jsonString) , clazz);
    }
}
