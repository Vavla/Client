package com.example.itmedbook;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

public class Meddoc {
    String hospital = new String();
    String patient  = new String();
    String diagnos  = new String();
    String doctor   = new String();
    Meddoc(String hospital,String patient, String diagnos, String doctor){
        this.hospital = hospital;
        this.patient  = patient;
        this.diagnos  = diagnos;
        this.doctor   = doctor;
    }

    String getHospital(){
        return this.hospital;
    }
    String getPatient(){
        return this.patient;
    }
    String getDiagnos(){
        return this.diagnos;
    }
    String getDoctor(){
        return this.doctor;
    }
}
