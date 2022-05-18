package com.example.itmedbook;


import android.widget.Switch;

public class SignFormSwitch implements SignForm{
    String questionSign = new String();
    SignFormSwitch(String questionSign){
        this.questionSign = questionSign;
    }

    public String getQuestionSign() {
        return this.questionSign;

    }
}
