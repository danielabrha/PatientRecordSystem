package com.example.patientrecordsystem.Service.Implementation;


import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import com.example.patientrecordsystem.Repository.ILabOrderRepository;
import com.example.patientrecordsystem.Repository.ILabResultRepository;
import com.example.patientrecordsystem.Service.Interface.IDoctorService;
import com.example.patientrecordsystem.Service.Interface.ILabOrderService;
import com.example.patientrecordsystem.Service.Interface.ILabTestTypeService;
import com.example.patientrecordsystem.Service.Interface.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabOrderService implements ILabOrderService {

    @Autowired
    private ILabOrderRepository _labOrderRepository;
    @Autowired
    private List<LabOrder> labOrderList;

    @Autowired
    private VisitService _visitService;

    @Autowired
    private DoctorService _doctorService;

    @Autowired
    private LabTestTypeService _labTestTypeService;

    private List<LabTestType> labTestTypeList;


    @Autowired
    private ILabResultRepository _labResultRepository;

    public LabOrderService() {
        _visitService = new VisitService();
        _doctorService = new DoctorService();
        _labTestTypeService = new LabTestTypeService();
        labTestTypeList = new ArrayList<>();
        labOrderList = new ArrayList<>();
    }

    @Override
    public List<LabOrder> findAll() {
        return _labOrderRepository.findAll();

    }

    @Override
    public List<LabOrder> findAll(String status) {
        return null;
    }

    @Override
    public LabOrder findById(int id) {
        return _labOrderRepository.findById(id).orElse(null);

    }

    @Override
    public LabOrder update(LabOrder labOrder1, int visitId, int doctorId,
                           int labTestTypeId) {
        /* update labOrder if it has no result */
        LabOrder labOrder = _labOrderRepository.findById(labOrder1.getLabOrderId()).orElse(null);
        LabOrder labOrder2=new LabOrder();
        if (labOrder != null) {
            labOrder2=toLabOrder(visitId, doctorId,
                    labTestTypeId);
            labOrder2.setLabOrderId(labOrder.getLabOrderId());
            return _labOrderRepository.save(labOrder2);
        }
        return null;

    }

    @Override
    public void deleteById(int id) {
        _labOrderRepository.deleteById(id);
    }

    @Override
    public void delete(LabOrder labOrder) {
        _labOrderRepository.deleteById(labOrder.getLabOrderId());
    }

    @Override
    public void deleteAll(Iterable<LabOrder> labOrders) {
//        labOrders.forEach(labOrderVM -> {
//            this.labOrderList.add(toLabOrder(labOrderVM));
//        });
//        _labOrderRepository.deleteAll(this.labOrderList);
    }

    @Override
    public void deleteAll() {
        _labOrderRepository.deleteAll();
    }

    @Override
    public LabOrder create(int visitId, int doctorId,
                           int labTestTypeId) {


        return _labOrderRepository.save(toLabOrder(visitId, doctorId, labTestTypeId));
    }

    @Override
    public List<LabOrder> createAll(List<LabOrder> labOrderList, int visitId, int doctorId,
                                    int labTestTypeId) {
        LabOrder labOrder = new LabOrder();
        List<LabOrder> labOrderList1 = new ArrayList<>();
        labOrderList.forEach(labOrderVM -> {

            labOrderList1.add(toLabOrder(visitId, doctorId, labTestTypeId));
        });
        return _labOrderRepository.saveAll(labOrderList1);
    }

    public LabOrder toLabOrder(int visitId, int doctorId,
                               int labTestTypeId) {
        LabOrder labOrder = new LabOrder();
        labOrder.setVisit(_visitService.findById(visitId));
        labOrder.setDoctor(_doctorService.findById(doctorId));
        labOrder.setLabTestType(_labTestTypeService.findById(labTestTypeId));
        return labOrder;
    }
}

