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

    public SymptomService() {
        _doctorService = new DoctorService();
        _visitService = new VisitService();
        symptomList=new ArrayList<>();
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
        return null;
    }

    @Override
    public void deleteById(int id) {

        _symptomRepository.deleteById(id);
    }

    @Override
    public void delete(SymptomViewModel symptomViewModel) {

        _symptomRepository.deleteById(symptomViewModel.getSymptomId());
    }

    @Override
    public void deleteAll(Iterable<SymptomViewModel> symptomViewModels) {
        symptomViewModels.forEach(symptomVM -> {
            _symptomRepository.deleteById(symptomVM.getSymptomId());

        });


    }

    @Override
    public void deleteAll() {
        _symptomRepository.deleteAll();
    }

    @Override
    public Symptom create(SymptomViewModel symptomViewModel, int doctorId, int visitId) {
        Symptom symptom =new Symptom();
        symptom.setSymptomName(symptomViewModel.getSymptomName());
        symptom.setDoctor(_doctorService.findById(doctorId));
        symptom.setVisit(_visitService.findById(visitId));
        return _symptomRepository.save(symptom);
    }

    @Override
    public List<Symptom> createAll(List<SymptomViewModel> symptomViewModelList) {
        // it dont usefull more
        symptomViewModelList.forEach(symptomVM -> {
         //   this.symptomList.add(toSymptom(symptomVM));
        });
        return _symptomRepository.saveAll(this.symptomList);
    }


}
