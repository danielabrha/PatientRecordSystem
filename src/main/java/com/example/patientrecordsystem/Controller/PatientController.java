package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.Patient;
import com.example.patientrecordsystem.Domain..Patient;
import com.example.patientrecordsystem.Service.Implementation.PatientService;
import com.example.patientrecordsystem.Service.Interface.IPatientService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientController {

    private IPatientService _patientService;
    private Patient patientService;
    private List<Patient> _patientServiceList;
  
    public PatientController() {
        this._patientService = new PatientService();
        this.patientService = new Patient();
        this._patientServiceList = new ArrayList<>();
        
    }
    @PostMapping("Patient/post/data/")
    public Patient postPatient(@RequestBody Patient patient){
        return _patientService.create(patient);

    }

    @PostMapping("Patient/post/All/data/")
    public List<Patient> postPatient(@RequestBody List<Patient> patientList){
        return  _patientService.createAll(patientList);

    }
    @PutMapping("Patient/update/{patientId}")
    public Patient updatePatient(@RequestBody Patient patient,@PathVariable(value = "patientId") int patientId){

        return _patientService.update(patient,patientId);

    }
    @GetMapping("/Patient/get/data/{id}")
    public Patient getPatient(@PathVariable(value = "id") int Id) {
        return _patientService.findById(Id);
    }
    @GetMapping("/Patient/get/All/data/")
    public List<Patient> getPatient() {

        return _patientService.findAll();
    }

    @DeleteMapping("Patient/delete/{id}")
    public Boolean deletePatient(@PathVariable int id){
        _patientService.deleteById(id);
        return true;

    }

    @DeleteMapping("Patient/delete/all")
    public Boolean deleteAllPatient(){
        _patientService.deleteAll();
        return true;

    }

}

