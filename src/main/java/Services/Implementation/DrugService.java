package Services.Implementation;

import Domain.Entity.Drug;
import Domain.Entity.Role;
import Domain.Entity.SystemAdmin;
import Domain.ViewModel.DrugViewModel;
import Domain.ViewModel.RoleViewModel;
import Repository.IDrugRepository;
import Services.Interface.IDrugService;
import Services.Interface.ISystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugService implements IDrugService {

    @Autowired
    IDrugRepository _drugRepository;

    @Autowired
    List<Drug> drugList;
    private ISystemAdminService _systemAdminService;

    public DrugService() {
        drugList = new ArrayList<>();
        _systemAdminService = new SystemAdminService();
    }


    @Override
    public List<Drug> findAll() {
        return _drugRepository.findAll();
    }

    @Override
    public List<Drug> findAll(String status) {
        return _drugRepository.findAll();
    }

    @Override
    public Drug findById(int id) {
        return _drugRepository.findById(id).orElse(null);
    }

    @Override
    public Drug update(DrugViewModel drugViewModel,int systemAdminId) {
        Drug previousDrug = _drugRepository.findById(drugViewModel.getDrugId()).orElse(null);
        if (previousDrug != null) {
            previousDrug = toDrug(drugViewModel,systemAdminId);
            previousDrug.setDrugId(drugViewModel.getDrugId());

        }
        return _drugRepository.save(previousDrug);
    }

    @Override
    public void deleteById(int id) {
        _drugRepository.deleteById(id);
    }

    @Override
    public void delete(DrugViewModel drugViewModel) {
        Drug previousDrug = _drugRepository.findById(drugViewModel.getDrugId()).orElse(null);
        if (previousDrug != null) {
            _drugRepository.deleteById(previousDrug.getDrugId());
        }
    }

    @Override
    public void deleteAll(Iterable<DrugViewModel> drugViewModels) {
        drugViewModels.forEach(roleViewModel -> {
            Drug drug = _drugRepository.findById(roleViewModel.getDrugId()).orElse(null);
            if (drug != null)
                _drugRepository.deleteById(drug.getDrugId());
        });
    }

    @Override
    public void deleteAll() {
        _drugRepository.deleteAll();
    }

    @Override
    public Drug create(DrugViewModel drugViewModel, int systemAdminId) {
        Drug drug = toDrug(drugViewModel,systemAdminId);
        return _drugRepository.save(drug);
    }



    @Override
    public List<Drug> createAll(List<DrugViewModel> listDrugViewModel, int systemAdminId) {
        Drug drug = new Drug();
        listDrugViewModel.forEach(roleVM -> {

            this.drugList.add(toDrug(roleVM,systemAdminId));
        });
        return _drugRepository.saveAll(this.drugList);

    }

    public Drug toDrug(DrugViewModel drugViewModel,int systemAdminId) {
        Drug drug = new Drug();
        drug.setSystemAdmin(_systemAdminService.findById(systemAdminId));
        drug.setDrugName(drugViewModel.getDrugName());
        drug.setDrugCode(drugViewModel.getDrugCode());
        return drug;
    }
}
