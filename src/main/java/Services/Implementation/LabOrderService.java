package Services.Implementation;

import Domain.Entity.LabOrder;
import Domain.ViewModel.LabOrderViewModel;
import Repository.ILabResultRepository;
import Repository.ILaboratoristRepository;
import Services.Interface.ILabOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LabOrderService implements ILabOrderService {

        
    @Override
    public List<LabOrder> findAll() {
        return null;
    }

    @Override
    public List<LabOrder> findAll(String status) {
        return null;
    }

    @Override
    public LabOrder findById(int id) {
        return null;
    }

    @Override
    public LabOrderViewModel update(LabOrderViewModel labOrderViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(LabOrderViewModel labOrderViewModel) {

    }

    @Override
    public void deleteAll(Iterable<LabOrderViewModel> labOrderViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public LabOrder create(LabOrderViewModel labOrderViewModel) {
        return null;
    }

    @Override
    public List<LabOrder> createAll(List<LabOrderViewModel> listLabOrderViewModel) {
        return null;
    }
}
