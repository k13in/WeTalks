package com.klein.wetalks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Fragment fragment1, fragment2, fragment3, fragment4;
    FragmentManager fm;
    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        linearLayout1 = findViewById(R.id.LinearLayout1);
        linearLayout2 = findViewById(R.id.LinearLayout2);
        linearLayout3 = findViewById(R.id.LinearLayout3);
        linearLayout4 = findViewById(R.id.LinearLayout4);

        initial();
        hideFragment(fragment2);
        hideFragment(fragment3);
        hideFragment(fragment4);
        showFragment(fragment1);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);


    }

    private void hideFragment(Fragment fragment) {
        FragmentTransaction ft = fm.beginTransaction()
                .hide(fragment);
        ft.commit();
    }

    public void initial() {
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .add(R.id.content, fragment1)
                .add(R.id.content, fragment2)
                .add(R.id.content, fragment3)
                .add(R.id.content, fragment4);
        ft.commit();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.LinearLayout1) {
            showFragment(fragment1);
            hideFragment(fragment2);
            hideFragment(fragment3);
            hideFragment(fragment4);
        } else if (view.getId() == R.id.LinearLayout2) {
            showFragment(fragment2);
            hideFragment(fragment1);
            hideFragment(fragment3);
            hideFragment(fragment4);
        } else if (view.getId() == R.id.LinearLayout3) {
            showFragment(fragment3);
            hideFragment(fragment2);
            hideFragment(fragment1);
            hideFragment(fragment4);
        } else if (view.getId() == R.id.LinearLayout4) {
            showFragment(fragment4);
            hideFragment(fragment2);
            hideFragment(fragment3);
            hideFragment(fragment1);
        }
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = fm.beginTransaction()
                .show(fragment);
        transaction.commit();
    }
}