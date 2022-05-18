package com.example.itmedbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class SignFormActivity extends AppCompatActivity {
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_form);

        RecyclerView recyclerViewSign  = findViewById(R.id.recyclerViewSign);
        ArrayList<SignForm> signforms = new ArrayList<>();
        signforms.add(new SignFormTitle("Основная информация"));
        signforms.add(new SignFormMain("ФИО"));
        signforms.add(new SignFormDate("Дата рождения"));
        signforms.add(new SignFormMain("Регион проживания"));
        signforms.add(new SignFormMain("Населенный пункт"));
        signforms.add(new SignFormMain("Адрес"));
        signforms.add(new SignFormTitle("Медицинская информация"));
        signforms.add(new SignFormMain("Номер СНИЛС"));
        signforms.add(new SignFormMain("Полис ОМС"));
        signforms.add(new SignFormSwitch("Вы врач?"));
        signforms.add(new SignFormTitle("Контактные данные"));
        signforms.add(new SignFormMain("Номер телефона"));
        signforms.add(new SignFormMain("Электронная почта"));


        layoutManager = new LinearLayoutManager(this);
        recyclerViewSign.setLayoutManager(layoutManager);

        SignFormAdapter adapter = new SignFormAdapter(this, signforms);
        recyclerViewSign.setAdapter(adapter);

        ScrollView scrollView = new ScrollView(this);





    }
}