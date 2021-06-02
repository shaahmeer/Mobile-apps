package com.mirea.nawab.mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int selectedHours;
    int selectedMinutes;
    int selectedYear = Calendar.getInstance().get(Calendar.YEAR);
    int selectedMonth = Calendar.getInstance().get(Calendar.MONTH);
    int selectedDayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTimeSet(View view) {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                selectedHours = hourOfDay;
                selectedMinutes = minute;
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, timeSetListener,
                selectedHours, selectedMinutes, true);
        timePickerDialog.show();
    }

    public void onClickDateSet(View view) {
        DatePickerDialog.OnDateSetListener dateSetListener = (view1, year, month, dayOfMonth) -> {};
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener,
                selectedYear, selectedMonth, selectedDayOfMonth);
        datePickerDialog.show();
    }

    public void onClickProgressSet(View view) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Progress");
        progressDialog.setMessage("You can watch this circle");
        progressDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        progressDialog.show();
    }
}