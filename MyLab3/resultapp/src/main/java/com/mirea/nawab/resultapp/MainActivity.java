package com.mirea.nawab.resultapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private final int REQUEST_CODE = 143;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.text_from);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            String university = data.getStringExtra("name");
            setUniversityTextView(university);
        }
    }

    public void startInfActivityOnClick(View view) {
        Intent intent = new Intent(this, InfAct.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    private void setUniversityTextView(String university) {
        textViewResult.setText(university);
    }
}