package com.example.patientrecordsystem.Domain.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "laborders")
public class LabOrder {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labOrderId;

    //    @JsonIgnoreProperties("labOrderList")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitId", referencedColumnName = "Id")
    private Visit visit;

    //    @JsonIgnoreProperties("labOrderList")
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "doctorId", referencedColumnName = "Id")
//    private Doctor doctor;
  //  @JsonIgnore
//    @JsonIgnoreProperties("labOrder")
    @OneToOne(mappedBy = "labOrder")
    private LabResult labResult;

    //    @JsonIgnoreProperties("labOrderList")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "labTestTypeId", referencedColumnName = "Id")
    private LabTestType labTestType;

    public LabOrder(int labOrderId, Visit visit,LabResult labResult, LabTestType labTestType) {
        this.labOrderId = labOrderId;
        this.visit = visit;
      //  this.doctor = doctor;
        this.labResult = labResult;
        this.labTestType = labTestType;
    }

    public LabOrder(Visit visit, LabResult labResult, LabTestType labTestType) {
        this.visit = visit;
      //  this.doctor = doctor;
        this.labResult = labResult;
        this.labTestType = labTestType;
    }

    public LabOrder() {
    }

    public int getLabOrderId() {
        return labOrderId;
    }

    public void setLabOrderId(int labOrderId) {
        this.labOrderId = labOrderId;
    }

    //  @JsonIgnore
    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    // @JsonIgnore
//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }

    //  @JsonIgnore
    public LabResult getLabResult() {
        return labResult;
    }

    public void setLabResult(LabResult labResult) {
        this.labResult = labResult;
    }

    // @JsonIgnore
    public LabTestType getLabTestType() {
        return labTestType;
    }

    public void setLabTestType(LabTestType labTestType) {
        this.labTestType = labTestType;
    }
}
