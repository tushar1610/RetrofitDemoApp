package com.example.android.retrofitdemoapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiController {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static apiController clientObject;
    private static Retrofit retrofit;

    apiController(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized apiController getInstance(){
        if(clientObject == null){
            clientObject = new apiController();
        }
        return clientObject;
    }

    apiSet getApi(){
        return retrofit.create(apiSet.class);
    }

}
