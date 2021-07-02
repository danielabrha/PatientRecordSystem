package com.example.patientrecordsystem.Service.Interface;



import com.example.patientrecordsystem.Domain.Entity.DrugOrder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDrugOrderService {
    public List<DrugOrder> findAll();
    //	public List<DrugOrder> findAll(int entryid);
    public List<DrugOrder> findAll(String status);
    public DrugOrder findById(int id);
    public DrugOrder update(DrugOrder drugOrder, int drugId,  int visitId);
    public void deleteById(int id);
    public void delete(DrugOrder drugOrder);
    public void deleteAll(Iterable<DrugOrder> drugOrders);
    public void deleteAll();
    public DrugOrder create(DrugOrder drugOrder, int drugId, int visitId);
    public List<DrugOrder> createAll(List<DrugOrder> listDrugOrder);
}
