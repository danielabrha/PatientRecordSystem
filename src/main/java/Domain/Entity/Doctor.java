package Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//
//@Component
@Entity(name="Doctors")
public class Doctor {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    // third change


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "Id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<LabOrder> labOrderList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private  List<Symptom> symptomList = new ArrayList<>();

    public Doctor(int doctorId, User user, List<LabOrder> labOrderList, List<Symptom> symptomList) {
        this.doctorId = doctorId;
        this.user = user;
        this.labOrderList = labOrderList;
        this.symptomList = symptomList;
    }

    public Doctor(User user, List<LabOrder> labOrderList, List<Symptom> symptomList) {
        this.user = user;
        this.labOrderList = labOrderList;
        this.symptomList = symptomList;
    }

    public Doctor() {
    }
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LabOrder> getLabOrderList() {
        return labOrderList;
    }

    public void setLabOrderList(List<LabOrder> labOrderList) {
        this.labOrderList = labOrderList;
    }

    public List<Symptom> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(List<Symptom> symptomList) {
        this.symptomList = symptomList;
    }
}
