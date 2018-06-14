package cn.zytx.common.json.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author xiongshiyan at 2018/6/12
 */
public class ValueCompatible {
    /**
     * 将一个值转换为兼容类型的值
     * @param value src
     * @param toClazz 转换的类型
     */
    public static <T> T compatibleValue(Object value , Class<T> toClazz){
        if(value == null){return null;}
        if(toClazz == String.class){
            return (T)value.toString();
        }
        if(toClazz == Integer.class || toClazz == int.class){
            if(value instanceof Number){
                return (T)Integer.valueOf(((Number)value).intValue());
            }else if(value instanceof String){
                return (T)Integer.valueOf((String) value);
            }
        }
        if(toClazz == Long.class || toClazz == long.class){
            if(value instanceof Number){
                return (T)Long.valueOf(((Number)value).longValue());
            }else if(value instanceof String){
                return (T)Long.valueOf((String) value);
            }
        }
        if(toClazz == Double.class || toClazz == Double.class){
            if(value instanceof Number){
                return (T)Double.valueOf(((Number)value).doubleValue());
            }else if(value instanceof String){
                return (T)Double.valueOf((String) value);
            }
        }
        if(toClazz == Float.class || toClazz == float.class){
            if(value instanceof Number){
                return (T)Float.valueOf(((Number)value).floatValue());
            }else if(value instanceof String){
                return (T)Float.valueOf((String) value);
            }
        }
        if(toClazz == BigDecimal.class){
            return (T)new BigDecimal(value.toString());
        }
        if(toClazz == BigInteger.class){
            return (T)new BigInteger(value.toString());
        }
        if(toClazz == Boolean.class || toClazz == boolean.class){
            return (T)Boolean.valueOf(value.toString());
        }
        if(toClazz == Character.class || toClazz == char.class){
            return (T)value;
        }
        if(toClazz == Byte.class || toClazz == byte.class){
            if(value instanceof Number){
                return (T)Byte.valueOf(((Number)value).byteValue());
            }else if(value instanceof String){
                return (T)Byte.valueOf((String) value);
            }
        }
        if(toClazz == Short.class || toClazz == short.class){
            if(value instanceof Number){
                return (T)Short.valueOf(((Number)value).shortValue());
            }else if(value instanceof String){
                return (T)Short.valueOf((String) value);
            }
        }

        /*if(toClazz == java.util.Date.class){
            if(value instanceof String){
                try {
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else if(value instanceof Number){
                return new Date(((Number) value).longValue());
            }
        }*/

        return (T)value;
    }
}
