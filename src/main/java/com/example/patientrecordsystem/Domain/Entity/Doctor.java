package com.example.patientrecordsystem.Domain.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Doctors")

public class Doctor {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    // @JsonIdentityInfoProperties("doctor")
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userId", referencedColumnName = "Id")
//    private User user;
   // @JsonManagedReference
    //    @JsonIdentityInfoProperties("doctor")
//    @OneToMany(mappedBy = "doctor")
//    private List<Symptom> symptomList;

   // @JsonManagedReference
    //    @JsonIdentityInfoProperties("doctor")
//    @OneToMany(mappedBy = "doctor")
//    private List<DrugOrder> drugOrderList;

   // @JsonManagedReference
    //    @JsonIdentityInfoProperties("doctor")
//    @OneToMany(mappedBy = "doctor")
//    private List<LabOrder> labOrderList;

    public Doctor(int doctorId) {
        this.doctorId = doctorId;
     //   this.user = user;
     //   this.symptomList = symptomList;
       // this.drugOrderList = drugOrderList;
       // this.labOrderList = labOrderList;
    }

//    public Doctor( List<Symptom> symptomList, List<LabOrder> labOrderList) {
//     //   this.user = user;
//        this.symptomList = symptomList;
//       // this.drugOrderList = drugOrderList;
//        this.labOrderList = labOrderList;
//    }

    public Doctor() {
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

//  //  @JsonIdentityInfo
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

   // @JsonManagedReference
//    public List<Symptom> getSymptomList() {
//        return symptomList;
//    }
//
//    public void setSymptomList(List<Symptom> symptomList) {
//        this.symptomList = symptomList;
//    }

  //  @JsonManagedReference
//    public List<DrugOrder> getDrugOrderList() {
//        return drugOrderList;
//    }
//
//    public void setDrugOrderList(List<DrugOrder> drugOrderList) {
//        this.drugOrderList = drugOrderList;
//    }

  //  @JsonManagedReference
//    public List<LabOrder> getLabOrderList() {
//        return labOrderList;
//    }
//
//    public void setLabOrderList(List<LabOrder> labOrderList) {
//        this.labOrderList = labOrderList;
//    }
}

