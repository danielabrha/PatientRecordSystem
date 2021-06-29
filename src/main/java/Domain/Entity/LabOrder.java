package Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity(name = "laborders")
public class LabOrder {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labOrderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitId", referencedColumnName = "Id")
    private Visit visit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId", referencedColumnName = "Id")
    private Doctor doctor;

    @JsonIgnore
    @OneToOne(mappedBy = "labOrder")
    private LabResult labResult;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "labTestTypeId", referencedColumnName = "Id")
    private LabTestType labTestType;

    public LabOrder(int labOrderId, Visit visit, Doctor doctor, LabResult labResult, LabTestType labTestType) {
        this.labOrderId = labOrderId;
        this.visit = visit;
        this.doctor = doctor;
        this.labResult = labResult;
        this.labTestType = labTestType;
    }

    public LabOrder(Visit visit, Doctor doctor, LabResult labResult, LabTestType labTestType) {
        this.visit = visit;
        this.doctor = doctor;
        this.labResult = labResult;
        this.labTestType = labTestType;
    }

    public LabOrder() {
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
