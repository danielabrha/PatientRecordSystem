package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.LabResult;
import com.example.patientrecordsystem.Service.Implementation.LabResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LabResultController {
    @Autowired
    private LabResultService _labResultService;
    private LabResult labResult;
    private List<LabResult> _labResultList;

    public LabResultController() {
        this._labResultService = new LabResultService();
        this.labResult = new LabResult();
        this._labResultList = new ArrayList<>();
        this.labResult = new LabResult();
        this._labResultList = new ArrayList<>();
    }

    @PostMapping("/LabResult/post/data/{labOrderId}")
    public ResponseEntity<LabResult> postLabResult(@Valid @RequestBody LabResult LabResultVM,
                                                  @PathVariable(value = "labOrderId") int labOrderId
    ) {
        LabResult createdLabResult = _labResultService.create(LabResultVM, labOrderId);
        return new ResponseEntity<LabResult>(createdLabResult, HttpStatus.CREATED);
    }

    @PostMapping("/LabResult/post/All/data/{}/{labTestTypeId}")
    public List<LabResult> postLabResults(@RequestBody List<LabResult> labResultList,
                                          @PathVariable (value = "labOrderId") int labOrderId) {
        return  _labResultService.createAll(labResultList, labOrderId);
    }

    @GetMapping("/LabResult/get/data/{id}")
    public LabResult getLabResult(@PathVariable(value = "id") int Id) {
        return _labResultService.findById(Id);

    }

    @GetMapping("/LabResults/get/All/data")
    public List<LabResult> getAllLabResult() {
        return  _labResultService.findAll();

    }

    @PutMapping("/LabResult/update/data")
    private LabResult updateLabResult(@RequestBody LabResult LabResultCM) {
        return _labResultService.update(LabResultCM);
    }

    @DeleteMapping("/LabResult/deleteById/data/{id}")
    private Boolean deleteLabResultById(@PathVariable int id) {
        _labResultService.deleteById(id);
        return true;
    }

    @DeleteMapping("/LabResult/deleteAll/data")
    private Boolean deleteAllLabResult() {
        _labResultService.deleteAll();
        return true;
    }

    private LabResult toLabResult(LabResult LabResult2) {
        // TODO Auto-generated method stub

        return null;
    }

    private List<LabResult> toSetLabResult(List<LabResult> setLabResult) {
        return null;
    }


}

