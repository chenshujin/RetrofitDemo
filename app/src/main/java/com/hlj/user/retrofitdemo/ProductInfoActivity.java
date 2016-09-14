package com.hlj.user.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hlj.user.retrofitdemo.publics.HttpMethods;
import com.hlj.user.retrofitdemo.publics.MyHttpResult;

import rx.Subscriber;

public class ProductInfoActivity extends AppCompatActivity {

    public static final String TAG = "ProductInfoActivity";
    private Subscriber<MyHttpResult<ProductInfo.BodyEntity>> productInfoSubscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        getProductInfo();
    }

    private void getProductInfo() {
        productInfoSubscriber = new Subscriber<MyHttpResult<ProductInfo.BodyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"error"+e.toString());
            }

            @Override
            public void onNext(MyHttpResult<ProductInfo.BodyEntity> productInfo) {
                Log.d(TAG, "response:" + productInfo.toString());
            }
        };

        HttpMethods.getInstance().getProductInfo(productInfoSubscriber,17789,330);
    }
        /*Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://test.dev.honglingjinclub.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ProductInfoService productInfoService = retrofit.create(ProductInfoService.class);
        productInfoService.getProductInfo(17789,330)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProductInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,"error"+e.toString());
                    }

                    @Override
                    public void onNext(ProductInfo productInfo) {
                        Log.d(TAG,"response:"+productInfo.toString());
                    }
                });
    }*/
}
