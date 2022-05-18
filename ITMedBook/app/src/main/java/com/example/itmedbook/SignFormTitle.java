package com.example.itmedbook;

import com.example.itmedbook.SignForm;

public class SignFormTitle implements SignForm {
    String TitleSignForm = new String();
    SignFormTitle(String TitleSignForm){
        this.TitleSignForm = TitleSignForm;
    }
    String getTitleSignForm(){return this.TitleSignForm;}
}
