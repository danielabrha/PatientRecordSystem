package com.example.patientrecordsystem.Controller;


import com.example.patientrecordsystem.Domain.Entity.Symptom;
import com.example.patientrecordsystem.Service.Implementation.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/Symptom")
public class SymptomController {
@Autowired
    private SymptomService _symptomService;
    private Symptom symptom;
    private List<Symptom> _symptomList;

    public SymptomController() {
        this._symptomService = new SymptomService();
        this.symptom = new Symptom();
        this._symptomList = new ArrayList<>();
        
    }

    @PostMapping("post/data/{visitId}")
    public Symptom postSymptom(@RequestBody Symptom symptom,
                               @PathVariable(value = "visitId") int visitId


    ) {
        return _symptomService.create(symptom, visitId);

    }

    @PostMapping("post/All/data/{visitId}/{labTestTypeId}")
    public List<Symptom> postSymptoms(@RequestBody List<Symptom> symptomList,
                                      @PathVariable (value = "visitId") int visitId) {
        return  _symptomService.createAll(symptomList, visitId);
    }

    @GetMapping("get/data/{id}")
    public Symptom getSymptom(@PathVariable(value = "id") int Id) {
        return _symptomService.findById(Id);

    }

    @GetMapping("Symptoms/get/All/data")
    public List<Symptom> getAllSymptom() {
        return  _symptomService.findAll();

    }

    @PutMapping("update/data/symptomId")
    private Symptom updateSymptom(@RequestBody Symptom symptom,@PathVariable(value = "symptomId") int symptomId) {
        return _symptomService.update(symptom,symptomId);
    }

    @DeleteMapping("deleteById/data/{symptomId}")
    private Boolean deleteSymptomById(@PathVariable(value = "symptomId") int symptomId) {
        _symptomService.deleteById(symptomId);
        return true;
    }

    @DeleteMapping("deleteAll/data")
    private Boolean deleteAllSymptom() {
        _symptomService.deleteAll();
        return true;
    }


}
