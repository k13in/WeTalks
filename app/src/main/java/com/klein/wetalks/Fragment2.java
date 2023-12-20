package com.klein.wetalks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment2 extends Fragment {

    RecyclerView recyclerView;
    Context context;
    ContactAdapter contactAdapter;
    ContactDAO contactDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts, container, false);
        recyclerView = view.findViewById(R.id.recyclerview2);

        contactDAO = new ContactDAO(getContext());

        context = getContext();
        contactAdapter = new ContactAdapter(contactDAO.getAllContacts());

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(contactAdapter);

        return view;
    }
}