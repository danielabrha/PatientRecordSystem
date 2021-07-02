package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILabTestTypeService {
    public List<LabTestType> findAll();
    //	public List<LabTestType> findAll(int entryid);
    public List<LabTestType> findAll(String status);
    public LabTestType findById(int id);
    public LabTestType update(LabTestType labTestType);
    public void deleteById(int id);
    public void delete(LabTestType labTestType);
    public void deleteAll(Iterable<LabTestType> labTestTypes);
    public void deleteAll();
    public LabTestType create(LabTestType labTestType);
    public List<LabTestType> createAll(List<LabTestType> listLabTestType);
}
