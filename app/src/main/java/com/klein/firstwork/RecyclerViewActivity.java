//package com.klein.firstwork;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Context;
//import android.os.Bundle;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RecyclerViewActivity extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    List<String> list;
//    MyAdapter adapter;
//    Context context;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.recycler_view);
//
//        recyclerView = findViewById(R.id.recyclerview);
//
//        list = new ArrayList<>();
//        for (int i = 0; i < 9; i++) {
//            list.add(String.valueOf(i));
//        }
//
//        context = this;
//
//        adapter = new MyAdapter(this, list);
//        recyclerView.setAdapter(adapter);
//
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(RecyclerView.VERTICAL);
//        recyclerView.setLayoutManager(manager);
//    }
//}