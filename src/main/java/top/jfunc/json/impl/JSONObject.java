package top.jfunc.json.impl;

import top.jfunc.json.Json;
import top.jfunc.json.JsonArray;
import top.jfunc.json.JsonObject;
import net.sf.ezmorph.bean.MorphDynaBean;

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
    public String serialize(Object javaBean) {
        return net.sf.json.JSONObject.fromObject(javaBean).toString();
    }

    @Override
    public <T> T deserialize(String jsonString, Class<T> clazz) {
        return (T)net.sf.json.JSONObject.toBean(net.sf.json.JSONObject.fromObject(jsonString) , clazz);
    }

    @Override
    public String toString() {
        //需要针对JsonObject/JsonArray处理
        Map<String , Json> map = new HashMap<>();
        for (String key : map.keySet()) {
            Object o = map.get(key);
            if(o instanceof JsonObject || o instanceof JsonArray){
                map.put(key , (Json) o);
            }
        }
        map.forEach((k , v)-> this.map.put(k , v.unwrap()));

        return net.sf.json.JSONObject.fromObject(this.map).toString();
    }
}
