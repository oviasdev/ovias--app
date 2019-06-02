package com.example.hp.ovias_mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private TextView text1,text2,text3;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(TextView)findViewById(R.id.userName);
        text2=(TextView)findViewById(R.id.userEmail);
        text3=(TextView)findViewById(R.id.userUid);
        btn=(Button)findViewById(R.id.getUserData);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user!=null){
                String name = user.getDisplayName();
                String email = user.getEmail();
                String uid = user.getUid();
                text1.setText(name);
                text2.setText(email);
                text3.setText(uid);
            }else{
                    text1.setText("no user found");
                }

            }
        });

    }


}
