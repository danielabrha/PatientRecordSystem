package Services.Implementation;

import Domain.Entity.Role;
import Domain.Entity.Symptom;
import Domain.ViewModel.RoleViewModel;
import Domain.ViewModel.SymptomViewModel;
import Repository.ISymptomRepository;
import Services.Interface.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SymptomService implements ISymptomService {

    @Autowired
    private ISymptomRepository _symptomRepository;
    @Autowired
    private List<Symptom> symptomList;
    public SymptomService(){
        symptomList=new ArrayList<>();
    }
    
    @Override
    public List<Symptom> findAll() {
        return null;
    }

    @Override
    public List<Symptom> findAll(String status) {
        return null;
    }

    @Override
    public Symptom findById(int id) {
        return null;
    }

    @Override
    public SymptomViewModel update(SymptomViewModel symptomViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(SymptomViewModel symptomViewModel) {

    }

    @Override
    public void deleteAll(Iterable<SymptomViewModel> symptomViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Symptom create(SymptomViewModel symptomViewModel) {
        return _symptomRepository.save(toSymptom(symptomViewModel));
    }

    @Override
    public List<Symptom> createAll(List<SymptomViewModel> symptomViewModelList) {
        symptomViewModelList.forEach(symptomVM -> {
            this.symptomList.add(toSymptom(symptomVM));
        });
        return _symptomRepository.saveAll(this.symptomList);
    }

    public Symptom toSymptom(SymptomViewModel symptomViewModel) {
        Symptom symptom = new Symptom();
        symptom.setSymptomName(symptomViewModel.getSymptomViewModelName());
        return symptom;
    }
}
