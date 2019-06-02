package com.example.hp.ovias_mine;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentHome extends Fragment implements View.OnClickListener{

    private Button button,button1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        button=(Button)v.findViewById(R.id.button_bike);
        button1=(Button)v.findViewById(R.id.button_scooty);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getActivity().getApplicationContext(),BookActivity.class);
        switch(v.getId()){
            case R.id.button_bike:
                i.putExtra("vehicle","Bike");
                break;
            case R.id.button_scooty:
                i.putExtra("vehicle","Scooty");
                break;

        }
        startActivity(i);


    }
}