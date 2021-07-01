package com.example.patientrecordsystem.Domain.Entity;



import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity(name = "Laboratorists")
public class Laboratorist {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int laboratoristId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "Id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "laboratorist") // to be copied from LabResult class
    private List<LabResult> labResultList = new ArrayList<>();

    public Laboratorist(int laboratoristId, User user, List<LabResult> labResultList) {
        this.laboratoristId = laboratoristId;
        this.user = user;
        this.labResultList = labResultList;
    }

    public Laboratorist(User user, List<LabResult> labResultList) {
        this.user = user;
        this.labResultList = labResultList;
    }

    public Laboratorist() {
    }

    public int getLaboratoristId() {
        return laboratoristId;
    }

    public void setLaboratoristId(int laboratoristId) {
        this.laboratoristId = laboratoristId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LabResult> getLabResultList() {
        return labResultList;
    }

    public void setLabResultList(List<LabResult> labResultList) {
        this.labResultList = labResultList;
    }
}
