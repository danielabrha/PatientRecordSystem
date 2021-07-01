package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.LabResult;
import com.example.patientrecordsystem.Domain.ViewModel.LabResultViewModel;
import com.example.patientrecordsystem.Service.Implementation.LabResultService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LabResultController {

    private LabResultService _labResultService;
    private LabResult labResult;
    private List<LabResult> _labResultList;
    private LabResultViewModel labResultViewModel;
    private List<LabResultViewModel> _labResultViewModelList;

    public LabResultController() {
        this._labResultService = new LabResultService();
        this.labResult = new LabResult();
        this._labResultList = new ArrayList<>();
        this.labResultViewModel = new LabResultViewModel();
        this._labResultViewModelList = new ArrayList<>();
    }

    @PostMapping("/LabResult/post/data/{labOrderId}/{laboratoristId}")
    public LabResult postLabResult(@RequestBody LabResultViewModel LabResultVM,
                                   @PathVariable(value = "labOrderId") int labOrderId,
                                   @PathVariable (value = "laboratoristId") int laboratoristId


    ) {
        return _labResultService.create(LabResultVM, labOrderId, laboratoristId);

    }

    @PostMapping("/LabResult/post/All/data/{}/{laboratoristId}/{labTestTypeId}")
    public List<LabResult> postLabResults(@RequestBody List<LabResultViewModel> labResultViewModelList,
                                          @PathVariable (value = "labOrderId") int labOrderId,
                                          @PathVariable (value = "laboratoristId") int laboratoristId) {
        return  _labResultService.createAll(labResultViewModelList, labOrderId, laboratoristId);
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
    private LabResult updateLabResult(@RequestBody LabResultViewModel LabResultCM) {
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

    private LabResultViewModel toLabResultViewModel(LabResult LabResult2) {
        // TODO Auto-generated method stub

        return null;
    }

    private List<LabResultViewModel> toSetLabResultViewModel(List<LabResult> setLabResult) {
        return null;
    }


}

