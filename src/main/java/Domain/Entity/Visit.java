package Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//
@Component
@Entity(name = "visits")
public class Visit {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visitId;

    @Column(name = "visitDate")
    private Date visitDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receptionstId", referencedColumnName = "Id")
    private Receptionst receptionst;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patientId",referencedColumnName = "Id")
    private Patient patient;

    @JsonIgnore
    @OneToMany(mappedBy = "visit")
    private List<Symptom> symptomList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "visit")
    private List<LabOrder> labOrderList = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "visit")
    private List<DrugOrder> drugOrderList = new ArrayList<>();

    public Visit(int visitId, Date visitDate, Receptionst receptionst, Patient patient,
                 List<Symptom> symptomList, List<LabOrder> labOrderList, List<DrugOrder> drugOrderList) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.receptionst = receptionst;
        this.patient = patient;
        this.symptomList = symptomList;
        this.labOrderList = labOrderList;
        this.drugOrderList = drugOrderList;
    }

    public Visit(Date visitDate, Receptionst receptionst, Patient patient,
                 List<Symptom> symptomList, List<LabOrder> labOrderList, List<DrugOrder> drugOrderList) {
        this.visitDate = visitDate;
        this.receptionst = receptionst;
        this.patient = patient;
        this.symptomList = symptomList;
        this.labOrderList = labOrderList;
        this.drugOrderList = drugOrderList;
    }

    public Visit() {
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
