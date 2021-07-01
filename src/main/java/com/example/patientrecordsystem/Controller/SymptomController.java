package com.example.patientrecordsystem.Controller;


import com.example.patientrecordsystem.Domain.Entity.Symptom;
import com.example.patientrecordsystem.Service.Implementation.SymptomService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SymptomController {

    private SymptomService _symptomService;
    private Symptom symptom;
    private List<Symptom> _symptomList;

    public SymptomController() {
        this._symptomService = new SymptomService();
        this.symptom = new Symptom();
        this._symptomList = new ArrayList<>();
        
    }

    @PostMapping("/Symptom/post/data/{visitId}/{doctorId}")
    public Symptom postSymptom(@RequestBody Symptom symptom,
                               @PathVariable(value = "visitId") int visitId,
                               @PathVariable (value = "doctorId") int doctorId


    ) {
        return _symptomService.create(symptom, visitId, doctorId);

    }

    @PostMapping("/Symptom/post/All/data/{visitId}/{doctorId}/{labTestTypeId}")
    public List<Symptom> postSymptoms(@RequestBody List<Symptom> symptomList,
                                      @PathVariable (value = "visitId") int visitId,
                                      @PathVariable (value = "doctorId") int doctorId) {
        return  _symptomService.createAll(symptomList, visitId, doctorId);
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
    private Symptom updateSymptom(@RequestBody Symptom symptom) {
        return _symptomService.update(symptom);
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


}
