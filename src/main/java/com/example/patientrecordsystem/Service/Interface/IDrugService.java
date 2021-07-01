package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.Drug;
import com.example.patientrecordsystem.Domain.ViewModel.DrugViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDrugService {
    public List<Drug> findAll();
    //	public List<DrugViewModel> findAll(int entryid);
    public List<Drug> findAll(String status);
    public Drug findById(int id);
    public Drug update(DrugViewModel drugViewModel, int systemAdminId);
    public void deleteById(int id);
    public void delete(DrugViewModel drugViewModel);
    public void deleteAll(Iterable<DrugViewModel> drugViewModels);
    public void deleteAll();
    public Drug create(DrugViewModel drugViewModel,int systemAdminId);
    public List<Drug> createAll(List<DrugViewModel> listDrugViewModel,int systemAdminId);
}

