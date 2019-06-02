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
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class GuardActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase db;
    DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guard);
        recyclerView=findViewById(R.id.recycler_guard);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db=FirebaseDatabase.getInstance();
        dref=db.getReference("booking");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Query query=dref.orderByChild("bill").equalTo("");
        FirebaseRecyclerAdapter<BookingCheck,GuardViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<BookingCheck, GuardViewHolder>(BookingCheck.class,R.layout.row_book_guard,GuardViewHolder.class,query) {
            @Override
            protected void populateViewHolder(GuardViewHolder viewHolder, BookingCheck model, int position) {
                viewHolder.setDetails(getApplicationContext(),model.getUsername(),model.getVehicle(),model.getDate(),model.getTime());

            }

            @Override
            public GuardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                GuardViewHolder viewHolder=super.onCreateViewHolder(parent, viewType);
                viewHolder.setOnClickListener(new GuardViewHolder.GClickListener() {
                    @Override
                    public void onItemClick(View view,  int position) {
                        final int position1= position;
                        if(getItem(position).getStatus().equals("Started")){
                            Toast.makeText(GuardActivity.this, "Trip already Started", Toast.LENGTH_SHORT).show();
                        }else{
                        TextView text1=(TextView)view.findViewById(R.id.username_guard);
                        TextView text2=(TextView)view.findViewById(R.id.vehicle_guard);
                        TextView text3=(TextView)view.findViewById(R.id.date_guard);
                        TextView text4=(TextView)view.findViewById(R.id.time_guard);





                        dref.child(getItem(position).getId()).child("otp").setValue(random(4));

                            LayoutInflater layoutInflater = LayoutInflater.from(GuardActivity.this);
                            View promptView = layoutInflater.inflate(R.layout.inputdialog, null);
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GuardActivity.this);
                            alertDialogBuilder.setView(promptView);

                            final EditText editText = (EditText) promptView.findViewById(R.id.editinput);
                            // setup a dialog window
                            alertDialogBuilder.setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                          if((editText.getText().toString()).equals(getItem(position1).getOtp())){
                                             dref.child(getItem(position1).getId()).child("status").setValue("Started");
                                              Toast.makeText(GuardActivity.this, "Trip Started", Toast.LENGTH_SHORT).show();
                                          }else{
                                              Toast.makeText(GuardActivity.this, "wrong OTP try again", Toast.LENGTH_SHORT).show();
                                          }
                                        }
                                    })
                                    .setNegativeButton("Cancel",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();

                                                }
                                            });

                            // create an alert dialog
                            AlertDialog alert = alertDialogBuilder.create();
                            alert.show();



                      //Toast.makeText(GuardActivity.this, random(4), Toast.LENGTH_SHORT).show();

                    }}
                    @Override
                    public void onItemclick(View view, int position) {
                        if(getItem(position).getStatus().equals("Started")){
                        TextView text1=(TextView)view.findViewById(R.id.username_guard);
                        TextView text2=(TextView)view.findViewById(R.id.vehicle_guard);
                        TextView text3=(TextView)view.findViewById(R.id.date_guard);
                        TextView text4=(TextView)view.findViewById(R.id.time_guard);
                            dref.child(getItem(position).getId()).child("otp").setValue(random(4));
                            LayoutInflater layoutInflater = LayoutInflater.from(GuardActivity.this);
                            View promptView = layoutInflater.inflate(R.layout.inputdialog, null);
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GuardActivity.this);
                            alertDialogBuilder.setView(promptView);
                            final int position1= position;
                            final EditText editText = (EditText) promptView.findViewById(R.id.editinput);
                            // setup a dialog window
                            alertDialogBuilder.setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            if((editText.getText().toString()).equals(getItem(position1).getOtp())){

                                                String date = getItem(position1).getTime();
                                                int bill=0;
                                                String[] arr = date.split ("-");
                                                String[] h = arr[0].split (":");
                                                String[] l = arr[1].split (":");
                                                int a = Integer.parseInt (h[0]);
                                                int b = Integer.parseInt (h[1]);
                                                int c = Integer.parseInt (l[0]);
                                                int d = Integer.parseInt (l[1]);
                                                int minute=(c-a)*60 +d-b;
                                                int modulo = minute%60;
                                                int  quotient = minute/60;
                                                if(modulo==0){
                                                    bill = quotient*40;
                                                }else if(modulo>0){
                                                    bill=(quotient+1)*40;

                                                }

                                                dref.child(getItem(position1).getId()).child("status").setValue("Ended");
                                                dref.child(getItem(position1).getId()).child("bill").setValue(bill);

                                                Toast.makeText(GuardActivity.this, "Trip Ended", Toast.LENGTH_SHORT).show();
                                            }else{
                                                Toast.makeText(GuardActivity.this, "wrong OTP try again", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .setNegativeButton("Cancel",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();

                                                }
                                            });

                            // create an alert dialog
                            AlertDialog alert = alertDialogBuilder.create();
                            alert.show();


                    }else{
                            Toast.makeText(GuardActivity.this, "Trip not started yet", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                return viewHolder;
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    private static String random(int size) {

        StringBuilder generatedToken = new StringBuilder();
        try {
            SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
            // Generate 20 integers 0..20
            for (int i = 0; i < size; i++) {
                generatedToken.append(number.nextInt(9));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedToken.toString();
    }

}
