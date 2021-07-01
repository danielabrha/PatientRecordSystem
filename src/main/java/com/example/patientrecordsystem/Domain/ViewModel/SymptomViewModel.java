package com.example.patientrecordsystem.Domain.ViewModel;



import com.example.patientrecordsystem.Domain.Entity.Doctor;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import org.springframework.stereotype.Component;

@Component
public class SymptomViewModel {
    private int symptomId;
    private String symptomName;
    private Visit visit;
    private Doctor doctor;

    public SymptomViewModel(int symptomId, String symptomName, Visit visit, Doctor doctor) {
        this.symptomId = symptomId;
        this.symptomName = symptomName;
        this.visit = visit;
        this.doctor = doctor;
    }

    public SymptomViewModel(String symptomName, Visit visit, Doctor doctor) {
        this.symptomName = symptomName;
        this.visit = visit;
        this.doctor = doctor;
    }

    public SymptomViewModel() {
    }

    public int getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(int symptomId) {
        this.symptomId = symptomId;
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
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
}

