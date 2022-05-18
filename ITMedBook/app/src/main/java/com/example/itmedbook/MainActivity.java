package com.example.itmedbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.loader.content.AsyncTaskLoader;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

class SignFormat {
    public int id;
    public String fullName;
    public String login;
    public String password;
}
interface LogService{
    @GET("user/logup")
    Call<com.example.itmedbook.SignFormat> getUser(String login, String password);
}

public class MainActivity extends AppCompatActivity implements TransferFrag{
    SignFormat s = new SignFormat();
    public void onData(boolean IsMainActiv,String log,String pass){
        if(IsMainActiv){
        s.login = log;
        s.password = pass;

    } }
    private Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.210:8080")
            .addConverterFactory(GsonConverterFactory.create()).build();
    public class RequestToServer extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... strings){
            com.example.itmedbook.LogService logService = retrofit.create(com.example.itmedbook.LogService.class);
//            if(login != null ){
//                Log.d("Mylogs","login went");
//            }
            Call<com.example.itmedbook.SignFormat> call = logService.getUser(s.login,s.password);
            try{
                Response<com.example.itmedbook.SignFormat> response = call.execute();
                com.example.itmedbook.SignFormat log = response.body();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("myLogs", String.valueOf(log));
                    }});
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(s.login != null && s.password != null) {
            Log.d("AAA", "99999");
            new com.example.itmedbook.MainActivity.RequestToServer().execute("");

        }
        LogFragment fragment = new LogFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.loginFormWrap, fragment).commit();
        findViewById(R.id.Textlogin);
        TextView recoverTextView = findViewById(R.id.recoverText);
//        Button btnEnter  = findViewById(R.id.btnEnter);
//
//        btnEnter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Bundle bundle = new Bundle();
////                bundle.putString("edttext", "1");
////                LogFragment frag = new LogFragment();
////                frag.setArguments(bundle);
//                Intent intent = new Intent(MainActivity.this, StartActivity.class);
//                startActivity(intent);
//
//            }
//        });



//        recoverTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }
    public void LogUp(){
        Log.d("myLogs", String.valueOf("Login" + s.login + "Pass"+s.password));
    }

}