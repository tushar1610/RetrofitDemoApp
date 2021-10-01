package com.example.android.retrofitdemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rview = findViewById(R.id.rview);
        rview.setLayoutManager(new LinearLayoutManager(this));

        processData();

    }

    public void processData(){

        Call<List<responseModel>> call = apiController.getInstance().getApi().getData();

        call.enqueue(new Callback<List<responseModel>>() {
            @Override
            public void onResponse(Call<List<responseModel>> call, Response<List<responseModel>> response) {
                List<responseModel> data = response.body();
                responseAdapter myAdapter = new responseAdapter(data);
                rview.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<responseModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}