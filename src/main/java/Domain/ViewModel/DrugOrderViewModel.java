package Domain.ViewModel;

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
}
