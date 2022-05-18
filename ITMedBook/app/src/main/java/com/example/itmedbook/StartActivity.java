package com.example.itmedbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.view.MotionEvent;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;

public class StartActivity extends AppCompatActivity  {


//    static class MyCanvas extends ConstraintLayout {
//        public Paint paint;
//        MyCanvas(Context ctx) {
//            super(ctx);
//
//        }
//        @Override
//        protected void onDraw(Canvas canvas){
//            super.onDraw(canvas);
//            int color = getResources().getColor(R.color.black);
//            paint.setColor(color);
//            paint.setStrokeWidth(30);
//            canvas.drawLine(35,35,39,35,paint);
//            canvas.drawLine(35,37,39,37,paint);
//            canvas.drawLine(35,39,39,39,paint);
//
//        }
//
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.mainFrame,mainFragment).commit();

        Button btnCall = findViewById(R.id.btnCall);

        btnCall.setOnClickListener(view -> {
            Intent intent = new Intent(StartActivity.this, CallDocActivity.class);
            startActivity(intent);
        });


        Button btnConnect = findViewById(R.id.btnConnect);
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(StartActivity.this,ConnectActivity.class);
                startActivity(intent2);

            }
        });

        Button btnRes = findViewById(R.id.btnResearch);

        btnRes.setOnClickListener(view -> {
            Intent intent = new Intent(StartActivity.this, ResearchActivity.class);
            startActivity(intent);
        });

        Button btnMed = findViewById(R.id.btnMedb);

        btnMed.setOnClickListener(view -> {
            Intent intent = new Intent(StartActivity.this, MedActivity.class);
            startActivity(intent);
        });



    }
}



