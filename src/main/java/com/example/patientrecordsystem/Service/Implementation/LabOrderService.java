package com.example.patientrecordsystem.Service.Implementation;




import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import com.example.patientrecordsystem.Domain.ViewModel.LabOrderViewModel;
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
    private IVisitService _visitService;

    @Autowired
    private IDoctorService _doctorService;

    @Autowired
    private ILabTestTypeService _labTestTypeService;

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
    public LabOrder update(LabOrderViewModel labOrderViewModel, int visitId, int doctorId,
                           int labTestTypeId) {
        /* update labOrder if it has no result */
        LabOrder labOrder = new LabOrder();
        labOrder = toLabOrder(visitId, doctorId,
                labTestTypeId);
        labOrder.setLabOrderId(labOrderViewModel.getLabOrderId());

        int labOrderId = labOrderViewModel.getLabOrderId();
        // LabResult labResult = _labResultRepository.findByLabOrderId(labOrderId);
        // if (labResult == null) {
        return _labOrderRepository.save(labOrder);

        //  }
        //   return null;
    }

    @Override
    public void deleteById(int id) {
        _labOrderRepository.deleteById(id);
    }

    @Override
    public void delete(LabOrderViewModel labOrderViewModel) {
        _labOrderRepository.deleteById(labOrderViewModel.getLabOrderId());
    }

    @Override
    public void deleteAll(Iterable<LabOrderViewModel> labOrderViewModels)
    {
//        labOrderViewModels.forEach(labOrderVM -> {
//            this.labOrderList.add(toLabOrder(labOrderVM));
//        });
//        _labOrderRepository.deleteAll(this.labOrderList);
    }

    @Override
    public void deleteAll() {
        _labOrderRepository.deleteAll();
    }

    @Override
    public LabOrder create(LabOrderViewModel labOrderViewModel, int visitId, int doctorId,
                           int labTestTypeId) {

        LabOrder labOrder = new LabOrder();
        labOrder.setVisit(_visitService.findById(visitId));
        labOrder.setDoctor(_doctorService.findById(doctorId));
        labOrder.setLabTestType(_labTestTypeService.findById(labTestTypeId));
        return _labOrderRepository.save(labOrder);
    }

    @Override
    public List<LabOrder> createAll(List<LabOrderViewModel> labOrderViewModelList, int visitId, int doctorId,
                                    int labTestTypeId) {
        LabOrder labOrder = new LabOrder();
        labOrderViewModelList.forEach(labOrderVM -> {

            this.labOrderList.add(toLabOrder(visitId,doctorId, labTestTypeId));
        });
        return _labOrderRepository.saveAll(this.labOrderList);
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

