package com.example.patientrecordsystem.Domain.ViewModel;



import com.example.patientrecordsystem.Domain.Entity.Drug;
import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import com.example.patientrecordsystem.Domain.Entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemAdminViewModel {
    private int systemAdminId;
    private User user;
    private List<LabTestType> labTestTypeList;
    private List<Drug> drugList;

    public SystemAdminViewModel(int systemAdminId, User user, List<LabTestType> labTestTypeList, List<Drug> drugList) {
        this.systemAdminId = systemAdminId;
        this.user = user;
        this.labTestTypeList = labTestTypeList;
        this.drugList = drugList;
    }

    public SystemAdminViewModel(User user, List<LabTestType> labTestTypeList, List<Drug> drugList) {
        this.user = user;
        this.labTestTypeList = labTestTypeList;
        this.drugList = drugList;
    }

    public SystemAdminViewModel() {
    }

    public int getSystemAdminId() {
        return systemAdminId;
    }

    public void setSystemAdminId(int systemAdminId) {
        this.systemAdminId = systemAdminId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LabTestType> getLabTestTypeList() {
        return labTestTypeList;
    }

    public void setLabTestTypeList(List<LabTestType> labTestTypeList) {
        this.labTestTypeList = labTestTypeList;
    }

    public List<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<Drug> drugList) {
        this.drugList = drugList;
    }
}

