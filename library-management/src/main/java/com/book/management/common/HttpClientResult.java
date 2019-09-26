package com.book.management.common;

import java.io.Serializable;

/**
 * HttpClient返回结果封装
 */
public class HttpClientResult implements Serializable {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    /**
     * 构造方法
     */
    public HttpClientResult() {
    }

    /**
     * 构造方法
     * @param code
     */
    public HttpClientResult(int code) {
        this.code = code;
    }

    /**
     * 构造方法
     * @param code
     * @param content
     */
    public HttpClientResult(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
