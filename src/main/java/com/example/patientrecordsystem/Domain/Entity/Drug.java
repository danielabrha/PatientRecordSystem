package com.example.patientrecordsystem.Domain.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity(name = "Drugs")
public class Drug {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drugId;
    @Column(name = "drugName")
    private String drugName;
    @Column(name = "drugCode")
    private String drugCode;
    //   @JsonManagedReference
//    @JsonIdentityInfoProperties("drug")
    @JsonIgnore
    @OneToMany(mappedBy = "drug")
    private List<DrugOrder> drugOrderList;

//    @JsonIdentityInfoProperties("drugList")
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "systemAdminId", referencedColumnName = "Id")
//    private SystemAdmin systemAdmin;

    public Drug(int drugId, String drugName, String drugCode, List<DrugOrder> drugOrderList) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.drugOrderList = drugOrderList;
        //  this.systemAdmin = systemAdmin;
    }

    public Drug(String drugName, String drugCode, List<DrugOrder> drugOrderList) {
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.drugOrderList = drugOrderList;
//        this.systemAdmin = systemAdmin;
    }

    public Drug() {
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    // @JsonManagedReference
    public List<DrugOrder> getDrugOrderList() {
        return drugOrderList;
    }

    public void setDrugOrderList(List<DrugOrder> drugOrderList) {
        this.drugOrderList = drugOrderList;
    }
    //  @JsonIdentityInfo
//    public SystemAdmin getSystemAdmin() {
//        return systemAdmin;
//    }
//
//    public void setSystemAdmin(SystemAdmin systemAdmin) {
//        this.systemAdmin = systemAdmin;
//    }
}
