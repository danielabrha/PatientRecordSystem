package Services.Implementation;

import Domain.Entity.Symptom;
import Domain.ViewModel.SymptomViewModel;
import Services.Interface.ISymptomService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SymptomService implements ISymptomService {
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
        return null;
    }

    @Override
    public List<Symptom> createAll(List<SymptomViewModel> listSymptomViewModel) {
        return null;
    }
}
