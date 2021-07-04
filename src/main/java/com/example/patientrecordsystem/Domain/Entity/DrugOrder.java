package com.example.patientrecordsystem.Domain.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Component
@Entity(name = "drugOrders")
public class DrugOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drugOrderId;

    @PositiveOrZero(message = "amount should zero or positive number")
    @Column(name = "amount")
    private int amount;

//    @JsonIdentityInfoProperties("drugOrderList")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitId", referencedColumnName = "Id")
    private Visit visit;

//    @JsonIdentityInfoProperties("drugOrderList")
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "doctorId", referencedColumnName = "Id")
//    private Doctor doctor;

//    @JsonIdentityInfoProperties("drugOrderList")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drugId", referencedColumnName = "Id")
    private Drug drug;

    public DrugOrder(int drugOrderId, int amount, Visit visit, Drug drug) {
        this.drugOrderId = drugOrderId;
        this.amount = amount;
        this.visit = visit;
       // this.doctor = doctor;
        this.drug = drug;
    }

    public DrugOrder(int amount, Visit visit, Drug drug) {
        this.amount = amount;
        this.visit = visit;
//        this.doctor = doctor;
        this.drug = drug;
    }

    public DrugOrder() {
    }

    public int getDrugOrderId() {
        return drugOrderId;
    }

    public void setDrugOrderId(int drugOrderId) {
        this.drugOrderId = drugOrderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
  //  @JsonIdentityInfo
    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
   // @JsonIdentityInfo
//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
   // @JsonIdentityInfo
    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}

