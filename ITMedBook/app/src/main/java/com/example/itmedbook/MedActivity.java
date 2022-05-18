package com.example.itmedbook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med);
        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.MedFrame,fragment).commit();


        ArrayList<Meddoc> meddocs = new ArrayList<>();

        RecyclerView RecyclerMed  = findViewById(R.id.RecyclerMed);

        MedListAdapter.OnStateClickListener stateClickListener = new MedListAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(Meddoc state, int position) {

                Toast.makeText(getApplicationContext(), "Был выбран пункт " + state.getDoctor(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        // создаем адаптер
        MedListAdapter adapter = new MedListAdapter(this, meddocs, stateClickListener);
        RecyclerMed.setAdapter(adapter);

        meddocs.add(new Meddoc("#12","Евгения","ОРВИ","В.В.А."));
        meddocs.add(new Meddoc("#1","Елена","Диабет","С.С.С"));
        meddocs.add(new Meddoc("#3","Владимир","Ковид","А.А.У"));
        meddocs.add(new Meddoc("#3","Владимир","Ковид","А.А.У"));



    }




}

