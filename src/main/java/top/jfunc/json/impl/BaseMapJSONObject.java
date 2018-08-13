package top.jfunc.json.impl;

import top.jfunc.json.JsonObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 基于Map的JSONObject实现基类
 * @author xiongshiyan at 2018/6/13
 */
public abstract class BaseMapJSONObject extends BaseJson<BaseMapJSONObject> implements JsonObject {

    protected Map<String , Object> map;

    public BaseMapJSONObject(Map<String , Object> map){
        this.map = map;
    }
    public BaseMapJSONObject(){
        this.map = new HashMap<>();
    }
    public BaseMapJSONObject(String jsonString){
        this.map = str2Map(jsonString);
    }

    protected abstract Map<String , Object> str2Map(String jsonString);

    @Override
    public Map<String , Object> unwrap() {
        return map;
    }

    @Override
    public Object get(String key) {
        assertKey(key);
        return checkNullValue(key , map.get(key));
    }

    @Override
    public Object get(String key, Object defaultObject) {
        assertKey(key);
        Object temp = map.get(key);
        return null == temp ? defaultObject : temp;
    }

    @Override
    public String getString(String key) {
        return getString(key , null);
    }

    @Override
    public String getString(String key, String defaultValue) {
        assertKey(key);
        boolean has = map.containsKey(key);
        if(!has){
            return checkNullValue(key , defaultValue);
        }
        String temp;
        Object value = this.map.get(key);
        if(isTolerant()){
            temp = ValueCompatible.compatibleValue(value, String.class);
        }else {
            temp = (String)value;
        }
        return temp;
    }

    @Override
    public Boolean getBoolean(String key) {
        return getBoolean(key , null);
    }

    @Override
    public Boolean getBoolean(String key, Boolean defaultValue) {
        assertKey(key);
        boolean has = map.containsKey(key);
        if(!has){
            return checkNullValue(key , defaultValue);
        }
        Boolean temp;
        Object value = this.map.get(key);
        if(isTolerant()){
            temp = ValueCompatible.compatibleValue(value, Boolean.class);
        }else {
            temp = (Boolean)value;
        }
        return temp;
    }

    @Override
    public Integer getInteger(String key) {
        return getInteger(key , null);
    }

    @Override
    public Integer getInteger(String key, Integer defaultValue) {
        assertKey(key);
        boolean has = map.containsKey(key);
        if(!has){
            return checkNullValue(key , defaultValue);
        }
        Integer temp;
        Object value = this.map.get(key);
        if(isTolerant()){
            temp = ValueCompatible.compatibleValue(value, Integer.class);
        }else {
            temp = (Integer)value;
        }
        return temp;
    }

    @Override
    public Long getLong(String key) {
        return getLong(key , null);
    }

    @Override
    public Long getLong(String key, Long defaultValue) {
        assertKey(key);
        boolean has = map.containsKey(key);
        if(!has){
            return checkNullValue(key , defaultValue);
        }
        Long temp;
        Object value = this.map.get(key);
        if(isTolerant()){
            temp = ValueCompatible.compatibleValue(value, Long.class);
        }else {
            temp = (Long)value;
        }
        return temp;
    }

    @Override
    public Float getFloat(String key) {
        return getFloat(key , null);
    }

    @Override
    public Float getFloat(String key, Float defaultValue) {
        assertKey(key);
        boolean has = map.containsKey(key);
        if(!has){
            return checkNullValue(key , defaultValue);
        }
        Float temp;
        Object value = this.map.get(key);
        if(isTolerant()){
            temp = ValueCompatible.compatibleValue(value, Float.class);
        }else {
            temp = (Float)value;
        }
        return temp;
    }

    @Override
    public Double getDouble(String key) {
        return getDouble(key , null);
    }

    @Override
    public Double getDouble(String key, Double defaultValue) {
        assertKey(key);
        boolean has = map.containsKey(key);
        if(!has){
            return checkNullValue(key , defaultValue);
        }
        Double temp;
        Object value = this.map.get(key);
        if(isTolerant()){
            temp = ValueCompatible.compatibleValue(value, Double.class);
        }else {
            temp = (Double)value;
        }
        return temp;
    }

    @Override
    public BigInteger getBigInteger(String key) {
        return getBigInteger(key , null);
    }

    @Override
    public BigInteger getBigInteger(String key, BigInteger defaultValue) {
        assertKey(key);
        boolean has = map.containsKey(key);
        if(!has){
            return checkNullValue(key , defaultValue);
        }
        BigInteger temp;
        Object value = this.map.get(key);
        if(isTolerant()){
            temp = ValueCompatible.compatibleValue(value, BigInteger.class);
        }else {
            temp = (BigInteger)value;
        }
        return temp;
    }

    @Override
    public BigDecimal getBigDecimal(String key) {
        return getBigDecimal(key , null);
    }

    @Override
    public BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
        assertKey(key);
        boolean has = map.containsKey(key);
        if(!has){
            return checkNullValue(key , defaultValue);
        }
        BigDecimal temp;
        Object value = this.map.get(key);
        if(isTolerant()){
            temp = ValueCompatible.compatibleValue(value, BigDecimal.class);
        }else {
            temp = (BigDecimal)value;
        }
        return temp;
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        Object o = map.get(key);
        return (T)o;
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public JsonObject put(String key, Object value) {
        map.put(key, value);
        return this;
    }

    @Override
    public JsonObject putAll(Map<? extends String, ?> m) {
        map.putAll(m);
        return this;
    }
    @Override
    public JsonObject fromMap(Map<String, Object> map) {
        this.map = map;
        return this;
    }
    @Override
    public JsonObject clear() {
        map.clear();
        return this;
    }

    @Override
    public Object remove(String key) {
        return map.remove(key);
    }


    @Override
    public int hashCode() {
        return map.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return map.equals(obj);
    }
}
