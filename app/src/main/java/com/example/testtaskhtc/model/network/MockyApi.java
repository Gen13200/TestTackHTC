package com.example.testtaskhtc.model.network;

import com.example.testtaskhtc.model.network.pojo.CompanyInfo;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface MockyApi {
    @GET("/v2/5ddcd3673400005800eae483")
    Single<CompanyInfo> getMockyApi();

    static MockyApi getInstance(){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://www.mocky.io/")
                .build()
                .create(MockyApi.class);
    }
}
