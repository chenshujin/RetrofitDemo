package com.hlj.user.retrofitdemo.interfaces;

import com.hlj.user.retrofitdemo.bean.MovieEntity;
import com.hlj.user.retrofitdemo.publics.HttpResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ${csj} on 16/6/7.
 */
public interface MovieService {
//        @GET("top250")
//    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
//    @GET("top250")
//    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
    @GET("top250")
    Observable<HttpResult<List<MovieEntity.SubjectsEntity>>> getTopMovie(@Query("start") int start, @Query("count") int count);
}
