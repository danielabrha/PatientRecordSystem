package Services.Implementation;

import Domain.Entity.LabOrder;
import Domain.Entity.LabTestType;
import Domain.Entity.Role;
import Domain.Entity.Symptom;
import Domain.ViewModel.LabOrderViewModel;
import Domain.ViewModel.RoleViewModel;
import Repository.ILabOrderRepository;
import Repository.ISymptomRepository;
import Services.Interface.*;
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
    private ILabTestType _labTestTypeService;

    private List<LabTestType> labTestTypeList;

    @Autowired
    private ILabResultService _labResultService

    public LabOrderService(ILabOrderRepository _labOrderRepository, List<LabOrder> labOrderList,
                           IVisitService _visitService, IDoctorService _doctorService, ILabTestType _labTestTypeService,
                           List<LabTestType> labTestTypeList, ILabResultService _labResultService) {
        this._labOrderRepository = _labOrderRepository;
        this.labOrderList = labOrderList;
        this._visitService = _visitService;
        this._doctorService = _doctorService;
        this._labTestTypeService = _labTestTypeService;
        this.labTestTypeList = labTestTypeList;
        this._labResultService = _labResultService;
    }

    public LabOrderService(){
        labOrderList=new ArrayList<>();
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
        _labOrderRepository.save(toLabOrder(labOrderViewModel));
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
                           int labTestTypeId, int labResultId) {
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        int laborderId;
        LabOrder labOrder = toLabOrder(labOrderViewModel);
        laborderId = labOrder.getLabOrderId();
        labOrder.setVisit(_visitService.findById(visitId));
        labOrder.setDoctor(_doctorService.findById(doctorId));
        labOrder.setLabTestTypeList(_labTestTypeService.findAllLabTests(laborderId));
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
        // Not attribute to set
        return labOrder;
    }
}
