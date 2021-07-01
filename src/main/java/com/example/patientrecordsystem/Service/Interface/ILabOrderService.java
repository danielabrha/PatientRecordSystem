package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import com.example.patientrecordsystem.Domain.ViewModel.LabOrderViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILabOrderService {
    public List<LabOrder> findAll();
    //	public List<LabOrderViewModel> findAll(int entryid);
    public List<LabOrder> findAll(String status);
    public LabOrder findById(int id);
    public LabOrder update(LabOrderViewModel labOrderViewModel, int visitId, int doctorId,
                           int labTestTypeId);
    public void deleteById(int id);
    public void delete(LabOrderViewModel labOrderViewModel);
    public void deleteAll(Iterable<LabOrderViewModel> labOrderViewModels);
    public void deleteAll();
    public LabOrder create(LabOrderViewModel labOrderViewModel, int visitId, int doctorId, int labTestTypeId);
    public List<LabOrder> createAll(List<LabOrderViewModel> listLabOrderViewModel, int visitId, int doctorId,
                                    int labTestTypeId);
}

