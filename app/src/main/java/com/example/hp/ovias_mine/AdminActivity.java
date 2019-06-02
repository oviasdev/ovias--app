package com.example.hp.ovias_mine;

import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class AdminActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase db;
    DatabaseReference dref;
    AvailabilityCheck Model;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db=FirebaseDatabase.getInstance();
        dref=db.getReference("available");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Query query = dref.orderByChild("availability").equalTo("unknown");
        FirebaseRecyclerAdapter<AvailabilityCheck,ViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<AvailabilityCheck, ViewHolder>(AvailabilityCheck.class,R.layout.row,ViewHolder.class,query) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, AvailabilityCheck model, int position) {
                viewHolder.setDetails(getApplicationContext(),model.getId(),model.getUsername(),model.getVehicle(),model.getDate(),model.getTime(),model.getAvailability());
            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        TextView text1 = (TextView) view.findViewById(R.id.ide);
                        TextView text2 = (TextView) view.findViewById(R.id.username);
                        TextView text3 = (TextView) view.findViewById(R.id.vehicle);
                        TextView text4 = (TextView) view.findViewById(R.id.date_);
                        TextView text5 = (TextView) view.findViewById(R.id.time_);
                        TextView text6 = (TextView) view.findViewById(R.id.status);
                        String ids = text1.getText().toString();


                            Toast.makeText(getApplicationContext(), "Item clicked at " + position + "   ", Toast.LENGTH_SHORT).show();
                            dref.child(ids).child("availability").setValue("Available");

                    }
                    @Override
                    public void onItemclick(View view, int position) {
                        TextView text1 = (TextView) view.findViewById(R.id.ide);
                        TextView text2 = (TextView) view.findViewById(R.id.username);
                        TextView text3 = (TextView) view.findViewById(R.id.vehicle);
                        TextView text4 = (TextView) view.findViewById(R.id.date_);
                        TextView text5 = (TextView) view.findViewById(R.id.time_);
                        TextView text6 = (TextView) view.findViewById(R.id.status);
                        String ids = text1.getText().toString();


                        Toast.makeText(getApplicationContext(), "Failed ", Toast.LENGTH_SHORT).show();
                        dref.child(ids).child("availability").setValue("Not Available");

                    }
                });
                return viewHolder;

            }
        };


        recyclerView.setAdapter(firebaseRecyclerAdapter);






    }

}