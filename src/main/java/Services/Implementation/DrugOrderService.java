package Services.Implementation;

import Domain.Entity.Doctor;
import Domain.Entity.Drug;
import Domain.Entity.DrugOrder;
import Domain.Entity.Visit;
import Domain.ViewModel.DoctorViewModel;
import Domain.ViewModel.DrugOrderViewModel;
import Repository.IDoctorRepository;
import Repository.IDrugOrderRepository;
import Services.Interface.IDoctorService;
import Services.Interface.IDrugOrderService;
import Services.Interface.IDrugService;
import Services.Interface.IVisitService;
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
    private IVisitService _visitService;
    @Autowired
    private IDoctorService _doctorService;
    @Autowired
    private IDrugService _drugService;

    public DrugOrderService() {
        _visitService = new VisitService();
        _doctorService = new DoctorService();
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
    public DrugOrder update(DrugOrderViewModel drugOrderViewModel, int drugId, int doctorId, int visitId) {
        DrugOrder drugOrder = _drugOrderRepository.findById(drugOrderViewModel.getDrugOrderId()).orElse(null);

        return _drugOrderRepository.save( toDrugOrder(drugOrderViewModel, drugId, doctorId, visitId, drugOrder));
    }

    @Override
    public void deleteById(int id) {
        _drugOrderRepository.deleteById(id);
    }

    @Override
    public void delete(DrugOrderViewModel drugOrderViewModel) {
        DrugOrder drugOrder = _drugOrderRepository.findById(drugOrderViewModel.getDrugOrderId()).orElse(null);
        if (drugOrder != null)
            _drugOrderRepository.deleteById(drugOrder.getDrugOrderId());
    }

    @Override
    public void deleteAll(Iterable<DrugOrderViewModel> drugOrderViewModels) {
        drugOrderViewModels.forEach(drugOrderViewModel -> {
            DrugOrder drugOrder = _drugOrderRepository.findById(drugOrderViewModel.getDrugOrderId()).orElse(null);
            if (drugOrder != null)
                _drugOrderRepository.deleteById(drugOrder.getDrugOrderId());
        });

    }

    @Override
    public void deleteAll() {
        _drugOrderRepository.deleteAll();
    }

    @Override
    public DrugOrder create(DrugOrderViewModel drugOrderViewModel, int drugId, int doctorId, int visitId) {
        DrugOrder drugOrder =new DrugOrder();
        return _drugOrderRepository.save( toDrugOrder(drugOrderViewModel, drugId, doctorId, visitId, drugOrder));
    }

    private DrugOrder toDrugOrder(DrugOrderViewModel drugOrderViewModel, int drugId, int doctorId, int visitId, DrugOrder drugOrder) {
        Doctor doctor =_doctorService.findById(doctorId);
        Visit visit=_visitService.findById(visitId);
        Drug drug=_drugService.findById(drugId);
        drugOrder.setDrug(drug);
        drugOrder.setAmount(drugOrderViewModel.getAmount());
        drugOrder.setDoctor(doctor);
        drugOrder.setVisit(visit);
        return drugOrder;
    }

    @Override
    public List<DrugOrder> createAll(List<DrugOrderViewModel> listDrugOrderViewModel) {
//        listDrugOrderViewModel.forEach(roleVM -> {
//            this.drugOrderList.add(toDrugOrder(roleVM));
//        });
//        return _drugOrderRepository.saveAll(this.drugOrderList);
        return null;
    }


}
