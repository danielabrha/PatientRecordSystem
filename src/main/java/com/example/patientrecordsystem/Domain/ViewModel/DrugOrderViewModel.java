package com.example.patientrecordsystem.Domain.ViewModel;



import com.example.patientrecordsystem.Domain.Entity.Doctor;
import com.example.patientrecordsystem.Domain.Entity.Drug;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import org.springframework.stereotype.Component;

@Component
public class DrugOrderViewModel {
    private int drugOrderId;
    private int amount;

    private Visit visit;

    private Doctor doctor;

    private Drug drug;

    public DrugOrderViewModel(int drugOrderId, int amount, Visit visit, Doctor doctor, Drug drug) {
        this.drugOrderId = drugOrderId;
        this.amount = amount;
        this.visit = visit;
        this.doctor = doctor;
        this.drug = drug;
    }

    public DrugOrderViewModel(int amount, Visit visit, Doctor doctor, Drug drug) {
        this.amount = amount;
        this.visit = visit;
        this.doctor = doctor;
        this.drug = drug;
    }

    public DrugOrderViewModel() {
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

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
