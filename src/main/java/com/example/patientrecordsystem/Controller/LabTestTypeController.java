package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.LabTestType;
import com.example.patientrecordsystem.Service.Implementation.LabTestTypeService;
import com.example.patientrecordsystem.Service.Interface.ILabTestTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LabTestTypeController {
    private ILabTestTypeService _labTestTypeService;
    private LabTestType labTestType;
    private List<LabTestType> _labTestTypeList;

    public LabTestTypeController() {
        this._labTestTypeService = new LabTestTypeService();
        this.labTestType = new LabTestType();
        this._labTestTypeList = new ArrayList<>();
        this.labTestType = new LabTestType();
        this._labTestTypeList = new ArrayList<>();
    }
    @PostMapping("LabTestType/post/data/{systemAdminId}")
    public LabTestType postDurg(@RequestBody LabTestType labTestTypeVM, @PathVariable(value = "systemAdminId") int systemAdminId){
        return _labTestTypeService.create(labTestTypeVM,systemAdminId);

    }

    @PostMapping("LabTestType/post/All/data/{systemAdminId}")
    public List<LabTestType> postLabTestType(@RequestBody List<LabTestType> labTestTypeVMList,@PathVariable (value = "systemAdminId") int systemAdminId){
        return  _labTestTypeService.createAll(labTestTypeVMList,systemAdminId);

    }
    @PutMapping("LabTestType/update/{systemAdminId}")
    public LabTestType updateLabTestType(@RequestBody LabTestType labTestTypeVM,@PathVariable (value = "systemAdminId") int systemAdminId){

        return _labTestTypeService.update(labTestTypeVM,systemAdminId);

    }
    @GetMapping("/LabTestType/get/data/{id}")
    public LabTestType getLabTestType(@PathVariable(value = "id") int Id) {
        return _labTestTypeService.findById(Id);
    }
    @GetMapping("/LabTestType/get/All/data/")
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
