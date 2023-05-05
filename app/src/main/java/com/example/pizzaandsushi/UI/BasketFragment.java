package com.example.pizzaandsushi.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.pizzaandsushi.BlurWorker;
import com.example.pizzaandsushi.R;
import com.example.pizzaandsushi.RecyclerPosition;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BasketFragment extends Fragment {
    private WorkManager workManager;
    private RecyclerPosition adapter;

    public BasketFragment() {
        super(R.layout.fragment_basket);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Callable<Integer> callableTask = () -> {
            return R.mipmap.akarui_foreground;
        };

        final ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future;
        future = service.submit(callableTask);

        ImageView image = view.findViewById(R.id.imageView);
        try {
            image.setImageResource(future.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();

        workManager = WorkManager.getInstance();
        workManager.enqueue(new OneTimeWorkRequest.Builder(BlurWorker.class).build());

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