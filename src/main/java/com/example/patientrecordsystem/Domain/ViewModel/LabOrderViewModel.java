package com.example.patientrecordsystem.Domain.ViewModel;



import com.example.patientrecordsystem.Domain.Entity.Doctor;
import com.example.patientrecordsystem.Domain.Entity.LabResult;
import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import org.springframework.stereotype.Component;

@Component
public class LabOrderViewModel {

    private int labOrderId;
    private Visit visit;
    private Doctor doctor;
    private LabResult labResult;
    private LabTestType labTestType;

    public LabOrderViewModel(int labOrderId, Visit visit, Doctor doctor, LabResult labResult, LabTestType labTestType) {
        this.labOrderId = labOrderId;
        this.visit = visit;
        this.doctor = doctor;
        this.labResult = labResult;
        this.labTestType = labTestType;
    }

    public LabOrderViewModel() {
    }

    public int getLabOrderId() {
        return labOrderId;
    }

    public void setLabOrderId(int labOrderId) {
        this.labOrderId = labOrderId;
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

    public LabResult getLabResult() {
        return labResult;
    }

    public void setLabResult(LabResult labResult) {
        this.labResult = labResult;
    }

    public LabTestType getLabTestType() {
        return labTestType;
    }

    public void setLabTestType(LabTestType labTestType) {
        this.labTestType = labTestType;
    }
}

