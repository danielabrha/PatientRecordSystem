package Domain.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.stereotype.Component;

//drug order entitiy

@Component
@Entity(name = "drugOrders")
public class DrugOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drugOrderId;
    @Column(name = "amount")
    private int amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitId", referencedColumnName = "Id")
    private Visit visit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId", referencedColumnName = "Id")
    private Doctor doctor;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drugId", referencedColumnName = "Id")
    private Drug drug;

    public DrugOrder(int drugOrderId, int amount, Visit visit, Doctor doctor, Drug drug) {
        this.drugOrderId = drugOrderId;
        this.amount = amount;
        this.visit = visit;
        this.doctor = doctor;
        this.drug = drug;
    }

    public DrugOrder(int amount, Visit visit, Doctor doctor, Drug drug) {
        this.amount = amount;
        this.visit = visit;
        this.doctor = doctor;
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
