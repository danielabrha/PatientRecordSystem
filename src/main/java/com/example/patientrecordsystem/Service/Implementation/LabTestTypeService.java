package com.example.patientrecordsystem.Service.Implementation;



import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import com.example.patientrecordsystem.Domain.Entity.SystemAdmin;
import com.example.patientrecordsystem.Domain.ViewModel.LabTestTypeViewModel;
import com.example.patientrecordsystem.Repository.ILabTestTypeRepository;
import com.example.patientrecordsystem.Service.Interface.ILabTestTypeService;
import com.example.patientrecordsystem.Service.Interface.ISystemAdminService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabTestTypeService implements ILabTestTypeService {
    private LabTestType labTestType;
    private ILabTestTypeRepository _labTestTypeRepository;
    private LabTestTypeViewModel labTestTypeViewModel;
    private ISystemAdminService _systemAdminService;

    private List<LabTestType> labTestTypeList;

    public LabTestTypeService() {
        labTestTypeList = new ArrayList<>();
        _systemAdminService = new SystemAdminService();
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
        return _labTestTypeRepository.findById(id).orElse(null);
    }

    @Override
    public LabTestType update(LabTestTypeViewModel labTestTypeViewModel, int systemAdminId) {
        LabTestType exisitinglabTestType = _labTestTypeRepository
                .findById(labTestTypeViewModel.getLabTestTypeId())
                .orElse(null);
        if (exisitinglabTestType != null) {
            exisitinglabTestType= toLabTestType(labTestTypeViewModel);
            exisitinglabTestType.setSystemAdmin(getSystemAdmin(systemAdminId));
            exisitinglabTestType.setLabTestTypeId(labTestTypeViewModel.getLabTestTypeId());
            return _labTestTypeRepository.save(exisitinglabTestType);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        _labTestTypeRepository.deleteById(id);
    }

    @Override
    public void delete(LabTestTypeViewModel labTestTypeViewModel) {
        _labTestTypeRepository.deleteById(labTestTypeViewModel.getLabTestTypeId());
    }

    @Override
    public void deleteAll(Iterable<LabTestTypeViewModel> labTestTypeViewModels) {
        labTestTypeViewModels.forEach(labTestTypeViewModel1 -> {
            _labTestTypeRepository.deleteById(labTestTypeViewModel1.getLabTestTypeId());
        });
    }

    @Override
    public void deleteAll() {
        _labTestTypeRepository.deleteAll();
    }


    @Override
    public LabTestType create(LabTestTypeViewModel labTestTypeViewModel, int systemAdminId) {
        LabTestType labTestType = toLabTestType(labTestTypeViewModel);
        labTestType.setSystemAdmin(getSystemAdmin(systemAdminId));
        return _labTestTypeRepository.save(labTestType);
    }

    private SystemAdmin getSystemAdmin(int id) {
        return _systemAdminService.findById(id);
    }

    @Override
    public List<LabTestType> createAll(List<LabTestTypeViewModel> listLabTestTypeViewModel, int systemAdminId) {
        List<LabTestType> labTestTypeList = new ArrayList<>();

        listLabTestTypeViewModel.forEach(labTestTypeViewModel1 -> {
            LabTestType labTestType = new LabTestType();
            labTestType = toLabTestType(labTestTypeViewModel1);
            labTestType.setSystemAdmin(getSystemAdmin(systemAdminId));
            labTestTypeList.add(labTestType);
        });
        return _labTestTypeRepository.saveAll(labTestTypeList);
    }

    private LabTestType toLabTestType(LabTestTypeViewModel labTestTypeViewModel) {
        LabTestType labTestType = new LabTestType();
        labTestType.setLabTestCode(labTestTypeViewModel.getLabTestCode());
        labTestType.setLabTestName(labTestTypeViewModel.getLabTestName());
        return labTestType;
    }
}

