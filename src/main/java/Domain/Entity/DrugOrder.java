package Domain.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.stereotype.Component;

//drug order entitiy

@Component
@Entity(name = "drugOrders")
public class DrugOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drugOrderId;
    private int amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId", referencedColumnName = "Id")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitId", referencedColumnName = "Id")
    private Visit visit;

    @JsonIgnore
    @OneToMany(mappedBy = "drugOrder")
    private List<Drug> drugList = new ArrayList<>();

    public DrugOrder() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public DrugOrder(int id, int amount) {
        drugOrderId = id;
        this.amount = amount;
    }

    public int getId() {
        return drugOrderId;
    }

    public void setId(int id) {
        drugOrderId = id;
    }
    // This is from doctor drug


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public List<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<Drug> drugList) {
        this.drugList = drugList;
    }
}
