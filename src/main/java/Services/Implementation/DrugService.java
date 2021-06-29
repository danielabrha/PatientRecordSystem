package Services.Implementation;

import Domain.Entity.Drug;
import Domain.Entity.Role;
import Domain.ViewModel.DrugViewModel;
import Domain.ViewModel.RoleViewModel;
import Repository.IDrugRepository;
import Services.Interface.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugService implements IDrugService {

    @Autowired
    IDrugRepository _iDrugRepository;

    @Autowired
    List<Drug> drugList;

    public DrugService() {
        drugList = new ArrayList<>();
    }


    @Override
    public List<Drug> findAll() {
        return null;
    }

    @Override
    public List<Drug> findAll(String status) {
        return _iDrugRepository.findAll();
    }

    @Override
    public Drug findById(int id) {
        return _iDrugRepository.findById(id).orElse(null);
    }

    @Override
    public Drug update(DrugViewModel drugViewModel) {
        Drug previousDrug = _iDrugRepository.findById(drugViewModel.getdrugViewModelId()).orElse(null);
        if (previousDrug != null) {
            previousDrug = toDrug(drugViewModel);

        }
        return _iDrugRepository.save(previousDrug);
    }

    @Override
    public void deleteById(int id) {
        _iDrugRepository.deleteById(id);
    }

    @Override
    public void delete(DrugViewModel drugViewModel) {
        Drug previousDrug = _iDrugRepository.findById(drugViewModel.getdrugViewModelId()).orElse(null);
        if (previousDrug != null){
            _iDrugRepository.deleteById(previousDrug.getDrugId());
        }
    }

    @Override
    public void deleteAll(Iterable<DrugViewModel> drugViewModels) {
        drugViewModels.forEach(roleViewModel -> {
            Drug drug = _iDrugRepository.findById(roleViewModel.getdrugViewModelId()).orElse(null);
            if (drug!=null)
                _iDrugRepository.deleteById(drug.getDrugId());
        });
    }

    @Override
    public void deleteAll() {
        _iDrugRepository.deleteAll();
    }

    @Override
    public Drug create(DrugViewModel drugViewModel) {
        return null;
    }

    @Override
    public List<Drug> createAll(List<DrugViewModel> listDrugViewModel) {

        listDrugViewModel.forEach(roleVM -> {
            this.drugList.add(toDrug(roleVM));
        });
        return _iDrugRepository.saveAll(this.drugList);

    }

    public Drug toDrug(DrugViewModel drugViewModel) {
        Drug drug = new Drug();
        drug.setDrugName(drugViewModel.getDrugName());
        drug.setDrugCode(drugViewModel.getDrugCode());
        drug.setDrugId(drugViewModel.getdrugViewModelId());
        return drug;
    }
}
