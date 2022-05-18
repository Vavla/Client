package com.example.itmedbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SignActivity extends AppCompatActivity implements TransferFrag{
    public  String login;
    public  String password;
    public void onData(boolean IsMainActiv,String log,String pass){
        if(!IsMainActiv) {
            login = log;
            password = pass;
            Log.d("AAA","RRRR");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        LogFragment logFragment = new LogFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.loginFrame,logFragment).commit();

//        Button btnSignForm = findViewById(R.id.btnSignForm);
//        btnSignForm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SignActivity.this, SignFormActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}