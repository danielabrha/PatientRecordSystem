package Services.Interface;

import Domain.Entity.Symptom;
import Domain.ViewModel.SymptomViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISymptomService {
    public List<Symptom> findAll();
    //	public List<SymptomViewModel> findAll(int entryid);
    public List<Symptom> findAll(String status);
    public Symptom findById(int id);
    public Symptom update(SymptomViewModel symptomViewModel);
    public void deleteById(int id);
    public void delete(SymptomViewModel symptomViewModel);
    public void deleteAll(Iterable<SymptomViewModel> symptomViewModels);
    public void deleteAll();
    public Symptom create(SymptomViewModel symptomViewModel, int doctorId, int visitId);
    public List<Symptom> createAll(List<SymptomViewModel> listSymptomViewModel);
}
