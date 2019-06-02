package com.example.hp.ovias_mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class FragmentDashboard extends Fragment implements View.OnClickListener {

    private EditText inputEmail, inputPassword;
    private Button btnLogin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard, null);
        inputEmail = (EditText) v.findViewById(R.id.admin_user);
        inputPassword = (EditText) v.findViewById(R.id.admin_password);

        btnLogin = (Button) v.findViewById(R.id.btn_login_admin);

        btnLogin.setOnClickListener(this);

        return v;


    }

    @Override
    public void onClick(View v) {
        String email = inputEmail.getText().toString();
        final String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getActivity().getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity().getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(inputEmail.getText().toString().equals("devesh")){
            if(inputPassword.getText().toString().equals("1212")){
                Intent intent = new Intent(getActivity().getApplicationContext(),AdminMain.class );
                startActivity(intent);


            }else{
                Toast.makeText(getActivity().getApplicationContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
            }
        }else if(inputEmail.getText().toString().equals("guard")){
            if(inputPassword.getText().toString().equals("1212")){
                Intent intent = new Intent(getActivity().getApplicationContext(),GuardActivity.class );
                startActivity(intent);


            }else{
                Toast.makeText(getActivity().getApplicationContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
            }

    }
}}
