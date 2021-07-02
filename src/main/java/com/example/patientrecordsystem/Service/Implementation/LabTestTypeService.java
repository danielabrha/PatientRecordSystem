package com.example.patientrecordsystem.Service.Implementation;


import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import com.example.patientrecordsystem.Domain.Entity.SystemAdmin;
import com.example.patientrecordsystem.Repository.ILabTestTypeRepository;
import com.example.patientrecordsystem.Service.Interface.ILabTestTypeService;
import com.example.patientrecordsystem.Service.Interface.ISystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabTestTypeService implements ILabTestTypeService {
    private LabTestType labTestType;
    @Autowired
    private ILabTestTypeRepository _labTestTypeRepository;

    private List<LabTestType> labTestTypeList;

    public LabTestTypeService() {
        labTestTypeList = new ArrayList<>();
    }


    @Override
    public List<LabTestType> findAll() {
        return _labTestTypeRepository.findAll();

    }

    @Override
    public List<LabTestType> findAll(String status) {
        return null;
    }


    @Override
    public LabTestType findById(int id) {
        LabTestType labTesttype = _labTestTypeRepository.findById(id).orElse(null);
        return labTesttype;
    }

    @Override
    public LabTestType update(LabTestType labTestType) {
        LabTestType exisitinglabTestType = _labTestTypeRepository
                .findById(labTestType.getLabTestTypeId())
                .orElse(null);
        if (exisitinglabTestType != null) {
           // exisitinglabTestType = toLabTestType(labTestType);

            exisitinglabTestType.setLabTestCode(labTestType.getLabTestCode());
            exisitinglabTestType.setLabTestName(labTestType.getLabTestName());

            //  exisitinglabTestType.setSystemAdmin(getSystemAdmin(systemAdminId));
            //exisitinglabTestType.setLabTestTypeId(labTestType.getLabTestTypeId());
            return _labTestTypeRepository.save(exisitinglabTestType);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        _labTestTypeRepository.deleteById(id);
    }

    @Override
    public void delete(LabTestType labTestType) {
        _labTestTypeRepository.deleteById(labTestType.getLabTestTypeId());
    }

    @Override
    public void deleteAll(Iterable<LabTestType> labTestTypes) {
        labTestTypes.forEach(labTestType1 -> {
            _labTestTypeRepository.deleteById(labTestType1.getLabTestTypeId());
        });
    }

    @Override
    public void deleteAll() {
        _labTestTypeRepository.deleteAll();
    }


    @Override
    public LabTestType create(LabTestType labTestType) {
//        LabTestType labTestType1 = toLabTestType(labTestType);
//        labTestType.setLabTestCode(labTestType1.getLabTestCode());
//        labTestType.setLabTestName(labTestType1.getLabTestName());
        //labTestType1.setSystemAdmin(getSystemAdmin(systemAdminId));
        return _labTestTypeRepository.save(labTestType);
    }

    // private SystemAdmin getSystemAdmin(int id) {
//        return _systemAdminService.findById(id);
//    }

    @Override
    public List<LabTestType> createAll(List<LabTestType> listLabTestType) {
        List<LabTestType> labTestTypeList = new ArrayList<>();

        listLabTestType.forEach(labTestType1 -> {
            LabTestType labTestType = new LabTestType();
            // labTestType = toLabTestType(labTestType1);
            labTestType.setLabTestCode(labTestType1.getLabTestCode());
            labTestType.setLabTestName(labTestType1.getLabTestName());
            // labTestType.setSystemAdmin(getSystemAdmin(systemAdminId));
            labTestTypeList.add(labTestType);
        });
        return _labTestTypeRepository.saveAll(labTestTypeList);
    }

//    private LabTestType toLabTestType(LabTestType labTestType) {
//
//        labTestType.setLabTestCode(labTestType.getLabTestCode());
//        labTestType.setLabTestName(labTestType.getLabTestName());
//        return labTestType;
//    }
}

