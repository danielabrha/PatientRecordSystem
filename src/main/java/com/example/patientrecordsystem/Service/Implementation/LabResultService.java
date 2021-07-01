package com.example.patientrecordsystem.Service.Implementation;


import com.example.patientrecordsystem.Domain.Entity.LabResult;
import com.example.patientrecordsystem.Repository.ILabResultRepository;
import com.example.patientrecordsystem.Service.Interface.ILabOrderService;
import com.example.patientrecordsystem.Service.Interface.ILabResultService;
import com.example.patientrecordsystem.Service.Interface.ILaboratoristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabResultService implements ILabResultService {

    @Autowired
    ILabResultRepository _labResultRepository;

    @Autowired
    private List<LabResult> labResultList;

    @Autowired
    private LabOrderService _labOrderService;
    @Autowired
    private LaboratoristService _laboratoristService;

    public LabResultService() {
        _labOrderService = new LabOrderService();
        _laboratoristService = new LaboratoristService();
        labResultList = new ArrayList<>();
    }

    @Override
    public LabResult create(LabResult labResult1, int labOrderId, int laboratoristId) {
        LabResult labResult=toLabResult(labResult1,labOrderId, laboratoristId);
        return _labResultRepository.save(labResult);
    }

    @Override
    public List<LabResult> createAll(List<LabResult> labResultList, int labOrderId,
                                     int laboratoristId) {
        LabResult labResult = new LabResult();
        labResultList.forEach(labResultVM -> {

            this.labResultList.add(toLabResult(labResultVM,labOrderId, laboratoristId));
        });
        return _labResultRepository.saveAll(this.labResultList);
    }

    @Override
    public void delete(LabResult labResult) {


    }

    @Override

    public void deleteAll(Iterable<LabResult> labResults) {


    }

    @Override
    public void deleteAll() {
        _labResultRepository.deleteAll();
    }

    @Override
    public void deleteById(int id) {
        _labResultRepository.deleteById(id);
    }

    @Override
    public List<LabResult> findAll() {
        return _labResultRepository.findAll();
    }

    @Override
    public List<LabResult> findAll(String status) {

        return null;
    }

    @Override
    public LabResult findById(int id) {
        return _labResultRepository.findById(id).orElse(null);
    }

    @Override
    public LabResult update(LabResult labResult) {
        return null;
    }


    public LabResult toLabResult(LabResult labResult, int labOrderId, int laboratoristId) {

        labResult.setLabResultName(labResult.getLabResultName());
        labResult.setLabOrder(_labOrderService.findById(labOrderId));
        labResult.setLaboratorist(_laboratoristService.findById(laboratoristId));
        return labResult;
    }

}
