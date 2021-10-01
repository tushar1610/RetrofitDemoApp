package com.example.android.retrofitdemoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class responseAdapter extends RecyclerView.Adapter<responseAdapter.myViewHolder> {

    List<responseModel> data;

    public responseAdapter(List<responseModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        responseModel model = data.get(position);
        holder.userId.setText(String.valueOf(model.getUserId()));
        holder.id.setText(String.valueOf(model.getId()));
        holder.title.setText(model.getTitle());
        holder.body.setText(model.getBody());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView userId, id, title, body;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
