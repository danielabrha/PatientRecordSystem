package com.example.patientrecordsystem.Domain.Entity;



import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "labResults")
public class LabResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int labResultId;

    @Column(name = "labResultName")
    private String labResultName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "labOrderId", referencedColumnName = "Id")
    private LabOrder labOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laboratoristId", referencedColumnName = "Id")
    private Laboratorist laboratorist;

    public LabResult(int labResultId, String labResultName, LabOrder labOrder, Laboratorist laboratorist) {
        this.labResultId = labResultId;
        this.labResultName = labResultName;
        this.labOrder = labOrder;
        this.laboratorist = laboratorist;
    }

    public LabResult(String labResultName, LabOrder labOrder, Laboratorist laboratorist) {
        this.labResultName = labResultName;
        this.labOrder = labOrder;
        this.laboratorist = laboratorist;
    }

    public LabResult() {
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
