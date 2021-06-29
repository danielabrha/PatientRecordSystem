package Services.Implementation;

import Domain.Entity.DrugOrder;
import Domain.ViewModel.DrugOrderViewModel;
import Services.Interface.IDrugOrderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DrugOrderService implements IDrugOrderService {
    @Override
    public List<DrugOrder> findAll() {
        return null;
    }

    @Override
    public List<DrugOrder> findAll(String status) {
        return null;
    }

    @Override
    public DrugOrder findById(int id) {
        return null;
    }

    @Override
    public DrugOrderViewModel update(DrugOrderViewModel drugOrderViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(DrugOrderViewModel drugOrderViewModel) {

    }

    @Override
    public void deleteAll(Iterable<DrugOrderViewModel> drugOrderViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public DrugOrder create(DrugOrderViewModel drugOrderViewModel) {
        return null;
    }

    @Override
    public List<DrugOrder> createAll(List<DrugOrderViewModel> listDrugOrderViewModel) {
        return null;
    }
}
