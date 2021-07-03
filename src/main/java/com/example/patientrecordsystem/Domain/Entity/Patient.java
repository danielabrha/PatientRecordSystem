package com.example.patientrecordsystem.Domain.Entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity(name = "Patients")
public class Patient extends Person {

    //Property
    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;


    @Column(name = "cardRecordNumber")
    private int cardRecordNumber;

    // relations
//    @JsonIgnoreProperties("patient")
  //  @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Visit> visitList;

    public Patient(String fName, String lName, String mName, String gender, String email, String phoneNumber,
                   String address, String dateOfBirth, int patientId,
                   int cardRecordNumber, List<Visit> visitList) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.patientId = patientId;
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public Patient(int patientId, int cardRecordNumber, List<Visit> visitList) {
        this.patientId = patientId;
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public Patient(String fName, String lName, String mName, String gender, String email,
                   String phoneNumber, String address, String dateOfBirth,
                   int cardRecordNumber, List<Visit> visitList) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public Patient(int cardRecordNumber, List<Visit> visitList) {
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public Patient(String fName, String lName, String mName, String gender, String email, String phoneNumber, String address, String dateOfBirth) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
    }

    public Patient() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getCardRecordNumber() {
        return cardRecordNumber;
    }

    public void setCardRecordNumber(int cardRecordNumber) {
        this.cardRecordNumber = cardRecordNumber;
    }
   // @JsonManagedReference
    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }
}

