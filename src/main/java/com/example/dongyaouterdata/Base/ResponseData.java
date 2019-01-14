package com.example.dongyaouterdata.Base;

import lombok.Data;

@Data
public class ResponseData<T> {


    private int code;

    private T data;

    private String msg;


    /**
     * 处理成功
     * @param t 处理接口数据
     * @param msg 响应描述
     * @return 响应对象
     */
    public static <T> ResponseData<T> response(T t,String msg,int code) {
        ResponseData<T> response = new ResponseData<T>();
        response.setData(t);
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

}
