package Controller;

import Domain.Entity.Symptom;
import Domain.ViewModel.SymptomViewModel;
import Services.Implementation.SymptomService;
import Services.Interface.ISymptomService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SymptomController {
    //    @Autowired
    private ISymptomService _SymptomService;
    //    @Autowired
    private Symptom symptom;
    //    @Autowired
    private SymptomViewModel SymptomVM;
    //    @Autowired
    private List<SymptomViewModel> _listSymptomVM;
    //    @Autowired
    private List<Symptom> _listSymptoms;

    public SymptomController() {
        _SymptomService = new SymptomService();
        symptom = new Symptom();
        _listSymptomVM = new ArrayList<SymptomViewModel>();
        _listSymptoms = new ArrayList<Symptom>();
    }

    @PostMapping("/Symptom/post/data")
    public SymptomViewModel postSymptom(@RequestBody SymptomViewModel SymptomVM) {
        this.symptom = _SymptomService.create(SymptomVM);

        return toSymptomViewModel(this.symptom);
        //return new SymptomViewModel();

    }

    @PostMapping("/Symptom/post/All/data")
    public List<SymptomViewModel> postSymptoms(@RequestBody List<SymptomViewModel> setSymptomVM) {
        this._listSymptoms = _SymptomService.createAll(setSymptomVM);
        return toSetSymptomViewModel(this._listSymptoms);
    }

    @GetMapping("/Symptom/get/data/{id}")
    public SymptomViewModel getSymptom(@PathVariable(value = "id") int Id) {
        this.symptom = _SymptomService.findById(Id);
        return toSymptomViewModel(this.symptom);

    }

    @GetMapping("/Symptoms/get/All/data")
    public List<SymptomViewModel> getAllSymptom() {

//        this._listSymptoms = _SymptomService.findAll();
//        return toSetSymptomViewModel(this._listSymptoms);
        return null;

    }

//	@PutMapping("/Symptom/update/data")
//	private SymptomViewModel updateSymptom(@RequestBody SymptomViewModel SymptomCM) {
//		return toSymptomViewModel(_SymptomService.update(SymptomCM));
//	}

    @DeleteMapping("/Symptom/deleteById/data/{id}")
    private Boolean deleteSymptomById(@PathVariable int id) {
        _SymptomService.deleteById(id);
        return true;
    }

    @DeleteMapping("/Symptom/deleteAll/data")
    private Boolean deleteAllSymptom() {
        _SymptomService.deleteAll();
        return true;
    }

    private SymptomViewModel toSymptomViewModel(Symptom Symptom2) {
        // TODO Auto-generated method stub

        this.SymptomVM = new SymptomViewModel();
        this.SymptomVM.setSymptomViewModel_Id(Symptom2.getSymptomId());
        this.SymptomVM.setSymptomViewModelName(Symptom2.getSymptomName());
        return this.SymptomVM;
    }

    private List<SymptomViewModel> toSetSymptomViewModel(List<Symptom> setSymptom) {
        setSymptom.forEach(Symptom -> {
            this._listSymptomVM.add(toSymptomViewModel(Symptom));
        });
        return this._listSymptomVM;
    }
}
