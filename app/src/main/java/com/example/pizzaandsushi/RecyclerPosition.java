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

public class RecyclerPosition extends RecyclerView.Adapter<RecyclerPosition.ViewHolder> {
    private final LayoutInflater inflater;
    private final RecyclerPosition.OnClickListener Listener;
    private final List<PositionField> positionField;

    interface OnClickListener {
        void OnClick(PositionField field, int position);
    }

    public RecyclerPosition(Context context, List<PositionField> field, RecyclerPosition.OnClickListener listener) {
        this.positionField = field;
        this.Listener = listener;
        this.inflater = LayoutInflater.from(context);
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
