package cn.zytx.common.json.impl;

import cn.zytx.common.json.Json;
import cn.zytx.common.json.JsonException;

/**
 * 提供一些公共的校验方法和特性，子类负责实现
 * @author xiongshiyan at 2018/6/11
 */
public abstract class BaseJson<T extends Json> {
    private boolean isStrict = true;
    private boolean isTolerant = true;

    public boolean isStrict(){return isStrict;}

    public T setStrict(boolean isStrict){this.isStrict = isStrict; return (T)this;}

    public boolean isTolerant(){return isTolerant;}

    public T setTolerant(boolean isTolerant){
        this.isTolerant = isTolerant;
        return (T)this;
    }

    protected void assertKey(String key){
        if(null == key){
            throw new IllegalArgumentException("key 不能为空");
        }
    }
    protected  <R> R checkNullValue(String key , R o) {
        if(null == o){
            if(isStrict()){
                throw new JsonException("不存在key->" + key);
            }else {
                return null;
            }
        }
        return o;
    }
    protected  <R> R checkNullValue(int index , R o) {
        if(null == o){
            if(isStrict()){
                throw new JsonException("不存在->[ " + index + " ]");
            }else {
                return null;
            }
        }
        return o;
    }

    protected void assertIndex(int index , int size){
        //越界
        if(index < 0 || index >= size){
            //严格模式
            if(isStrict()){
                throw new JsonException(new ArrayIndexOutOfBoundsException("index must between 0 and " + size));
            }
        }
    }
}
