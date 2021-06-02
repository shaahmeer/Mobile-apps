package com.mirea.nawab.mylab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt2 = (Button)findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                startActivity(Intent.createChooser(myIntent,"Share it"));
            }
        });
        }

    public void open (View view) {
    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mirea.ru"));
    startActivity(browserIntent);
    }
}

