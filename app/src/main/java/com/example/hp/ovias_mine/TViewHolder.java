package com.example.hp.ovias_mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TViewHolder extends RecyclerView.ViewHolder{
    View mview;
    Button button,button1;
    TextView text1,text2,text3,text4,text5,text6;
    public TViewHolder(@NonNull View itemView) {
        super(itemView);
        mview=itemView;


        button=mview.findViewById(R.id.button_confirm_trans);
        button1=mview.findViewById(R.id.button_decline_trans);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onTransClick(mview, getAdapterPosition());

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onTransclick(mview,getAdapterPosition());
            }
        });

    }
    private TViewHolder.TClickListener mClickListener;
   public interface TClickListener{
        public void onTransClick(View v, int position);
       public void onTransclick(View v, int position);
   }
   public void TransClickListener(TViewHolder.TClickListener clickListener){
       mClickListener=clickListener;

   }


    public void setDetails(Context mctx, String id, String username, String vehicle, String date, String time, String transactionid){
        TextView text1=(TextView)mview.findViewById(R.id.ide_trans);
        TextView text2=(TextView)mview.findViewById(R.id.username_trans);
        TextView text3=(TextView)mview.findViewById(R.id.vehicle_trans);
        TextView text4=(TextView)mview.findViewById(R.id.date_trans);
        TextView text5=(TextView)mview.findViewById(R.id.time_trans);
        TextView text6=(TextView)mview.findViewById(R.id.status_trans);

        text1.setText(id);
        text2.setText(username);
        text3.setText(vehicle);
        text4.setText(date);
        text5.setText(time);
        text6.setText(transactionid);


    }

}



