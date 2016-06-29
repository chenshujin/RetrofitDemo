package com.hlj.user.retrofitdemo.publics;

/**
 * Created by ${csj} on 16/6/7.
 */
public class HttpResult<T> {
    //用来模仿resultCode和resultMessage
    private int count;
    private int start;
    private int total;
    private String title;
    private String errMsg="出错了count为0";

    public String getErrMsg() {
        return errMsg;
    }

    //用来模仿Data
    private T body;

    @Override
    public String toString() {
        return "HttpResult{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", title='" + title + '\'' +
                ", subjects=" + body +
                '}';
    }

    public T getSubjects() {
        return body;
    }

    public int getCount() {
        return count;
    }
}
