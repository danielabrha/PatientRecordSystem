package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import com.example.patientrecordsystem.Service.Implementation.LabTestTypeService;
import com.example.patientrecordsystem.Service.Interface.ILabTestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
//@CrossOrigin(origins="http://localhost:4200")
@RestController
public class LabTestTypeController {
    @Autowired
    private LabTestTypeService _labTestTypeService;
    private LabTestType labTestType;
    private List<LabTestType> _labTestTypeList;

    public LabTestTypeController() {
        this._labTestTypeService = new LabTestTypeService();
        this.labTestType = new LabTestType();
        this._labTestTypeList = new ArrayList<>();
        this.labTestType = new LabTestType();
        this._labTestTypeList = new ArrayList<>();
    }

    @PostMapping("LabTestType/post/data")
//    ,
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LabTestType> postLabTestType(@Valid @RequestBody LabTestType labTestTypeVM){

        LabTestType createdLabTestType = _labTestTypeService.create(labTestTypeVM);
        return new ResponseEntity<LabTestType>(createdLabTestType, HttpStatus.OK);

    }

    @PostMapping("LabTestType/post/All/data")
    public List<LabTestType> postLabTestType(@RequestBody List<LabTestType> labTestTypeVMList){
        return  _labTestTypeService.createAll(labTestTypeVMList);

    }
    @PutMapping("LabTestType/update/{labTestTypeId}")
    public LabTestType updateLabTestType(@RequestBody LabTestType labTestTypeVM,
                                         @PathVariable (value = "labTestTypeId") int labTestTypeId){

        return _labTestTypeService.update(labTestTypeVM);

    }
    @GetMapping("LabTestType/get/data/{id}")
    public LabTestType getLabTestType(@PathVariable(value = "id") int Id) {
        return _labTestTypeService.findById(Id);
    }
    @GetMapping("LabTestType/get/All/data")
    public List<LabTestType> getLabTestType() {

        return _labTestTypeService.findAll();
    }

    @DeleteMapping("LabTestType/delete/{id}")
    public Boolean deleteLabTestType(@PathVariable int id){
        _labTestTypeService.deleteById(id);
        return true;

    }

    @DeleteMapping("LabTestType/delete/all")
    public Boolean deleteAllLabTestType(){
        _labTestTypeService.deleteAll();
        return true;

    }
}
