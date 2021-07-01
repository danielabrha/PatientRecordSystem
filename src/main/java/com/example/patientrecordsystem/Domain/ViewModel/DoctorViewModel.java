package com.example.patientrecordsystem.Domain.ViewModel;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorViewModel {

    private int doctorId;

    private UserViewModel userViewModel;


    private List<SymptomViewModel> symptomViewModelList = new ArrayList<>();
    private List<DrugOrderViewModel> drugOrderViewModelList = new ArrayList<>();
    private List<LabOrderViewModel> labOrderViewModelList = new ArrayList<>();

    public DoctorViewModel(int doctorId, UserViewModel userViewModel, List<SymptomViewModel> symptomViewModelList, List<DrugOrderViewModel> drugOrderViewModelList, List<LabOrderViewModel> labOrderViewModelList) {
        this.doctorId = doctorId;
        this.userViewModel = userViewModel;
        this.symptomViewModelList = symptomViewModelList;
        this.drugOrderViewModelList = drugOrderViewModelList;
        this.labOrderViewModelList = labOrderViewModelList;
    }

    public DoctorViewModel(UserViewModel userViewModel, List<SymptomViewModel> symptomViewModelList, List<DrugOrderViewModel> drugOrderViewModelList, List<LabOrderViewModel> labOrderViewModelList) {
        this.userViewModel = userViewModel;
        this.symptomViewModelList = symptomViewModelList;
        this.drugOrderViewModelList = drugOrderViewModelList;
        this.labOrderViewModelList = labOrderViewModelList;
    }

    public DoctorViewModel() {
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public UserViewModel getUserViewModel() {
        return userViewModel;
    }

    public void setUserViewModel(UserViewModel userViewModel) {
        this.userViewModel = userViewModel;
    }

    public List<SymptomViewModel> getSymptomViewModelList() {
        return symptomViewModelList;
    }

    public void setSymptomViewModelList(List<SymptomViewModel> symptomViewModelList) {
        this.symptomViewModelList = symptomViewModelList;
    }

    public List<DrugOrderViewModel> getDrugOrderViewModelList() {
        return drugOrderViewModelList;
    }

    public void setDrugOrderViewModelList(List<DrugOrderViewModel> drugOrderViewModelList) {
        this.drugOrderViewModelList = drugOrderViewModelList;
    }

    public List<LabOrderViewModel> getLabOrderViewModelList() {
        return labOrderViewModelList;
    }

    public void setLabOrderViewModelList(List<LabOrderViewModel> labOrderViewModelList) {
        this.labOrderViewModelList = labOrderViewModelList;
    }
}
