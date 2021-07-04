package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.Drug;
import com.example.patientrecordsystem.Service.Implementation.DrugService;
import com.example.patientrecordsystem.Service.Interface.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/Drug")
public class DrugController {
@Autowired
    private DrugService _drugService;
    private Drug drug;
    private List<Drug> _drugList;

    public DrugController() {
        this._drugService = new DrugService();
        this.drug = new Drug();
        this._drugList = new ArrayList<>();
        this.drug = new Drug();
        this._drugList = new ArrayList<>();
    }

    @PostMapping("post/data")
    public ResponseEntity<Drug> postDurg(@Valid @RequestBody Drug drugVM){
        Drug createdDrug = _drugService.create(drugVM);
        return new ResponseEntity<Drug> (createdDrug, HttpStatus.OK);

    }

    @PostMapping("post/All/data")
    public List<Drug> postDrug(@RequestBody List<Drug> drugVMList){
        return  _drugService.createAll(drugVMList);

    }
    @PutMapping("update")
    public Drug updateDrug(@RequestBody Drug drugVM){

        return _drugService.update(drugVM);

    }
    @GetMapping("get/data/{id}")
    public Drug getDrug(@PathVariable(value = "id") int Id) {
        return _drugService.findById(Id);
    }
    @GetMapping("get/All/data")
    public List<Drug> getDrug() {

        return _drugService.findAll();
    }

    @DeleteMapping("delete/{id}")
    public Boolean deleteDrug(@PathVariable int id){
        _drugService.deleteById(id);
        return true;

    }

    @DeleteMapping("delete/all")
    public Boolean deleteAllDrug(){
        _drugService.deleteAll();
        return true;

    }

    private List<Drug> toDrug(List<Drug> drugList){
        return null;
    }

//    private Drug toDrug(Drug drug) {
//        Drug drugVM=new Drug();
//        List<DrugOrder> drugOrderList=new ArrayList<>();
//        DrugOrder drugOrder=new DrugOrder();
//        drugVM.setDrugId(drug.getDrugId());
//        drugVM.setDrugCode(drug.getDrugCode());
//        List<DrugOrder> drugOrderList= drug.getDrugOrderList();
//        drugOrderList.forEach(drugOrder -> {
//            drugOrder.setDrugOrderId(drugOrder.getDrugOrderId());
//            drugOrder.setAmount(drugOrder.getAmount());
//            drugOrder.setVisit(drugOrder.getVisit());
//            drugOrder.setDrug(drugOrder.getDrug());
//            drugOrder.setDoctor(drugOrder.getDoctor());
//            drugOrderList.add(drugOrder);
//        });
//        drugVM.setDrugOrderList(drugOrderList);
//        SystemAdmin systemAdmin=drug.getSystemAdmin();
//        SystemAdmin systemAdmin=new SystemAdmin();
//        systemAdmin.setSystemAdminId(systemAdmin.getSystemAdminId());
//        systemAdmin.setUser(systemAdmin.getUser());
//        drugVM.setSystemAdmin(systemAdmin);
//        return  drugVM;
//    }
}
