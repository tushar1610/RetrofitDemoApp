package com.example.android.retrofitdemoapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface apiSet {

    @GET("posts")
    Call<List<responseModel>> getData();

}
