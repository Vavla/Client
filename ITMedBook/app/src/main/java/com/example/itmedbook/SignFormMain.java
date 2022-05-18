package com.example.itmedbook;

public class SignFormMain implements SignForm {
    String textInfo = new String();
    String PersonData = new String();

    SignFormMain(String textInfo){
        this.textInfo = textInfo;

    }
    String getTextInfo(){return this.textInfo;}

}

