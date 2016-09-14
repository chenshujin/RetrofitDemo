package com.hlj.user.retrofitdemo.interfaces;

import com.hlj.user.retrofitdemo.ProductInfo;
import com.hlj.user.retrofitdemo.publics.MyHttpResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ${csj} on 16/8/2.
 */
public interface ProductInfoService {
    @GET("product/info")
    Observable<MyHttpResult<ProductInfo.BodyEntity>> getProductInfo(@Query("productid") int productid,@Query("communityid") int communityid );
}
