package Controller;

import Domain.Entity.Doctor;
import Domain.Entity.Symptom;
import Domain.Entity.Symptom;
import Domain.Entity.Visit;
import Domain.ViewModel.SymptomViewModel;
import Domain.ViewModel.SymptomViewModel;
import Services.Implementation.SymptomService;
import Services.Implementation.SymptomService;
import Services.Interface.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SymptomController {

    private SymptomService _symptomService;
    private Symptom symptom;
    private List<Symptom> _symptomList;
    private SymptomViewModel symptomViewModel;
    private List<SymptomViewModel> _symptomViewModelList;

    public SymptomController() {
        this._symptomService = new SymptomService();
        this.symptom = new Symptom();
        this._symptomList = new ArrayList<>();
        this.symptomViewModel = new SymptomViewModel();
        this._symptomViewModelList = new ArrayList<>();
    }

    @PostMapping("/Symptom/post/data/{visitId}/{doctorId}")
    public Symptom postSymptom(@RequestBody SymptomViewModel SymptomVM,
                                 @PathVariable (value = "visitId") int visitId,
                                 @PathVariable (value = "doctorId") int doctorId


    ) {
        return _symptomService.create(SymptomVM, visitId, doctorId);

    }

    @PostMapping("/Symptom/post/All/data/{visitId}/{doctorId}/{labTestTypeId}")
    public List<Symptom> postSymptoms(@RequestBody List<SymptomViewModel> symptomViewModelList,
                                        @PathVariable (value = "visitId") int visitId,
                                        @PathVariable (value = "doctorId") int doctorId) {
        return  _symptomService.createAll(symptomViewModelList, visitId, doctorId);
    }

    @GetMapping("/Symptom/get/data/{id}")
    public Symptom getSymptom(@PathVariable(value = "id") int Id) {
        return _symptomService.findById(Id);

    }

    @GetMapping("/Symptoms/get/All/data")
    public List<Symptom> getAllSymptom() {
        return  _symptomService.findAll();

    }

    @PutMapping("/Symptom/update/data")
    private Symptom updateSymptom(@RequestBody SymptomViewModel SymptomCM) {
        return _symptomService.update(SymptomCM);
    }

    @DeleteMapping("/Symptom/deleteById/data/{id}")
    private Boolean deleteSymptomById(@PathVariable int id) {
        _symptomService.deleteById(id);
        return true;
    }

    @DeleteMapping("/Symptom/deleteAll/data")
    private Boolean deleteAllSymptom() {
        _symptomService.deleteAll();
        return true;
    }

    private SymptomViewModel toSymptomViewModel(Symptom Symptom2) {
        // TODO Auto-generated method stub

        return null;
    }

    private List<SymptomViewModel> toSetSymptomViewModel(List<Symptom> setSymptom) {
        return null;
    }
}
