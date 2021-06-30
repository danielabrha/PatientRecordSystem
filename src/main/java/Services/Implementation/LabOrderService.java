package Services.Implementation;

import Domain.Entity.*;
import Domain.Entity.LabTestType;
import Domain.ViewModel.LabOrderViewModel;

import Repository.ILabOrderRepository;
import Repository.ILabResultRepository;
import Services.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import Services.Interface.ILabOrderService;
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
    private ILabTestType _labTestTypeService;

    private List<LabTestType> labTestTypeList;

    @Autowired
    private ILabResultService _labResultService;

    @Autowired
    private ILabResultRepository _labResultRepository;

    public LabOrderService(IVisitService _visitService, IDoctorService _doctorService,
                           ILabTestType _labTestTypeService, List<LabTestType> labTestTypeList) {
        this._visitService = _visitService;
        this._doctorService = _doctorService;
        this._labTestTypeService = _labTestTypeService;
        this.labTestTypeList = labTestTypeList;
    }

    @Override
    public List<LabOrder> findAll() {
       return  _labOrderRepository.findAll();

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
    public LabOrder update(LabOrderViewModel labOrderViewModel) {
        //update labOrder if it has no result
        LabOrder labOrder = toLabOrder(labOrderViewModel);
        int labOrderId = labOrder.getLabOrderId();
        LabResult labResult = _labResultRepository.findByLabOrderId(labOrderId);
        if(labResult == null){
            _labOrderRepository.save(labOrder);

        }
        return toLabOrder(labOrderViewModel);
    }

    @Override
    public void deleteById(int id) {
        _labOrderRepository.deleteById(id);
    }

    @Override
    public void delete(LabOrderViewModel labOrderViewModel) {
        _labOrderRepository.delete(toLabOrder(labOrderViewModel));
    }

    @Override
    public void deleteAll(Iterable<LabOrderViewModel> labOrderViewModels) {
        labOrderViewModels.forEach(labOrderVM -> {
            this.labOrderList.add(toLabOrder(labOrderVM));
        });
        _labOrderRepository.deleteAll(this.labOrderList);
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
    public List<LabOrder> createAll(List<LabOrderViewModel> listLabOrderViewModel) {
        listLabOrderViewModel.forEach(labOrderVM -> {
            this.labOrderList.add(toLabOrder(labOrderVM));
        });
        return _labOrderRepository.saveAll(this.labOrderList);
    }

    public LabOrder toLabOrder(LabOrderViewModel labOrderViewModel) {
        LabOrder labOrder = new LabOrder();
        return labOrder;
    }
}
