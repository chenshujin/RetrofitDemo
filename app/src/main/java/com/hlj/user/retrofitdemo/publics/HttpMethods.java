package com.hlj.user.retrofitdemo.publics;

import android.util.Log;

import com.hlj.user.retrofitdemo.ProductInfo;
import com.hlj.user.retrofitdemo.bean.MovieEntity;
import com.hlj.user.retrofitdemo.interfaces.MovieService;
import com.hlj.user.retrofitdemo.interfaces.ProductInfoService;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by ${csj} on 16/6/7.
 */
public class HttpMethods {
    public static final String BASE_URL = "http://test.dev.honglingjinclub.com/";

    private static final int DEFAULT_TIMEOUT = 5;
    public static final String TAG = "HttpMethods";
    private final ProductInfoService productInfoService;

    private Retrofit retrofit;
    private MovieService movieService;

    //构造方法私有
    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Log.d(TAG, "地址是:" + original.url().url().toString());
                Log.d(TAG, original.url().toString());
                Log.d(TAG, original.url().query());
                Log.d(TAG, "长度:" + original.url().querySize());
                String url = "";
                if (original.url().querySize() > 0) {
                    url = original.url().toString() + "&utm_content=android";
                }
                Request request = original.newBuilder()
                        .url(url)
                        .method(original.method(), original.body())
                        .build();
//                original.url()

                Log.d(TAG, "改变后的url" + request.url().toString());
                Log.d(TAG, "改变后的长度:" + request.url().querySize());
                return chain.proceed(request);
            }
        });

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加适配器
                .baseUrl(BASE_URL)
                .build();

//        movieService = retrofit.create(MovieService.class);
        productInfoService = retrofit.create(ProductInfoService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    //获取单例
    public static HttpMethods getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public void getProductInfo(Subscriber<MyHttpResult<ProductInfo.BodyEntity>> subscriber,int productid,int communityid){
        productInfoService.getProductInfo(productid,communityid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 用于获取豆瓣电影Top250的数据
     * @param subscriber 由调用者传过来的观察者对象
     * @param start 起始位置
     * @param count 获取长度
     */
    public void getTopMovie(Subscriber<HttpResult<List<MovieEntity.SubjectsEntity>>> subscriber, int start, int count){
        //观察结果是HttpResult<List<List<MovieEntity.SubjectsEntity>>
        movieService.getTopMovie(start, count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);


       /* movieService.getTopMovie(start, count)
                .map(new HttpResultFunc<List<MovieEntity.SubjectsEntity>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/

        /*Observable observable=movieService.getTopMovie(start,count)
                .map(new HttpResultFunc<List<MovieEntity.SubjectsEntity>>());
        toSubscribe(observable,subscriber);*/
    }

//    public void getOrderInfo(Subscriber<OrderInfo> subscriber,int communityId,)

    //订阅部分封装起来
    private void toSubscribe(Observable o,Subscriber s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getCount() == 0) {
//                throw new ApiException(httpResult.getErrMsg());
            }
            return httpResult.getSubjects();
        }
    }
}
