package com.klein.firstwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyHolder> {

    Context context1;
    List<String> list1;

    public MyAdapter(Context context, List<String> list) {
        context1 = context;
        list1 = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context1).inflate(R.layout.item, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.textView.setText(list1.get(position));

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public MyHolder(@NonNull View itemview) {
            super(itemview);
            textView = itemview.findViewById(R.id.textView5);
        }
    }
}
