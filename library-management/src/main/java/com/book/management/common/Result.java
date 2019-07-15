package com.book.management.common;


import java.util.HashMap;
import java.util.Map;

/**
 * 统一的json返回格式
 */
public class Result {

    private boolean ret; // 返回结果

    private String msg; // 异常信息

    private Object data; // 正常返回数据

    public Result(boolean ret) {
        this.ret = ret;
    }

    public static Result success(Object object, String msg) {
        Result result = new Result(true);
        result.data = object;
        result.msg = msg;
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result(true);
        result.data = object;
        return result;
    }

    public static Result success() {
        return new Result(true);

    }

    /**
     * 异常
     * @param msg
     * @return
     */
    public static Result fail(String msg) {
        Result result = new Result(false);
        result.msg = msg;
        return result;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("ret", ret);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
