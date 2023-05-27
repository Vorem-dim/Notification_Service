package com.example.pizzaandsushi.Repositoryes;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.pizzaandsushi.MyResponse;
import com.example.pizzaandsushi.PlaceholderAPI;
import com.example.pizzaandsushi.PlaceholserPost;
import com.example.pizzaandsushi.R;
import com.example.pizzaandsushi.RetrofitFactory;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetData {
    private final String URL_API = "https://jsonplaceholder.typicode.com/";

    public void getDataFromApi1() {
        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        PlaceholderAPI placeholderAPI = retrofit.create(PlaceholderAPI.class);
        Call<List> call = placeholderAPI.getPosts();
        call.enqueue(new Callback<List>() {
            @Override
            public void onResponse(Call<List> call, Response<List> response) {
                if (response.isSuccessful()) {
                    List posts = response.body();
                    Log.d("Success", posts.get(3).toString());
                }
                else {
                    Log.d("Hey", "Wow!");
                    return;
                }
            }
            @Override
            public void onFailure(Call<List> call, Throwable t) {
                Log.d("Hey", "Error!");
            }
        });
        Log.d("Hey", "Hello!");
    }

    public void getDataFromApi2() {
        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        PlaceholderAPI placeholderAPI = retrofit.create(PlaceholderAPI.class);
        Call<List> call = placeholderAPI.getComments();
        call.enqueue(new Callback<List>() {
            @Override
            public void onResponse(Call<List> call, Response<List> response) {
                if (response.isSuccessful()) {
                    List posts = response.body();
                    Log.d("Success", posts.get(3).toString());
                }
                else {
                    Log.d("Hey", "Wow!");
                    return;
                }
            }
            @Override
            public void onFailure(Call<List> call, Throwable t) {
                Log.d("Hey", "Error!");
            }
        });
        Log.d("Hey", "Hello!");
    }

    public void setDataApi() throws IOException {
        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        PlaceholderAPI api = retrofit.create(PlaceholderAPI.class);
        PlaceholserPost post = new PlaceholserPost();
        post.setUserID(123);
        post.setId(34);
        post.setBody("Hello, you there");
        post.setTitle("title");
        Call<MyResponse> call = api.request(post);
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if (response.isSuccessful()) {
                    Log.d("Successful", "Send data successful");
                }
                else {
                    Log.d("Hey", "Wow!");
                    return;
                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {

            }
        });
    }
}
