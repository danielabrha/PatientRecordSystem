package com.example.patientrecordsystem.Domain.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    //    @JsonIdentityInfoProperties("laboratorist")
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userId", referencedColumnName = "Id")
//    private User user;
   //@JsonManagedReference
//    @JsonIdentityInfoProperties("laboratorist")
//    @OneToMany(mappedBy = "laboratorist") // to be copied from LabResult class
//    private List<LabResult> labResultList;

    public Laboratorist(int laboratoristId) {
        this.laboratoristId = laboratoristId;
//        this.user = user;
//        this.labResultList = labResultList;
    }

    public Laboratorist(User user) {
//        this.user = user;
//        this.labResultList = labResultList;
    }

    public Laboratorist() {
    }

    public int getLaboratoristId() {
        return laboratoristId;
    }

    public void setLaboratoristId(int laboratoristId) {
        this.laboratoristId = laboratoristId;
    }

    //  @JsonIdentityInfo
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    //  @JsonManagedReference
//    public List<LabResult> getLabResultList() {
//        return labResultList;
//    }
//
//    public void setLabResultList(List<LabResult> labResultList) {
//        this.labResultList = labResultList;
//    }
}
