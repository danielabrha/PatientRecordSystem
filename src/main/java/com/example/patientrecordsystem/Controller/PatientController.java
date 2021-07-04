package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.Patient;
import com.example.patientrecordsystem.Service.Implementation.PatientService;
import com.example.patientrecordsystem.Service.Interface.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/Patient")
public class PatientController {
    @Autowired
    private PatientService _patientService;
    private Patient patientService;
    private List<Patient> _patientServiceList;
  
    public PatientController() {
        this._patientService = new PatientService();
        this.patientService = new Patient();
        this._patientServiceList = new ArrayList<>();
        
    }

    @PostMapping("post/data")

    public ResponseEntity<Patient> postPatient(@Valid @RequestBody Patient patient)
    {
        Patient createdPatient = _patientService.create(patient);
        return new ResponseEntity<Patient>(createdPatient, HttpStatus.OK);
    }

    @PostMapping("post/All/data")
    public List<Patient> postPatient(@RequestBody List<Patient> patientList){
        return  _patientService.createAll(patientList);

    }
    @PutMapping("update/{patientId}")
    public Patient updatePatient(@RequestBody Patient patient,@PathVariable(value = "patientId") int patientId){

        return _patientService.update(patient,patientId);

    }
    @GetMapping("get/data/{id}")
    public Patient getPatient(@PathVariable(value = "id") int Id) {
        return _patientService.findById(Id);
    }
    @GetMapping("get/All/data")
    public List<Patient> getPatient() {

        return _patientService.findAll();
    }

    @DeleteMapping("delete/{id}")
    public Boolean deletePatient(@PathVariable int id){
        _patientService.deleteById(id);
        return true;

    }

    @DeleteMapping("delete/all")
    public Boolean deleteAllPatient(){
        _patientService.deleteAll();
        return true;

    }

}

