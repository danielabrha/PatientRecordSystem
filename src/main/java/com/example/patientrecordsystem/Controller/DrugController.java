package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.Drug;
import com.example.patientrecordsystem.Service.Implementation.DrugService;
import com.example.patientrecordsystem.Service.Interface.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RestController
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
    @PostMapping("Drug/post/data")
    public Drug postDurg(@RequestBody Drug drugVM){
        return _drugService.create(drugVM);

    }

    @PostMapping("Drug/post/All/data")
    public List<Drug> postDrug(@RequestBody List<Drug> drugVMList){
        return  _drugService.createAll(drugVMList);

    }
    @PutMapping("Drug/update")
    public Drug updateDrug(@RequestBody Drug drugVM){

        return _drugService.update(drugVM);

    }
    @GetMapping("Drug/get/data/{id}")
    public Drug getDrug(@PathVariable(value = "id") int Id) {
        return _drugService.findById(Id);
    }
    @GetMapping("Drug/get/All/data")
    public List<Drug> getDrug() {

        return _drugService.findAll();
    }

    @DeleteMapping("Drug/delete/{id}")
    public Boolean deleteDrug(@PathVariable int id){
        _drugService.deleteById(id);
        return true;

    }

    @DeleteMapping("Drug/delete/all")
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
