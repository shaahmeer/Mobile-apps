package com.mirea.nawab.notebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText eNote;
    private EditText eName;
    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eNote = findViewById(R.id.e_note);
        eName = findViewById(R.id.e_name);
        preferences = getPreferences(MODE_PRIVATE);
        if (!preferences.getString(SAVED_TEXT, "Empty").equals("Empty"))
            eName.setText(preferences.getString(SAVED_TEXT, "Empty"));
        eNote.setText(getTextFromFile());
    }

    public void onSaveText(View view) {
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(eName.getText().toString(), Context.MODE_PRIVATE);
            outputStream.write(eNote.getText().toString().getBytes());
            outputStream.close();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(SAVED_TEXT, eName.getText().toString());
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getTextFromFile() {
        String fileName = preferences.getString(SAVED_TEXT, "Empty");
        if (fileName.equals("Empty"))
            return null;
        FileInputStream fin = null;
        try {
            fin = openFileInput(fileName);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            Log.d(LOG_TAG, text);
            return text;
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return null;
    }
}