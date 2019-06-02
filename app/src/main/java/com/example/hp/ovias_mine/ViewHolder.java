package com.example.hp.ovias_mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    View mview;
    Button button,button1;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mview=itemView;


        button=mview.findViewById(R.id.button_confirm);
        button1=mview.findViewById(R.id.button_decline);
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
    private ViewHolder.ClickListener mClickListener;

    //Interface to send callbacks...
    public interface ClickListener{
        public void onItemClick(View view, int position);
        public void onItemclick(View view,int position);


    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }


    public void setDetails(Context mctx,String id, String username,String vehicle,String date,String time, String status){

        TextView text1=(TextView)mview.findViewById(R.id.ide);
        TextView text2=(TextView)mview.findViewById(R.id.username);
        TextView text3=(TextView)mview.findViewById(R.id.vehicle);
        TextView text4=(TextView)mview.findViewById(R.id.date_);
        TextView text5=(TextView)mview.findViewById(R.id.time_);
        TextView text6=(TextView)mview.findViewById(R.id.status);


        text1.setText(id);
        text2.setText(username);
        text3.setText(vehicle);
        text4.setText(date);
        text5.setText(time);
        text6.setText(status);


    }

}
