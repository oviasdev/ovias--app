package com.example.hp.ovias_mine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FragmentNotification extends Fragment {

    RecyclerView recyclerView;
    FirebaseDatabase db;
    DatabaseReference dref,tref;
    AvailabilityCheck Model;




    private String m_Text = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_notifications,null);


        recyclerView=v.findViewById(R.id.recycler_user_avail);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        db=FirebaseDatabase.getInstance();
        dref=db.getReference("available");



        return v;




}

    @Override
    public void onStart() {
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

                viewHolder.setDetails(getActivity().getApplicationContext(),model.getVehicle(),model.getDate(),model.getTime(),model.getAvailability(),so);

            }

            @Override
            public NewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                NewViewHolder viewHolder=super.onCreateViewHolder(parent, viewType);
                viewHolder.setOnClickListener1(new NewViewHolder.ClickListener1() {
                    @Override
                    public void onItemClick1(View v, int position) {
                        final TextView text7=(TextView)v.findViewById(R.id.vehicle_user_avail);
                        final TextView text8=(TextView)v.findViewById(R.id.date_user_avail);
                        final TextView  text9=(TextView)v.findViewById(R.id.time_user_avail);
                        final TextView text10=(TextView)v.findViewById(R.id.status_user_avail);
                        final TextView text11=(TextView)v.findViewById(R.id.payment);
                        String s = text10.getText().toString();
                        final String t =getItem(position).getId();

                        if(s.equals("Available")){

                       //Toast.makeText(getActivity().getApplicationContext(),"Lets make payment",Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Paytm TransactionId");
// I'm using fragment here so I'm using getView() to provide ViewGroup
// but you can provide here any other instance of ViewGroup from your Fragment / Activity
                        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.text_inpu_password, (ViewGroup) getView(), false);
// Set up the input
                        final EditText input = (EditText) viewInflated.findViewById(R.id.input);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                        builder.setView(viewInflated);

// Set up the buttons
                        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                m_Text = input.getText().toString();
                                tref = FirebaseDatabase.getInstance().getReference("transaction");
                                 String id = tref.push().getKey();
                                TransactionCheck transactionCheck=new TransactionCheck(id,FirebaseAuth.getInstance().getCurrentUser().getEmail(),text7.getText().toString(),text8.getText().toString(),text9.getText().toString(),m_Text);
                                tref.child(id).setValue(transactionCheck);

                                dref.child(t).removeValue();

                                Toast.makeText(getActivity().getApplicationContext(),"Payment done.Stay tuned for Confirmation",Toast.LENGTH_LONG).show();

                            }
                        });
                        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        builder.show();



                        }

                    }
                });
                return viewHolder;
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);


    }}














