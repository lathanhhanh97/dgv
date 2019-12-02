package com.thanhhanh.beta.model;

import org.springframework.http.HttpStatus;

public class ResponseData<T> {
    private HttpStatus status;
    private String msg;
    private T data;

    public ResponseData() {
    }

    public ResponseData(HttpStatus status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
