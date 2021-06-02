package com.mirea.nawab.systemintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view) {   // method for button//
        switch (view.getId()){   // using switch case
            case R.id.bt1:   //calling button 1//
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")); // opening webpage //
                startActivity(i1);// start intent activity//
                break;

            case R.id.bt2:
                Intent i2 = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:"));
                startActivity(i2);


                break;



            case R.id.bt3:
                Intent i3 = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:55.7558° N, 37.6173° E"));
                startActivity(i3);


                break;
        }
    }
}