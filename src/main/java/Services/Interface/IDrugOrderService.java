package Services.Interface;

import Domain.Entity.DrugOrder;
import Domain.ViewModel.DrugOrderViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDrugOrderService {
    public List<DrugOrder> findAll();
    //	public List<DrugOrderViewModel> findAll(int entryid);
    public List<DrugOrder> findAll(String status);
    public DrugOrder findById(int id);
    public DrugOrderViewModel update(DrugOrderViewModel drugOrderViewModel);
    public void deleteById(int id);
    public void delete(DrugOrderViewModel drugOrderViewModel);
    public void deleteAll(Iterable<DrugOrderViewModel> drugOrderViewModels);
    public void deleteAll();
    public DrugOrder create(DrugOrderViewModel drugOrderViewModel);
    public List<DrugOrder> createAll(List<DrugOrderViewModel> listDrugOrderViewModel);
}
