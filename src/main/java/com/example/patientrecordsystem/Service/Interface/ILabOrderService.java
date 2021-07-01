package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILabOrderService {
    public List<LabOrder> findAll();
    //	public List<LabOrder> findAll(int entryid);
    public List<LabOrder> findAll(String status);
    public LabOrder findById(int id);
    public LabOrder update(LabOrder labOrder, int visitId, int doctorId,
                           int labTestTypeId);
    public void deleteById(int id);
    public void delete(LabOrder labOrder);
    public void deleteAll(Iterable<LabOrder> labOrders);
    public void deleteAll();
    public LabOrder create(int visitId, int doctorId, int labTestTypeId);
    public List<LabOrder> createAll(List<LabOrder> listLabOrder, int visitId, int doctorId,
                                    int labTestTypeId);
}

