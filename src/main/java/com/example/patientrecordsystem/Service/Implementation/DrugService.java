package com.example.patientrecordsystem.Service.Implementation;



import com.example.patientrecordsystem.Domain.Entity.Drug;
import com.example.patientrecordsystem.Repository.IDrugRepository;
import com.example.patientrecordsystem.Service.Interface.IDrugService;
import com.example.patientrecordsystem.Service.Interface.ISystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugService implements IDrugService {

    @Autowired
    IDrugRepository _drugRepository;


    List<Drug> drugList;
    @Autowired
    private SystemAdminService _systemAdminService;

    public DrugService() {
        drugList = new ArrayList<>();
        _systemAdminService = new SystemAdminService();
    }


    @Override
    public List<Drug> findAll() {
        return _drugRepository.findAll();
    }

    @Override
    public List<Drug> findAll(String status) {
        return _drugRepository.findAll();
    }

    @Override
    public Drug findById(int id) {
        return _drugRepository.findById(id).orElse(null);
    }

    @Override
    public Drug update(Drug drug, int systemAdminId) {
        Drug previousDrug = _drugRepository.findById(drug.getDrugId()).orElse(null);
        if (previousDrug != null) {
            previousDrug = toDrug(drug,systemAdminId);
            previousDrug.setDrugId(drug.getDrugId());

        }
        return _drugRepository.save(previousDrug);
    }

    @Override
    public void deleteById(int id) {
        _drugRepository.deleteById(id);
    }

    @Override
    public void delete(Drug drug) {
        Drug previousDrug = _drugRepository.findById(drug.getDrugId()).orElse(null);
        if (previousDrug != null) {
            _drugRepository.deleteById(previousDrug.getDrugId());
        }
    }

    @Override
    public void deleteAll(Iterable<Drug> drugs) {
        drugs.forEach(role -> {
            Drug drug = _drugRepository.findById(role.getDrugId()).orElse(null);
            if (drug != null)
                _drugRepository.deleteById(drug.getDrugId());
        });
    }

    @Override
    public void deleteAll() {
        _drugRepository.deleteAll();
    }

    @Override
    public Drug create(Drug drug1, int systemAdminId) {
        Drug drug = toDrug(drug1,systemAdminId);
        return _drugRepository.save(drug);
    }



    @Override
    public List<Drug> createAll(List<Drug> listDrug, int systemAdminId) {
        Drug drug = new Drug();
        listDrug.forEach(roleVM -> {

            this.drugList.add(toDrug(roleVM,systemAdminId));
        });
        return _drugRepository.saveAll(this.drugList);

    }

    public Drug toDrug(Drug drug,int systemAdminId) {
        drug.setSystemAdmin(_systemAdminService.findById(systemAdminId));
        return drug;
    }
}

