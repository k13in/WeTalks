package com.klein.wetalks;

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

public class Fragment1 extends Fragment {

    RecyclerView recyclerView;
    Context context;
    MessageAdapter messageAdapter;
    List<Message> messages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.wetalks, container, false);
        recyclerView = view.findViewById(R.id.recyclerview1);

        messages = new ArrayList<>();
        messages.add(new Message("John", "Hello, how are you?", "10:00 AM"));
        messages.add(new Message("Alice", "I'm good, thanks!", "10:05 AM"));

        messageAdapter = new MessageAdapter(messages);

        context = getContext();
        messageAdapter = new MessageAdapter(messages);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(messageAdapter);

        return view;
    }
}