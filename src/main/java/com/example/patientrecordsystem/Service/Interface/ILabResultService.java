package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.LabResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILabResultService {
    public List<LabResult> findAll();
    //	public List<LabResult> findAll(int entryid);
    public List<LabResult> findAll(String status);
    public LabResult findById(int id);
    public LabResult update(LabResult labResult);
    public void deleteById(int id);
    public void delete(LabResult labResult);
    public void deleteAll(Iterable<LabResult> labResults);
    public void deleteAll();
    public LabResult create(LabResult labResult, int labOrderId);
    public List<LabResult> createAll(List<LabResult> listLabResult, int labOrderId);
}

