package com.example.pizzaandsushi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerMenu extends RecyclerView.Adapter<RecyclerMenu.ViewHolder> {
    private final LayoutInflater inflater;
    private final RecyclerMenu.OnClickListener Listener;
    private final List<MenuField> menuField;

    interface OnClickListener {
        void OnClick(MenuField field, int position);
    }

    public RecyclerMenu(Context context, List<MenuField> field, RecyclerMenu.OnClickListener listener) {
        this.menuField = field;
        this.Listener = listener;
        this.inflater = LayoutInflater.from(context);
    }

    public RecyclerMenu.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.menu_cuisine, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerMenu.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MenuField field = menuField.get(position);
        holder.image.setImageResource(field.getImage());
        holder.text.setText(field.getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.OnClick(field, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuField.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView text;
        ViewHolder(View view){
            super(view);
            image = view.findViewById(R.id.MenuImage);
            text = view.findViewById(R.id.MenuText);
        }
    }
}
