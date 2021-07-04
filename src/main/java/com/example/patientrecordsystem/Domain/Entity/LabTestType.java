package com.example.patientrecordsystem.Domain.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Component
@Entity(name = "LabTestTypes")
public class LabTestType {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labTestTypeId;
    @NotNull
    @NotEmpty
    @Size(min = 1, message = "Lab Test name should be at least one character")
    @Column(name = "labTestName")
    private String labTestName;
    @Column(name = "labTestCode")

    @NotNull
    @NotEmpty
    @Size(min = 1, message = "Lab Test code should be at least one character")
    private String labTestCode;

//    @JsonIgnoreProperties("labTestTypeList")
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "systemAdminId", referencedColumnName = "Id")
//    private SystemAdmin systemAdmin;
  //  @JsonManagedReference
//    @JsonIgnoreProperties("labTestType")
    @OneToMany(mappedBy = "labTestType")
    private List<LabOrder> labOrderList;

    public LabTestType(int labTestTypeId, String labTestName, String labTestCode, List<LabOrder> labOrderList) {
        this.labTestTypeId = labTestTypeId;
        this.labTestName = labTestName;
        this.labTestCode = labTestCode;
       // this.systemAdmin = systemAdmin;
        this.labOrderList = labOrderList;
    }

    public LabTestType(String labTestName, String labTestCode, List<LabOrder> labOrderList) {
        this.labTestName = labTestName;
        this.labTestCode = labTestCode;
       // this.systemAdmin = systemAdmin;
        this.labOrderList = labOrderList;
    }

    public LabTestType() {
    }

    public int getLabTestTypeId() {
        return labTestTypeId;
    }

    public void setLabTestTypeId(int labTestTypeId) {
        this.labTestTypeId = labTestTypeId;
    }

    public String getLabTestName() {
        return labTestName;
    }

    public void setLabTestName(String labTestName) {
        this.labTestName = labTestName;
    }

    public String getLabTestCode() {
        return labTestCode;
    }

    public void setLabTestCode(String labTestCode) {
        this.labTestCode = labTestCode;
    }
  //  @JsonIgnore
//    public SystemAdmin getSystemAdmin() {
//        return systemAdmin;
//    }
//
//    public void setSystemAdmin(SystemAdmin systemAdmin) {
//        this.systemAdmin = systemAdmin;
//    }
    //@JsonManagedReference
    public List<LabOrder> getLabOrderList() {
        return labOrderList;
    }

    public void setLabOrderList(List<LabOrder> labOrderList) {
        this.labOrderList = labOrderList;
    }
}
