package com.example.patientrecordsystem.Domain.Entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Doctors")
public class Doctor {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "Id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Symptom> symptomList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<DrugOrder> drugOrderList = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<LabOrder> labOrderList = new ArrayList<>();

    public Doctor(int doctorId, User user, List<Symptom> symptomList, List<DrugOrder> drugOrderList, List<LabOrder> labOrderList) {
        this.doctorId = doctorId;
        this.user = user;
        this.symptomList = symptomList;
        this.drugOrderList = drugOrderList;
        this.labOrderList = labOrderList;
    }

    public Doctor(User user, List<Symptom> symptomList, List<DrugOrder> drugOrderList, List<LabOrder> labOrderList) {
        this.user = user;
        this.symptomList = symptomList;
        this.drugOrderList = drugOrderList;
        this.labOrderList = labOrderList;
    }

    public Doctor() {
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Symptom> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(List<Symptom> symptomList) {
        this.symptomList = symptomList;
    }

    public List<DrugOrder> getDrugOrderList() {
        return drugOrderList;
    }

    public void setDrugOrderList(List<DrugOrder> drugOrderList) {
        this.drugOrderList = drugOrderList;
    }

    public List<LabOrder> getLabOrderList() {
        return labOrderList;
    }

    public void setLabOrderList(List<LabOrder> labOrderList) {
        this.labOrderList = labOrderList;
    }
}

