package com.example.patientrecordsystem.Service.Implementation;


import com.example.patientrecordsystem.Domain.Entity.Doctor;
import com.example.patientrecordsystem.Domain.Entity.Drug;
import com.example.patientrecordsystem.Domain.Entity.DrugOrder;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Repository.IDrugOrderRepository;
import com.example.patientrecordsystem.Service.Interface.IDoctorService;
import com.example.patientrecordsystem.Service.Interface.IDrugOrderService;
import com.example.patientrecordsystem.Service.Interface.IDrugService;
import com.example.patientrecordsystem.Service.Interface.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugOrderService implements IDrugOrderService {

    @Autowired
    private IDrugOrderRepository _drugOrderRepository;

    @Autowired
    private List<DrugOrder> drugOrderList;
    @Autowired
    private VisitService _visitService;
    @Autowired
    private DrugService _drugService;

    public DrugOrderService() {
        _visitService = new VisitService();
        _drugService = new DrugService();
    }

    @Override
    public List<DrugOrder> findAll() {
        return _drugOrderRepository.findAll();
    }

    @Override
    public List<DrugOrder> findAll(String status) {
        return _drugOrderRepository.findAll();
    }

    @Override
    public DrugOrder findById(int id) {
        return _drugOrderRepository.findById(id).orElse(null);
    }

    @Override
    public DrugOrder update(DrugOrder drugOrder1, int drugId, int visitId) {
        DrugOrder drugOrder = _drugOrderRepository.findById(drugOrder1.getDrugOrderId()).orElse(null);
        if (drugOrder != null) {
            Visit visit = _visitService.findById(visitId);
            Drug drug = _drugService.findById(drugId);
            drugOrder.setDrug(drug);
            //  drugOrder1.setDoctor(doctor);
            drugOrder.setVisit(visit);
            return _drugOrderRepository.save(drugOrder);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        _drugOrderRepository.deleteById(id);
    }

    @Override
    public void delete(DrugOrder drugOrder1) {
        DrugOrder drugOrder = _drugOrderRepository.findById(drugOrder1.getDrugOrderId()).orElse(null);
        if (drugOrder != null)
            _drugOrderRepository.deleteById(drugOrder.getDrugOrderId());
    }

    @Override
    public void deleteAll(Iterable<DrugOrder> drugOrders) {
        drugOrders.forEach(drugOrder1 -> {
            DrugOrder drugOrder = _drugOrderRepository.findById(drugOrder1.getDrugOrderId()).orElse(null);
            if (drugOrder != null)
                _drugOrderRepository.deleteById(drugOrder.getDrugOrderId());
        });

    }

    @Override
    public void deleteAll() {
        _drugOrderRepository.deleteAll();
    }

    @Override
    public DrugOrder create(DrugOrder drugOrder1, int drugId, int visitId) {
        Visit visit = _visitService.findById(visitId);
        Drug drug = _drugService.findById(drugId);
        drugOrder1.setDrug(drug);
        //  drugOrder1.setDoctor(doctor);
        drugOrder1.setVisit(visit);
        return _drugOrderRepository.save(drugOrder1);
    }

//    private DrugOrder toDrugOrder(DrugOrder drugOrder1, int drugId, int visitId) {
//     //   Doctor doctor = _doctorService.findById(doctorId);
//
//        return drugOrder1;
//    }

    @Override
    public List<DrugOrder> createAll(List<DrugOrder> listDrugOrder) {
//        listDrugOrder.forEach(roleVM -> {
//            this.drugOrderList.add(toDrugOrder(roleVM));
//        });
//        return _drugOrderRepository.saveAll(this.drugOrderList);
        return null;
    }


}
