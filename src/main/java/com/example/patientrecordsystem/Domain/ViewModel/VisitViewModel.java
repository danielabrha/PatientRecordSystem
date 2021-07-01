package com.example.patientrecordsystem.Domain.ViewModel;



import com.example.patientrecordsystem.Domain.Entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class VisitViewModel {
    private int visitId;
    private Date visitDate;
    private Receptionst receptionst;
    private Patient patient;
    private List<Symptom> symptomList = new ArrayList<>();
    private List<LabOrder> labOrderList = new ArrayList<>();
    private List<DrugOrder> drugOrderList = new ArrayList<>();

    public VisitViewModel(int visitId, Date visitDate, Receptionst receptionst,
                          Patient patient, List<Symptom> symptomList,
                          List<LabOrder> labOrderList, List<DrugOrder> drugOrderList) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.receptionst = receptionst;
        this.patient = patient;
        this.symptomList = symptomList;
        this.labOrderList = labOrderList;
        this.drugOrderList = drugOrderList;
    }

    public VisitViewModel(Date visitDate, Receptionst receptionst, Patient patient,
                          List<Symptom> symptomList, List<LabOrder> labOrderList,
                          List<DrugOrder> drugOrderList) {
        this.visitDate = visitDate;
        this.receptionst = receptionst;
        this.patient = patient;
        this.symptomList = symptomList;
        this.labOrderList = labOrderList;
        this.drugOrderList = drugOrderList;
    }

    public VisitViewModel() {
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

    public Receptionst getReceptionst() {
        return receptionst;
    }

    public void setReceptionst(Receptionst receptionst) {
        this.receptionst = receptionst;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Symptom> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(List<Symptom> symptomList) {
        this.symptomList = symptomList;
    }

    public List<LabOrder> getLabOrderList() {
        return labOrderList;
    }

    public void setLabOrderList(List<LabOrder> labOrderList) {
        this.labOrderList = labOrderList;
    }

    public List<DrugOrder> getDrugOrderList() {
        return drugOrderList;
    }

    public void setDrugOrderList(List<DrugOrder> drugOrderList) {
        this.drugOrderList = drugOrderList;
    }
}
