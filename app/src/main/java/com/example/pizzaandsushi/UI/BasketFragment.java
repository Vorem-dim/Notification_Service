package com.example.pizzaandsushi.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.pizzaandsushi.MyResponse;
import com.example.pizzaandsushi.PlaceholderAPI;
import com.example.pizzaandsushi.PlaceholserPost;
import com.example.pizzaandsushi.R;
import com.example.pizzaandsushi.RetrofitFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BasketFragment extends Fragment {

    private final String URL_API = "https://jsonplaceholder.typicode.com/";

    public BasketFragment() {
        super(R.layout.fragment_basket);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            setDataApi();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getDataFromApi(view);

        ImageButton button1 = view.findViewById(R.id.Menu_button);
        button1.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_BasketToMenu);
        });

        ImageButton button2 = view.findViewById(R.id.Profile_icon_button);
        button2.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_BasketToProfile);
        });
    }

    private void getDataFromApi(View view) {
        Retrofit retrofit = RetrofitFactory.getRetrofit(URL_API);
        PlaceholderAPI placeholderAPI = retrofit.create(PlaceholderAPI.class);
        Call<List> call1 = placeholderAPI.getPosts();
        Call<List> call2 = placeholderAPI.getComments();
        call1.enqueue(new Callback<List>() {
            @Override
            public void onResponse(Call<List> call, Response<List> response) {
                if (response.isSuccessful()) {
                    List posts = response.body();
                    Log.d("Success", posts.get(3).toString());
                    TextView text = view.findViewById(R.id.textView);
                    text.setText(posts.get(3).toString());
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
        call2.enqueue(new Callback<List>() {
            @Override
            public void onResponse(Call<List> call, Response<List> response) {
                if (response.isSuccessful()) {
                    List comments = response.body();
                    Log.d("Success", comments.get(3).toString());
                    TextView text = view.findViewById(R.id.textView1);
                    text.setText(comments.get(3).toString());
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

    private void setDataApi() throws IOException {
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