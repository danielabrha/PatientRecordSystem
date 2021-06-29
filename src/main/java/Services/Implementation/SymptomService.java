package Services.Implementation;

import Domain.Entity.Role;
import Domain.Entity.Symptom;
import Domain.ViewModel.RoleViewModel;
import Domain.ViewModel.SymptomViewModel;
import Repository.ISymptomRepository;
import Services.Interface.IDoctorService;
import Services.Interface.ISymptomService;
import Services.Interface.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SymptomService implements ISymptomService {

    @Autowired
    private ISymptomRepository _symptomRepository;

    @Autowired
    private IDoctorService _doctorService;

    @Autowired
    private IVisitService _visitService;

    @Autowired
    private List<Symptom> symptomList;
    public SymptomService(){
        symptomList=new ArrayList<>();
    }

    public SymptomService(IDoctorService _doctorService, IVisitService _visitService) {
        this._doctorService = _doctorService;
        this._visitService = _visitService;
    }

    @Override
    public List<Symptom> findAll() {

        return  _symptomRepository.findAll();
    }

    @Override
    public List<Symptom> findAll(String status) {
        return null;
    }

    @Override
    public Symptom findById(int id) {
        return _symptomRepository.findById(id).orElse(null);
    }

    @Override
    public Symptom update(SymptomViewModel symptomViewModel) {
        _symptomRepository.save(toSymptom(symptomViewModel));
        return toSymptom(symptomViewModel);
    }

    @Override
    public void deleteById(int id) {

        _symptomRepository.deleteById(id);
    }

    @Override
    public void delete(SymptomViewModel symptomViewModel) {

        _symptomRepository.delete(toSymptom(symptomViewModel));
    }

    @Override
    public void deleteAll(Iterable<SymptomViewModel> symptomViewModels) {
        symptomViewModels.forEach(symptomVM -> {
            this.symptomList.add(toSymptom(symptomVM));
        });
        _symptomRepository.deleteAll(this.symptomList);

    }

    @Override
    public void deleteAll() {
        _symptomRepository.deleteAll();
    }

    @Override
    public Symptom create(SymptomViewModel symptomViewModel, int doctorId, int visitId) {
        Symptom symptom = toSymptom(symptomViewModel);
        symptom.setDoctor(_doctorService.findById(doctorId));
        symptom.setVisit(_visitService.findById(visitId));

        return _symptomRepository.save(symptom);
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
