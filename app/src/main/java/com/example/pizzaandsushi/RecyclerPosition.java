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

import com.example.pizzaandsushi.Model.PositionField;

import java.util.ArrayList;
import java.util.List;

public class RecyclerPosition extends RecyclerView.Adapter<RecyclerPosition.ViewHolder> {
    private final LayoutInflater inflater;
    private final RecyclerPosition.OnClickListener Listener;
    private List<PositionField> positionField;
    private int index;

    public interface OnClickListener {
        void OnClick(PositionField field, int position);
    }

    public RecyclerPosition(Context context, RecyclerPosition.OnClickListener listener) {
        this.positionField = new ArrayList<>();
        this.Listener = listener;
        this.inflater = LayoutInflater.from(context);
        this.index = 0;
    }

    public RecyclerPosition.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.menu_position, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerPosition.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        PositionField field = positionField.get(position);
        holder.image.setImageResource(field.getImage());
        holder.text.setText(field.getText());
        holder.title.setText(field.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.OnClick(field, position);
            }
        });
    }

    public void ChangeIndex(int position) {
        this.index = position;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void update(ArrayList<ArrayList<PositionField>> position) {
        this.positionField.clear();
        this.positionField = position.get(index);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return positionField.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView text;
        final TextView title;
        ViewHolder(View view){
            super(view);
            image = view.findViewById(R.id.positionImage);
            text = view.findViewById(R.id.positionText);
            title = view.findViewById(R.id.positionTitle);
        }
    }
}
