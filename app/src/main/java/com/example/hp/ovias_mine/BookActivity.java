package com.example.hp.ovias_mine;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import com.borax12.materialdaterangepicker.time.TimePickerDialog;
import com.mcsoft.timerangepickerdialog.RangeTimePickerDialog;

import java.util.Calendar;

public class BookActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
     private String vehicle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Intent i =getIntent();
        vehicle=i.getStringExtra("vehicle");



               Calendar now = Calendar.getInstance();
               DatePickerDialog dpd = DatePickerDialog.newInstance(
                       BookActivity.this,
                       now.get(Calendar.YEAR),
                       now.get(Calendar.MONTH),
                       now.get(Calendar.DAY_OF_MONTH)
               );
               dpd.show(getFragmentManager(), "Datepickerdialog");
           }



    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth,int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        Intent a = new Intent(this,Booktime.class);
        a.putExtra("date",dayOfMonth+"/"+monthOfYear+"/"+year+"-"+dayOfMonthEnd+"/"+monthOfYearEnd+"/"+yearEnd);
        a.putExtra("vehicle",vehicle);
        startActivity(a);
        finish();

    }


}
