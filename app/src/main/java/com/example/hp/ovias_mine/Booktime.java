package com.example.hp.ovias_mine;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import com.mcsoft.timerangepickerdialog.RangeTimePickerDialog;





public class Booktime extends AppCompatActivity implements RangeTimePickerDialog.ISelectedTime{

    List<AvailabilityCheck> checks;

    //our database reference object
    DatabaseReference databasechecks;
    private String date,time;
    private String vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booktime);
        Intent i =getIntent();
        date=i.getStringExtra("date");
        vehicle=i.getStringExtra("vehicle");




                RangeTimePickerDialog dialog = new RangeTimePickerDialog();
                dialog.newInstance();
                dialog.setRadiusDialog(20); // Set radius of dialog (default is 50)
                dialog.setIs24HourView(true); // Indicates if the format should be 24 hours
                dialog.setColorBackgroundHeader(R.color.colorPrimary); // Set Color of Background header dialog
                dialog.setColorTextButton(R.color.colorPrimaryDark); // Set Text color of button
                FragmentManager fragmentManager = getFragmentManager();
                dialog.show(fragmentManager, "");



    }
    @Override
    public void onSelectedTime(int hourStart, int minuteStart, int hourEnd, int minuteEnd)
    {

        databasechecks = FirebaseDatabase.getInstance().getReference("available");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        String id = databasechecks.push().getKey();



        AvailabilityCheck check = new AvailabilityCheck(id,email,vehicle,date,hourStart+":"+minuteStart+"-"+hourEnd+":"+minuteEnd,"unknown");
        databasechecks.child(id).setValue(check);
        Toast.makeText(this,"Data sent",Toast.LENGTH_SHORT).show();
        }

}

