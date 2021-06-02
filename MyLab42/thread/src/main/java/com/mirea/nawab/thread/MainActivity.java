package com.mirea.nawab.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


        TextView txt1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            txt1 = findViewById(R.id.text1);
            final Runnable runn1 = new Runnable() {
                public void run() {
                    txt1.setText("runn1");
                }
            };
            final Runnable runn2 = new Runnable() {
                public void run() {
                    txt1.setText("runn2");
                }
            };
            final Runnable runn3 = new Runnable() {
                public void run() {
                    txt1.setText("runn3");
                }
            };
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        runOnUiThread(runn1);
                        TimeUnit.SECONDS.sleep(1);
                        txt1.postDelayed(runn3, 2000);
                        txt1.post(runn2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
}