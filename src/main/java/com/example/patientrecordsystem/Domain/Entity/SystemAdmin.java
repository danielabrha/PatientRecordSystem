package com.example.patientrecordsystem.Domain.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity(name="SystemAdmins")
public class SystemAdmin {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int systemAdminId;

//    @JsonIgnoreProperties("systemAdmin")
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="userId",referencedColumnName = "Id")
//    private User user;
  //  @JsonManagedReference
//    @JsonIgnoreProperties("systemAdmin")
//    @OneToMany(mappedBy = "systemAdmin")
//    private List<LabTestType> labTestTypeList;
   // @JsonManagedReference
//    @JsonIgnoreProperties("systemAdmin")
//    @OneToMany(mappedBy = "systemAdmin")
//    private List<Drug> drugList;

    public SystemAdmin(int systemAdminIdt) {
        this.systemAdminId = systemAdminId;
      //  this.user = user;
//        this.labTestTypeList = labTestTypeList;
//        this.drugList = drugList;
    }

//    public SystemAdmin( List<LabTestType> labTestTypeList, List<Drug> drugList) {
//
//        this.labTestTypeList = labTestTypeList;
//        this.drugList = drugList;
//    }

    public SystemAdmin() {
    }

    public int getSystemAdminId() {
        return systemAdminId;
    }

    public void setSystemAdminId(int systemAdminId) {
        this.systemAdminId = systemAdminId;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
    //@JsonManagedReference
//    public List<LabTestType> getLabTestTypeList() {
//        return labTestTypeList;
//    }
//
//    public void setLabTestTypeList(List<LabTestType> labTestTypeList) {
//        this.labTestTypeList = labTestTypeList;
//    }
//    // @JsonManagedReference
//    public List<Drug> getDrugList() {
//        return drugList;
//    }
//
//    public void setDrugList(List<Drug> drugList) {
//        this.drugList = drugList;
//    }
}

