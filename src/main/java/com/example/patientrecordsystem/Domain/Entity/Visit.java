package com.example.patientrecordsystem.Domain.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Entity(name = "visits")
public class Visit {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visitId;

    @Column(name = "visitDate")
    private Date visitDate;

//    @JsonIgnoreProperties("listVisit")
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "receptionstId", referencedColumnName = "Id")
//    private Receptionst receptionst;

    //    @JsonIgnoreProperties("visitList")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId", referencedColumnName = "Id")
    private Patient patient;
    //  @JsonManagedReference
//    @JsonIgnoreProperties("visit")
    @JsonIgnore
    @OneToMany(mappedBy = "visit")
    private List<Symptom> symptomList;
    //  @JsonManagedReference
//    @JsonIgnoreProperties("visit")
    @JsonIgnore
    @OneToMany(mappedBy = "visit")
    private List<LabOrder> labOrderList;
    //   @JsonManagedReference
//    @JsonIgnoreProperties("visit")
    @JsonIgnore
    @OneToMany(mappedBy = "visit")
    private List<DrugOrder> drugOrderList;

    public Visit(int visitId, Date visitDate, Patient patient,
                 List<Symptom> symptomList, List<LabOrder> labOrderList, List<DrugOrder> drugOrderList) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        //   this.receptionst = receptionst;
        this.patient = patient;
        this.symptomList = symptomList;
        this.labOrderList = labOrderList;
        this.drugOrderList = drugOrderList;
    }

    public Visit(Date visitDate, Patient patient,
                 List<Symptom> symptomList, List<LabOrder> labOrderList, List<DrugOrder> drugOrderList) {
        this.visitDate = visitDate;
        //  this.receptionst = receptionst;
        this.patient = patient;
        this.symptomList = symptomList;
        this.labOrderList = labOrderList;
        this.drugOrderList = drugOrderList;
    }

    public Visit() {
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    //  @JsonIgnore
//    public Receptionst getReceptionst() {
//        return receptionst;
//    }
//
//    public void setReceptionst(Receptionst receptionst) {
//        this.receptionst = receptionst;
//    }
    // @JsonIgnore
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    //@JsonManagedReference
    public List<Symptom> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(List<Symptom> symptomList) {
        this.symptomList = symptomList;
    }

    // @JsonManagedReference
    public List<LabOrder> getLabOrderList() {
        return labOrderList;
    }

    public void setLabOrderList(List<LabOrder> labOrderList) {
        this.labOrderList = labOrderList;
    }

    // @JsonManagedReference
    public List<DrugOrder> getDrugOrderList() {
        return drugOrderList;
    }

    public void setDrugOrderList(List<DrugOrder> drugOrderList) {
        this.drugOrderList = drugOrderList;
    }
}
