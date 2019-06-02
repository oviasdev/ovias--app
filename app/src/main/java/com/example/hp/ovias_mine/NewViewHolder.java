package com.example.hp.ovias_mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NewViewHolder extends RecyclerView.ViewHolder {

    View mview;

    public NewViewHolder(@NonNull View itemView) {
        super(itemView);
        this.mview = itemView;


        mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mclicklistener.onItemClick1(v,getAdapterPosition());

            }
        });
    }
    private NewViewHolder.ClickListener1 mclicklistener;

    public interface ClickListener1{
        public void onItemClick1(View v,int position);
    }
    public void setOnClickListener1(NewViewHolder.ClickListener1 clicklistener){
        mclicklistener=clicklistener;
    }
    public void setDetails(Context mctx, String vehicle, String date, String time, String status,String s){
       TextView text7=(TextView)mview.findViewById(R.id.vehicle_user_avail);
        TextView text8=(TextView)mview.findViewById(R.id.date_user_avail);
        TextView  text9=(TextView)mview.findViewById(R.id.time_user_avail);
        TextView text10=(TextView)mview.findViewById(R.id.status_user_avail);
        TextView text11=(TextView)mview.findViewById(R.id.payment);

        text7.setText(vehicle);
        text8.setText(date);
        text9.setText(time);
        text10.setText(status);
        text11.setText(s);
    }



}
