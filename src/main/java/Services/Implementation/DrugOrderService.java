package Services.Implementation;

import Domain.Entity.Doctor;
import Domain.Entity.DrugOrder;
import Domain.ViewModel.DoctorViewModel;
import Domain.ViewModel.DrugOrderViewModel;
import Repository.IDoctorRepository;
import Repository.IDrugOrderRepository;
import Services.Interface.IDrugOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DrugOrderService implements IDrugOrderService {

    @Autowired
    IDrugOrderRepository _iDrugOrderRepository;

    @Autowired
    List<DrugOrder> drugOrderList;

    @Override
    public List<DrugOrder> findAll() {
        return null;
    }

    @Override
    public List<DrugOrder> findAll(String status) {
        return _iDrugOrderRepository.findAll();
    }

    @Override
    public DrugOrder findById(int id) {
        return _iDrugOrderRepository.findById(id).orElse(null);
    }

    @Override
    public DrugOrderViewModel update(DrugOrderViewModel drugOrderViewModel) {
        DrugOrder drugOrder = _iDrugOrderRepository.findById(drugOrderViewModel.getDurgOrderViewModelId()).orElse(null);
        return null;
    }

    @Override
    public void deleteById(int id) {
        _iDrugOrderRepository.deleteById(id);
    }

    @Override
    public void delete(DrugOrderViewModel drugOrderViewModel) {
        DrugOrder drugOrder = _iDrugOrderRepository.findById(drugOrderViewModel.getDurgOrderViewModelId()).orElse(null);
        if(drugOrder!=null)
            _iDrugOrderRepository.deleteById(drugOrder.getId());
    }

    @Override
    public void deleteAll(Iterable<DrugOrderViewModel> drugOrderViewModels) {
        drugOrderViewModels.forEach(drugOrderViewModel -> {
            DrugOrder drugOrder = _iDrugOrderRepository.findById(drugOrderViewModel.getDurgOrderViewModelId()).orElse(null);
            if (drugOrder!=null)
                _iDrugOrderRepository.deleteById(drugOrder.getId());
        });

    }

    @Override
    public void deleteAll() {
        _iDrugOrderRepository.deleteAll();
    }

    @Override
    public DrugOrder create(DrugOrderViewModel drugOrderViewModel) {
        _iDrugOrderRepository.save(toDrugOrder(drugOrderViewModel));
        return null;
    }

    @Override
    public List<DrugOrder> createAll(List<DrugOrderViewModel> listDrugOrderViewModel) {
        listDrugOrderViewModel.forEach(roleVM -> {
            this.drugOrderList.add(toDrugOrder(roleVM));
        });
        return _iDrugOrderRepository.saveAll(this.drugOrderList);
    }
    public DrugOrder toDrugOrder(DrugOrderViewModel drugOrderViewModel){
        //DrugOrder drugOrder = new DrugOrder();
//        drugOrder.setId(drugOrderViewModel.getDurgOrderViewModelId());
//        drugOrder.setAmount(drugOrderViewModel.getAmount());
//        drugOrder.setDrugList(drugOrderViewModel.getDrugList());
//        drugOrder.setDoctor(drugOrderViewModel.getDoctor());
//        drugOrder.setVisit(drugOrderViewModel.getVisit());
        return null;
    }
}
