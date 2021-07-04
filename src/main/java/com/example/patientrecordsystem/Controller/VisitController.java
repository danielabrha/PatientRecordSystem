package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Service.Implementation.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/Visit")
public class VisitController {

    @Autowired
    private VisitService _visitService;
    private Visit visit;
    private List<Visit> _visitList;

    public VisitController() {
        this._visitService = new VisitService();
        this.visit = new Visit();
        this._visitList = new ArrayList<>();
    }

    @PostMapping("post/data/{patientId}")
    public Visit postVisit(@RequestBody Visit visit,
                           @PathVariable (value = "patientId") int patientId

    ) {
        return _visitService.create(  patientId);

    }

    @PostMapping("post/All/data/{patientId}")
    public List<Visit> postVisits(@RequestBody List<Visit> visitList,
                                  @PathVariable (value = "patientId") int patientId) {
        return  _visitService.createAll(visitList, patientId);
    }

    @GetMapping("get/data/{id}")
    public Visit getVisit(@PathVariable(value = "id") int Id) {
        return _visitService.findById(Id);

    }

    @GetMapping("Visits/get/All/data")
    public List<Visit> getAllVisit() {
        return  _visitService.findAll();

    }

    @PutMapping("update/data")
    private Visit updateVisit(@RequestBody Visit VisitCM) {
        return _visitService.update(VisitCM);
    }

    @DeleteMapping("deleteById/data/{id}")
    private Boolean deleteVisitById(@PathVariable int id) {
        _visitService.deleteById(id);
        return true;
    }

    @DeleteMapping("deleteAll/data")
    private Boolean deleteAllVisit() {
        _visitService.deleteAll();
        return true;
    }
}

