package com.example.hp.ovias_mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class AdminTransaction extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase db;
    DatabaseReference dref,tref;
    TransactionCheck Model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_transaction);

        recyclerView=findViewById(R.id.recycler_transaction_admin);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db=FirebaseDatabase.getInstance();
        dref=db.getReference("transaction");

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<TransactionCheck,TViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<TransactionCheck, TViewHolder>(TransactionCheck.class,R.layout.row_book_admin,TViewHolder.class,dref) {
            @Override
            protected void populateViewHolder(TViewHolder viewHolder, TransactionCheck model, int position) {
                Model= model;
                viewHolder.setDetails(getApplicationContext(),model.getId(),model.getUsername(),model.getVehicle(),model.getDate(),model.getTime(),model.getTransactionId());
            }

            @Override
            public TViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                viewHolder.TransClickListener(new TViewHolder.TClickListener() {
                    @Override
                    public void onTransClick(View v, int position) {
                        TextView text1=(TextView)v.findViewById(R.id.ide_trans);
                        TextView text2=(TextView)v.findViewById(R.id.username_trans);
                        TextView text3=(TextView)v.findViewById(R.id.vehicle_trans);
                        TextView text4=(TextView)v.findViewById(R.id.date_trans);
                        TextView text5=(TextView)v.findViewById(R.id.time_trans);
                        TextView text6=(TextView)v.findViewById(R.id.status_trans);

                          //  Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
                            tref=db.getReference("booking");
                            String id = tref.push().getKey();
                            BookingCheck check=new BookingCheck(id,text2.getText().toString(),text3.getText().toString(),text4.getText().toString(),text5.getText().toString(),"","","");
                            tref.child(id).setValue(check);
                            dref.child(getItem(position).getId()).removeValue();
                        }

                    @Override
                    public void onTransclick(View v, int position) {
                        TextView text1=(TextView)v.findViewById(R.id.ide_trans);
                        TextView text2=(TextView)v.findViewById(R.id.username_trans);
                        TextView text3=(TextView)v.findViewById(R.id.vehicle_trans);
                        TextView text4=(TextView)v.findViewById(R.id.date_trans);
                        TextView text5=(TextView)v.findViewById(R.id.time_trans);
                        TextView text6=(TextView)v.findViewById(R.id.status_trans);
                        dref.child(getItem(position).getId()).removeValue();


                        Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();


                    }
                });
                return viewHolder;
            }
        };


        recyclerView.setAdapter(firebaseRecyclerAdapter);






    }

}
