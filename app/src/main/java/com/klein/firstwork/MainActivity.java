package com.klein.firstwork;

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

        fragment1 = new BlankFragment();
        fragment2 = new BlankFragment1();
        fragment3 = new BlankFragment2();
        fragment4 = new BlankFragment3();

        linearLayout1 = findViewById(R.id.LinearLayout1);
        linearLayout2 = findViewById(R.id.LinearLayout2);
        linearLayout3 = findViewById(R.id.LinearLayout3);
        linearLayout4 = findViewById(R.id.LinearLayout4);

        initial();
        fragmenthide(fragment2);
        fragmenthide(fragment3);
        fragmenthide(fragment4);
        fragmentshow(fragment1);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);


    }

    private void fragmenthide(Fragment fragment) {
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
            fragmentshow(fragment1);
            fragmenthide(fragment2);
            fragmenthide(fragment3);
            fragmenthide(fragment4);
        } else if (view.getId() == R.id.LinearLayout2) {
            fragmentshow(fragment2);
            fragmenthide(fragment1);
            fragmenthide(fragment3);
            fragmenthide(fragment4);
        } else if (view.getId() == R.id.LinearLayout3) {
            fragmentshow(fragment3);
            fragmenthide(fragment2);
            fragmenthide(fragment1);
            fragmenthide(fragment4);
        } else if (view.getId() == R.id.LinearLayout4) {
            fragmentshow(fragment4);
            fragmenthide(fragment2);
            fragmenthide(fragment3);
            fragmenthide(fragment1);
        }

    }

    private void fragmentshow(Fragment fragment) {
        FragmentTransaction transaction = fm.beginTransaction()
                .show(fragment);
        transaction.commit();
    }
}