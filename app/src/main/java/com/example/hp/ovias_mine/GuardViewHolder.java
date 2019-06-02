package com.example.hp.ovias_mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuardViewHolder extends RecyclerView.ViewHolder {
   View mview;
    Button button,button1;
    public GuardViewHolder(@NonNull View itemView) {
        super(itemView);
        mview=itemView;
        button=mview.findViewById(R.id.button_gc);
        button1=mview.findViewById(R.id.button_gd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(mview,getAdapterPosition());
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemclick(mview,getAdapterPosition());
            }
        });
    }
    private GuardViewHolder.GClickListener mClickListener;

    //Interface to send callbacks...
    public interface GClickListener{
        public void onItemClick(View view, int position);
        public void onItemclick(View view,int position);


    }

    public void setOnClickListener(GuardViewHolder.GClickListener clickListener){
        mClickListener = clickListener;
    }


    public void setDetails(Context mctx,String username, String vehicle, String date, String time){

        TextView text1=(TextView)mview.findViewById(R.id.username_guard);
        TextView text2=(TextView)mview.findViewById(R.id.vehicle_guard);
        TextView text3=(TextView)mview.findViewById(R.id.date_guard);
        TextView text4=(TextView)mview.findViewById(R.id.time_guard);



        text1.setText(username);
        text2.setText(vehicle);
        text3.setText(date);
        text4.setText(time);

    }

}
