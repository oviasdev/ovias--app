package com.example.hp.ovias_mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class BookViewHolder extends RecyclerView.ViewHolder {
    View mview;

    public BookViewHolder(@NonNull View itemView) {
        super(itemView);
        mview=itemView;
    }

    public void setDetails(Context mctx, String vehicle, String date, String time,String otp, String bill){
        TextView text1=(TextView)mview.findViewById(R.id.vehicle_user_book);
        TextView text2=(TextView)mview.findViewById(R.id.date_user_book);
        TextView text3=(TextView)mview.findViewById(R.id.time_user_book);
        TextView text4=(TextView)mview.findViewById(R.id.otp_user);
        TextView text5=(TextView)mview.findViewById(R.id.payment_bill);


        text1.setText(vehicle);
        text2.setText(date);
        text3.setText(time);
        text4.setText(otp);
        text5.setText(bill);


    }
}
