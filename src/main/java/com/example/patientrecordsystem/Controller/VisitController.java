package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Service.Implementation.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VisitController {

    @Autowired
    private VisitService _visitService;
    private Visit visit;
    private List<Visit> _visitList;

    public VisitController() {
        this._visitService = new VisitService();
        this.visit = new Visit();
        this._visitList = new ArrayList<>();
        this.visit = new Visit();
        this._visitList = new ArrayList<>();
    }

    @PostMapping("/Visit/post/data/{receptionistId}/{patientId}")
    public Visit postVisit(@RequestBody Visit VisitVM,
                           @PathVariable(value = "receptionistId") int receptionistId,
                           @PathVariable (value = "patientId") int patientId

    ) {
        return _visitService.create(VisitVM, receptionistId, patientId);

    }

    @PostMapping("/Visit/post/All/data/{receptionistId}/{patientId}")
    public List<Visit> postVisits(@RequestBody List<Visit> visitList,
                                  @PathVariable (value = "receptionistId") int receptionistId,
                                  @PathVariable (value = "patientId") int patientId) {
        return  _visitService.createAll(visitList, receptionistId, patientId);
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
    private Visit updateVisit(@RequestBody Visit VisitCM) {
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

    private Visit toVisit(Visit Visit2) {
        // TODO Auto-generated method stub

        return null;
    }

    private List<Visit> toSetVisit(List<Visit> setVisit) {
        return null;
    }
}

