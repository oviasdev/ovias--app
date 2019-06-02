package com.example.hp.ovias_mine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ExampleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase db;
    DatabaseReference dref;
    AvailabilityCheck Model;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        recyclerView=findViewById(R.id.recycler_user_avail_);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db=FirebaseDatabase.getInstance();
        dref=db.getReference("transaction");




    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        String email=user.getEmail();
        Query query = dref.orderByChild("username").equalTo(email);
        FirebaseRecyclerAdapter<AvailabilityCheck,NewViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<AvailabilityCheck, NewViewHolder>(AvailabilityCheck.class,R.layout.row_user,NewViewHolder.class,query) {
            @Override
            protected void populateViewHolder(NewViewHolder viewHolder, AvailabilityCheck model, int position) {
                Model= model;
                String s=model.getAvailability();
                String so="";
                if(s.equals("Available")){
                    so="Tap to enter payment details";
                }

                viewHolder.setDetails(getApplicationContext(),model.getVehicle(),model.getDate(),model.getTime(),model.getAvailability(),so);

            }

            @Override
            public NewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                NewViewHolder viewHolder=super.onCreateViewHolder(parent, viewType);
                viewHolder.setOnClickListener1(new NewViewHolder.ClickListener1() {
                    @Override
                    public void onItemClick1(View v, int position) {

                            Toast.makeText(getApplicationContext(),"Lets make payment",Toast.LENGTH_SHORT).show();


                    }
                });
                return viewHolder;
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);


}}

