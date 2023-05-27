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
import com.example.pizzaandsushi.Repositoryes.GetData;
import com.example.pizzaandsushi.RetrofitFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BasketFragment extends Fragment {

    public BasketFragment() {
        super(R.layout.fragment_basket);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView text1 = view.findViewById(R.id.textView), text2 = view.findViewById(R.id.textView1);

        GetData data = new GetData();
        try {
            data.setDataApi(getContext());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        data.getDataFromApi1(getContext());
        data.getDataFromApi2(getContext());

        ImageButton button1 = view.findViewById(R.id.Menu_button);
        button1.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_BasketToMenu);
        });

        ImageButton button2 = view.findViewById(R.id.Profile_icon_button);
        button2.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_BasketToProfile);
        });
    }
}