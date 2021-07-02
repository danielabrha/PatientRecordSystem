package com.example.patientrecordsystem.Domain.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

//    @JsonIgnoreProperties("symptomList")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitId", referencedColumnName = "Id")
    private Visit visit;

//    @JsonIgnoreProperties("symptomList")
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "doctorId", referencedColumnName = "Id")
//    private Doctor doctor;

    public Symptom(int symptomId, String symptomName, Visit visit) {
        this.symptomId = symptomId;
        this.symptomName = symptomName;
        this.visit = visit;
    }

    public Symptom(String symptomName, Visit visit) {
        this.symptomName = symptomName;
        this.visit = visit;
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
  //  @JsonIgnore
    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
  //  @JsonIgnore
//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
}
