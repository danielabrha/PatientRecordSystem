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
    private ILabResultRepository _labResultRepository;

    @Autowired
    private List<LabResult> labResultList;

    @Autowired
    private LabOrderService _labOrderService;

    public LabResultService() {
        _labOrderService = new LabOrderService();
        labResultList = new ArrayList<>();
    }

    @Override
    public LabResult create(LabResult labResult, int labOrderId) {
      // LabResult labResult=toLabResult(labResult1,labOrderId);
       // labResult.setLabResultName(labResult1.getLabResultName());
        labResult.setLabOrder(_labOrderService.findById(labOrderId));
        return _labResultRepository.save(labResult);
    }

    @Override
    public List<LabResult> createAll(List<LabResult> labResultList, int labOrderId) {
        LabResult labResult = new LabResult();
        labResultList.forEach(labResultVM -> {
            labResult.setLabResultName(labResultVM.getLabResultName());
            labResult.setLabOrder(_labOrderService.findById(labOrderId));
            this.labResultList.add(labResult);
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


//    public LabResult toLabResult(LabResult labResult, int labOrderId) {
//
//        labResult.setLabResultName(labResult.getLabResultName());
//        labResult.setLabOrder(_labOrderService.findById(labOrderId));
//       // labResult.setLaboratorist(_laboratoristService.findById(laboratoristId));
//        return labResult;
//    }

}
