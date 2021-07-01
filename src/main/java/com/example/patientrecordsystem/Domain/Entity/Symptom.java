package com.example.patientrecordsystem.Domain.Entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "symptoms")
public class Symptom {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int symptomId;

    @Column(name = "symptomName")
    private String symptomName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitId", referencedColumnName = "Id")
    private Visit visit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId", referencedColumnName = "Id")
    private Doctor doctor;

    public Symptom(int symptomId, String symptomName, Visit visit, Doctor doctor) {
        this.symptomId = symptomId;
        this.symptomName = symptomName;
        this.visit = visit;
        this.doctor = doctor;
    }

    public Symptom(String symptomName, Visit visit, Doctor doctor) {
        this.symptomName = symptomName;
        this.visit = visit;
        this.doctor = doctor;
    }

    public Symptom() {
    }

    public int getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(int symptomId) {
        this.symptomId = symptomId;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
