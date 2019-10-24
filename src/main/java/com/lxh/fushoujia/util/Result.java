package com.lxh.fushoujia.util;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.List;

/**
 * @program: fushoujia
 * @description: 表示返回结果的实体，主要用于验证登录
 * @author: Mr.Wang
 * @create: 2019-10-10 17:41
 **/

public class Result {

    private String message; //返回详细信息
    private String code; //返回成功代码或者失败代码，200代表成功，404代表失败
    private String token; //登录验证码
    private Object object; //携带对象
    private List<?> list;//携带数组

    public Result() {

    }

    public Result(String message, String code) {
        this.message = message;
        this.code = code;
    }
    public Result(String message, String code, List<?> list) {
        this.message = message;
        this.code = code;
        this.list = list;
    }
    public Result(String message, String code, Object object) {
        this.message = message;
        this.code = code;
        this.object = object;
    }
    public Result(String message, String code, String token) {
        this.message = message;
        this.code = code;
        this.token = token;
    }
    public Result(String message, String code,Object object, List<?> list) {
        this.message = message;
        this.code = code;
        this.token = token;
        this.object = object;
        this.list = list;
    }


    public String getToken() {
        return token;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
