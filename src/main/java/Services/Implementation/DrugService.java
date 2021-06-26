package Services.Implementation;

import Domain.Entity.Drug;
import Domain.ViewModel.DrugViewModel;
import Services.Interface.IDrugService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DrugService implements IDrugService {
    @Override
    public List<Drug> findAll() {
        return null;
    }

    @Override
    public List<Drug> findAll(String status) {
        return null;
    }

    @Override
    public Drug findById(int id) {
        return null;
    }

    @Override
    public DrugViewModel update(DrugViewModel drugViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(DrugViewModel drugViewModel) {

    }

    @Override
    public void deleteAll(Iterable<DrugViewModel> drugViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Drug create(DrugViewModel drugViewModel) {
        return null;
    }

    @Override
    public List<Drug> createAll(List<DrugViewModel> listDrugViewModel) {
        return null;
    }
}
