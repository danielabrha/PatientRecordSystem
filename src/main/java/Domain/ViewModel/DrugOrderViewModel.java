package Domain.ViewModel;

<<<<<<< HEAD
import Domain.Entity.Doctor;
import Domain.Entity.Drug;
import Domain.Entity.Visit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DrugOrderViewModel {

    private int durgOrderViewModelId;
    private int amount;
    private Doctor doctor;
    private Visit visit;
    private List<Drug> drugList = new ArrayList<>();

    public  DrugOrderViewModel (){

    }

    public int getDurgOrderViewModelId() {
        return durgOrderViewModelId;
    }

    public void setDurgOrderViewModelId(int durgOrderViewModelId) {
        this.durgOrderViewModelId = durgOrderViewModelId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

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
=======
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import Domain.Entity.*;

@Component
public class DrugOrderViewModel {
private int drugOrderId;
private int amount;

private Doctor doctor;

private Visit visit;

private List<Drug> drugList = new ArrayList<>();

public DrugOrderViewModel() {
}

public DrugOrderViewModel(int amount, Doctor doctor, Visit visit, List<Drug> drugList) {
    this.amount = amount;
    this.doctor = doctor;
    this.visit = visit;
    this.drugList = drugList;
}

public DrugOrderViewModel(int drugOrderId, int amount, Doctor doctor, Visit visit, List<Drug> drugList) {
    this.drugOrderId = drugOrderId;
    this.amount = amount;
    this.doctor = doctor;
    this.visit = visit;
    this.drugList = drugList;
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




>>>>>>> upstream/main
}
