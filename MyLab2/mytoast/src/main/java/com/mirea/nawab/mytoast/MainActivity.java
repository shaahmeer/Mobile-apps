package com.mirea.nawab.mytoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayToast(View view){
        LayoutInflater inflater =  getLayoutInflater();
        View customToastLayout = inflater.inflate(R.layout.custom_toast,(ViewGroup)
        findViewById(R.id.root_layout));
        TextView txtMessage = customToastLayout.findViewById(R.id.txt_message);
        txtMessage.setText("Welcome to toaster");

        Toast mToast = new Toast(getApplicationContext());
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.setView(customToastLayout);
        mToast.show();
    }
}