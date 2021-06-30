package Controller;

import Domain.Entity.Patient;
import Domain.ViewModel.PatientViewModel;
import Services.Implementation.PatientService;
import Services.Interface.IPatientService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientController {

    private IPatientService _labTestTypeService;
    private Patient labTestType;
    private List<Patient> _labTestTypeList;
    private PatientViewModel labTestTypeViewModel;
    private List<PatientViewModel> _labTestTypeViewModelList;

    public PatientController() {
        this._labTestTypeService = new PatientService();
        this.labTestType = new Patient();
        this._labTestTypeList = new ArrayList<>();
        this.labTestTypeViewModel = new PatientViewModel();
        this._labTestTypeViewModelList = new ArrayList<>();
    }
    @PostMapping("Patient/post/data/")
    public Patient postDurg(@RequestBody PatientViewModel labTestTypeVM){
        return _labTestTypeService.create(labTestTypeVM);

    }

    @PostMapping("Patient/post/All/data/")
    public List<Patient> postPatient(@RequestBody List<PatientViewModel> labTestTypeVMList){
        return  _labTestTypeService.createAll(labTestTypeVMList);

    }
    @PutMapping("Patient/update/{patientId}")
    public Patient updatePatient(@RequestBody PatientViewModel labTestTypeVM,@PathVariable (value = "patientId") int patientId){

        return _labTestTypeService.update(labTestTypeVM,patientId);

    }
    @GetMapping("/Patient/get/data/{id}")
    public Patient getPatient(@PathVariable(value = "id") int Id) {
        return _labTestTypeService.findById(Id);
    }
    @GetMapping("/Patient/get/All/data/")
    public List<Patient> getPatient() {

        return _labTestTypeService.findAll();
    }

    @DeleteMapping("Patient/delete/{id}")
    public Boolean deletePatient(@PathVariable int id){
        _labTestTypeService.deleteById(id);
        return true;

    }

    @DeleteMapping("Patient/delete/all")
    public Boolean deleteAllPatient(){
        _labTestTypeService.deleteAll();
        return true;

    }

}
