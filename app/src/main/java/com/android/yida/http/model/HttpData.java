package com.android.yida.http.model;

import java.io.Serializable;

/**
 * desc   : 统一接口数据结构
 */
public class HttpData<T> implements Serializable {

    /**
     * 返回码
     */
    private State state;
    /**
     * 提示语
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public class State {
        private String code;
        private String msg;

    }
}