package com.example.patientrecordsystem.Domain.ViewModel;



import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrugViewModel {
    private int drugId;
    private String drugName;

    private String drugCode;

    private List<DrugOrderViewModel> drugOrderViewModelList;

    private SystemAdminViewModel systemAdminViewModel;

    public DrugViewModel(int drugId, String drugName, String drugCode, List<DrugOrderViewModel> drugOrderViewModelList, SystemAdminViewModel systemAdminViewModel) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.drugOrderViewModelList = drugOrderViewModelList;
        this.systemAdminViewModel = systemAdminViewModel;
    }

    public DrugViewModel(String drugName, String drugCode, List<DrugOrderViewModel> drugOrderViewModelList, SystemAdminViewModel systemAdminViewModel) {
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.drugOrderViewModelList = drugOrderViewModelList;
        this.systemAdminViewModel = systemAdminViewModel;
    }

    public DrugViewModel() {
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

    public List<DrugOrderViewModel> getDrugOrderViewModelList() {
        return drugOrderViewModelList;
    }

    public void setDrugOrderViewModelList(List<DrugOrderViewModel> drugOrderViewModelList) {
        this.drugOrderViewModelList = drugOrderViewModelList;
    }

    public SystemAdminViewModel getSystemAdminViewModel() {
        return systemAdminViewModel;
    }

    public void setSystemAdminViewModel(SystemAdminViewModel systemAdminViewModel) {
        this.systemAdminViewModel = systemAdminViewModel;
    }
}
