package com.example.itmedbook;

public class SignFormDate implements SignForm{
    String textInfoDate = new String();
    SignFormDate(String textInfoDate){
        this.textInfoDate = textInfoDate;
    }
    String getTextInfoDate(){
        return this.textInfoDate;
    }
}
