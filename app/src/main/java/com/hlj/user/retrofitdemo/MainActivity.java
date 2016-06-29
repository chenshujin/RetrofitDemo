package com.hlj.user.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hlj.user.retrofitdemo.bean.MovieEntity;
import com.hlj.user.retrofitdemo.bean.OrderInfo;
import com.hlj.user.retrofitdemo.interfaces.MovieService;
import com.hlj.user.retrofitdemo.interfaces.SubscriberOnNextListener;
import com.hlj.user.retrofitdemo.publics.HttpMethods;
import com.hlj.user.retrofitdemo.publics.HttpResult;
import com.hlj.user.retrofitdemo.publics.ProgressSubscriber;
import com.jakewharton.rxbinding.view.RxView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.result_TV)
    TextView resultTV;
    @Bind(R.id.click_me_BN)
    Button button;
//StringConverter
//    private Subscriber<HttpResult<List<MovieEntity.SubjectsEntity>>> subscriber;
    private Subscriber<List<MovieEntity.SubjectsEntity>> subscriber;
    private SubscriberOnNextListener<List<MovieEntity.SubjectsEntity>> subscriberOnNextListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        subscriberOnNextListener = new SubscriberOnNextListener<List<MovieEntity.SubjectsEntity>>() {
            @Override
            public void onNext(List<MovieEntity.SubjectsEntity> subjectsEntities) {
                resultTV.setText(subjectsEntities.toString());
            }
        };

        /*Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        });*/
        List<OrderInfo> orderInfos=new ArrayList<>();
        Observable.from(orderInfos).flatMap(new Func1<OrderInfo,Observable<OrderInfo.ChannelsEntity>>() {
            @Override
            public Observable<OrderInfo.ChannelsEntity> call(OrderInfo orderInfo) {
                return Observable.from(orderInfo.getChannels());
            }
        }).subscribe(new Subscriber<OrderInfo.ChannelsEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(OrderInfo.ChannelsEntity channelsEntity) {

            }
        });

//        RxView.clickE(button);

//        RxView.cl


    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getMovie();

    }

    //进行网络请求
    private void getMovie(){
        /*String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        MovieService movieService = retrofit.create(MovieService.class);


        //--------------------------------没有经过封装的、原生态的Retrofit写网络请求的代码-----------------------------------------
        Call<MovieEntity> call = movieService.getTopMovie(0, 10);
        call.enqueue(new Callback<MovieEntity>() {
            @Override
            public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
                resultTV.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<MovieEntity> call, Throwable t) {
                resultTV.setText(t.getMessage());
            }
        });*/


        //--------------------------------加入RxJava的代码-----------------------------------------
        /*movieService.getTopMovie(0, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieEntity>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        resultTV.setText(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieEntity movieEntity) {
                        resultTV.setText(movieEntity.toString());
                    }
                });*/

        //--------------------------------封装RxJava-----------------------------------------
//        subscriber = new Subscriber<MovieEntity>() {
//            @Override
//            public void onCompleted() {
//                Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                resultTV.setText(e.getMessage());
//            }
//
//            @Override
//            public void onNext(MovieEntity movieEntity) {
//                resultTV.setText(movieEntity.toString());
//            }
//        }
//        HttpMethods.getInstance().getTopMovie(subscriber, 0, 10);

        //--------------------------------相同格式的Http请求如何封装-----------------------------------------
//        subscriber = new Subscriber<HttpResult<List<MovieEntity.SubjectsEntity>>>() {
//            @Override
//            public void onCompleted() {
//                Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(HttpResult<List<MovieEntity.SubjectsEntity>> listHttpResult) {
//                resultTV.setText(listHttpResult.getSubjects().toString());
//            }
//        };
//        HttpMethods.getInstance().getTopMovie(subscriber, 0, 10);

        //-------------------------------相同格式的使用map进行Http请求数据统一进行预处理-----------------------------------------
//        subscriber = new Subscriber<List<MovieEntity.SubjectsEntity>>() {
//            @Override
//            public void onCompleted() {
//                Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(List<MovieEntity.SubjectsEntity> listHttpResult) {
//                resultTV.setText(listHttpResult.toString());
//            }
//        };
//        HttpMethods.getInstance().getTopMovie(subscriber, 0, 10);

        //-------------------------------如何取消一个Http请求-----------------------------------------
        // 思路:如果没有用Service返回的是一个Call,而这个Call对象有一个cancel方法用来取消Http请求,用了RxJava之后返回值
        // 是一个Observable,除了解除订阅,RxJavaCallAdapterFactory这个类可以找到答案

        //-----------------------------一个需要ProgressDialog的Subscriber该有的样子-----------------------------------------

//        HttpMethods.getInstance().getTopMovie(subscriber, 0, 10);

        HttpMethods.getInstance().getTopMovie(new ProgressSubscriber(subscriberOnNextListener,MainActivity.this),0,10);
        //当cancel掉ProgressDialog的时候能够取消订阅也就取消当前Http请求
    }

}
