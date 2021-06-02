package com.mirea.nawab.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment fragmentOne, fragmentTwo;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
    }

    public void onClick(View view) {
        fragmentManager = getSupportFragmentManager();
        switch (view.getId()) {
            case R.id.button_fragment_two:
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer,
                        fragmentOne).commit();
                break;
            case R.id.button_fragment_one:
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer,
                        fragmentTwo).commit();
                break;
            default:
                break;
        }
    }
}