package Controller;

import Domain.Entity.Visit;
import Domain.ViewModel.VisitViewModel;
import Services.Implementation.VisitService;
import Services.Implementation.VisitService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VisitController {

    private VisitService _visitService;
    private Visit visit;
    private List<Visit> _visitList;
    private VisitViewModel visitViewModel;
    private List<VisitViewModel> _visitViewModelList;

    public VisitController() {
        this._visitService = new VisitService();
        this.visit = new Visit();
        this._visitList = new ArrayList<>();
        this.visitViewModel = new VisitViewModel();
        this._visitViewModelList = new ArrayList<>();
    }

    @PostMapping("/Visit/post/data/{receptionistId}/{patientId}")
    public Visit postVisit(@RequestBody VisitViewModel VisitVM,
                               @PathVariable(value = "receptionistId") int receptionistId,
                               @PathVariable (value = "patientId") int patientId

    ) {
        return _visitService.create(VisitVM, receptionistId, patientId);

    }

    @PostMapping("/Visit/post/All/data/{receptionistId}/{patientId}/{labTestTypeId}")
    public List<Visit> postVisits(@RequestBody List<VisitViewModel> visitViewModelList,
                                      @PathVariable (value = "receptionistId") int receptionistId,
                                      @PathVariable (value = "patientId") int patientId) {
        return  _visitService.createAll(visitViewModelList, receptionistId, patientId);
    }

    @GetMapping("/Visit/get/data/{id}")
    public Visit getVisit(@PathVariable(value = "id") int Id) {
        return _visitService.findById(Id);

    }

    @GetMapping("/Visits/get/All/data")
    public List<Visit> getAllVisit() {
        return  _visitService.findAll();

    }

    @PutMapping("/Visit/update/data")
    private Visit updateVisit(@RequestBody VisitViewModel VisitCM) {
        return _visitService.update(VisitCM);
    }

    @DeleteMapping("/Visit/deleteById/data/{id}")
    private Boolean deleteVisitById(@PathVariable int id) {
        _visitService.deleteById(id);
        return true;
    }

    @DeleteMapping("/Visit/deleteAll/data")
    private Boolean deleteAllVisit() {
        _visitService.deleteAll();
        return true;
    }

    private VisitViewModel toVisitViewModel(Visit Visit2) {
        // TODO Auto-generated method stub

        return null;
    }

    private List<VisitViewModel> toSetVisitViewModel(List<Visit> setVisit) {
        return null;
    }
}
