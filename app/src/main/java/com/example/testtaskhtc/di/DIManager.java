package com.example.testtaskhtc.di;

import com.example.testtaskhtc.model.network.MockyApi;
import com.example.testtaskhtc.model.network.pojo.CompanyInfo;

import io.reactivex.Single;

public class DIManager {

    private static DIManager instance;

    private MockyApi mockyApi = MockyApi.getInstance();

    private DIManager(){

    }

    public static DIManager getInstance(){
        if(instance==null){
            instance = new DIManager();
        }
        return instance;
    }

    public MockyApi getMockyApi(){
        return mockyApi;
    }




}
