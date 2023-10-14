package com.klein.firstwork;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends Fragment {

    RecyclerView recyclerView;
    List<String> list;
    MyAdapter adapter;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.wechat, container, false);
        recyclerView = view.findViewById(R.id.recyclerview1);
        list = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            list.add("this is No." + i + "聊天框");
        }

        context = getContext();
        adapter = new MyAdapter(context, list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.wechat, container, false);
    }
}