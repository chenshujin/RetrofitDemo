package com.hlj.user.retrofitdemo.exceptions;

import android.util.Log;

/**
 * Created by ${csj} on 16/6/8.
 */
public class ApiException extends Exception {
    public ApiException(String errMsg) {
        try {
            Log.d("ApiException",errMsg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
