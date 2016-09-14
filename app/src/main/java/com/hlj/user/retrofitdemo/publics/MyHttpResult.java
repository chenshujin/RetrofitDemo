package com.hlj.user.retrofitdemo.publics;

/**
 * Created by ${csj} on 16/8/2.
 */
public class MyHttpResult<T>{
    private int code;
    private T body;

    @Override
    public String toString() {
        return "MyHttpResult{" +
                "code=" + code +
                ", body=" + body +
                '}';
    }
}
