package cn.zytx.common.json;

/**
 * @author xiongshiyan at 2018/6/10
 */
public class JsonException extends RuntimeException{
    public JsonException(){};
    public JsonException(String message){
        super(message);
    }
    public JsonException(Exception e){
        super(e);
    }
}
