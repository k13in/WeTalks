package com.klein.wetalks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment2 extends Fragment {

    RecyclerView recyclerView;
    Context context;
    ContactAdapter contactAdapter;
    ContactDAO contactDAO;
    Button btnForAddContact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts, container, false);
        recyclerView = view.findViewById(R.id.recyclerview2);
        btnForAddContact = view.findViewById(R.id.btnForAddContact);

        btnForAddContact.setOnClickListener(v -> {
            // 创建一个新的意图，用于启动添加联系人的活动
            Intent intent = new Intent(getActivity(), AddContactActivity.class);
            startActivity(intent);
        });

        // 创建一个新的ContactDAO对象
        contactDAO = new ContactDAO(getContext());
        context = getContext();
        // 创建一个新的ContactAdapter对象，用于显示所有联系人
        contactAdapter = new ContactAdapter(contactDAO.getAllContacts());

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(contactAdapter);
        
        return view;
    }
}