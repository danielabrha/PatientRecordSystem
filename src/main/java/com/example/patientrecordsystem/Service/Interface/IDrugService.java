package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.Drug;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDrugService {
    public List<Drug> findAll();
    //	public List<Drug> findAll(int entryid);
    public List<Drug> findAll(String status);
    public Drug findById(int id);
    public Drug update(Drug drug, int systemAdminId);
    public void deleteById(int id);
    public void delete(Drug drug);
    public void deleteAll(Iterable<Drug> drugs);
    public void deleteAll();
    public Drug create(Drug drug,int systemAdminId);
    public List<Drug> createAll(List<Drug> listDrug,int systemAdminId);
}

