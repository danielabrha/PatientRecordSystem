package com.example.patientrecordsystem.Domain.ViewModel;


import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import com.example.patientrecordsystem.Domain.Entity.Laboratorist;
import org.springframework.stereotype.Component;

@Component
public class LabResultViewModel {
    private int labResultId;
    private String labResultName;
    private LabOrder labOrder;
    private Laboratorist laboratorist;

    public LabResultViewModel(int labResultId, String labResultName, LabOrder labOrder, Laboratorist laboratorist) {
        this.labResultId = labResultId;
        this.labResultName = labResultName;
        this.labOrder = labOrder;
        this.laboratorist = laboratorist;
    }

    public LabResultViewModel(String labResultName, LabOrder labOrder, Laboratorist laboratorist) {
        this.labResultName = labResultName;
        this.labOrder = labOrder;
        this.laboratorist = laboratorist;
    }

    public LabResultViewModel() {
    }

    public int getLabResultId() {
        return labResultId;
    }

    public void setLabResultId(int labResultId) {
        this.labResultId = labResultId;
    }

    public String getLabResultName() {
        return labResultName;
    }

    public void setLabResultName(String labResultName) {
        this.labResultName = labResultName;
    }

    public LabOrder getLabOrder() {
        return labOrder;
    }

    public void setLabOrder(LabOrder labOrder) {
        this.labOrder = labOrder;
    }

    public Laboratorist getLaboratorist() {
        return laboratorist;
    }

    public void setLaboratorist(Laboratorist laboratorist) {
        this.laboratorist = laboratorist;
    }
}

