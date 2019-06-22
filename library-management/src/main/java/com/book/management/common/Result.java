package com.book.management.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一的json返回格式
 */
@Data
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
}
