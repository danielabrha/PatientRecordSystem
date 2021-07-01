package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.DrugOrder;
import com.example.patientrecordsystem.Domain.ViewModel.DrugOrderViewModel;
import com.example.patientrecordsystem.Service.Implementation.DrugOrderService;
import com.example.patientrecordsystem.Service.Interface.IDrugOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DrugOrderController {

    @Autowired
    private JavaMailSender mailSender;

    private IDrugOrderService _drugOrderService;
    private DrugOrder drugOrder;
    private List<DrugOrder> _drugOrderList;
    private DrugOrderViewModel drugOrderViewModel;
    private List<DrugOrderViewModel> _drugOrderViewModelList;

    public DrugOrderController() {
        this._drugOrderService = new DrugOrderService();
        this.drugOrder = new DrugOrder();
        this._drugOrderList = new ArrayList<>();
        this.drugOrderViewModel = new DrugOrderViewModel();
        this._drugOrderViewModelList = new ArrayList<>();
    }
    @PostMapping("DrugOrder/post/data/{visitId}/{doctorId}/{drugId}")
    public DrugOrder postDurg(@PathVariable(value = "visitId") int visitId,
                              @PathVariable(value = "doctorId") int doctorId,
                              @PathVariable(value = "drugId") int drugId,
                              @RequestBody DrugOrderViewModel drugOrderVM){
        return _drugOrderService.create(drugOrderVM,drugId,doctorId,visitId);



    }

    @PostMapping("DrugOrder/post/All/data/")
    public List<DrugOrder> postDrugOrder(@RequestBody List<DrugOrderViewModel> drugOrderVMList){
        return  _drugOrderService.createAll(drugOrderVMList);

    }
    @PutMapping("DrugOrder/update/{visitId}/{doctorId}/{drugId}")
    public DrugOrder updateDrugOrder(@RequestBody DrugOrderViewModel drugOrderVM,
                                     @PathVariable(value = "visitId") int visitId,
                                     @PathVariable(value = "doctorId") int doctorId,
                                     @PathVariable(value = "drugId") int drugId){

        return _drugOrderService.update(drugOrderVM,drugId,doctorId,visitId);

    }
    @GetMapping("/DrugOrder/get/data/{id}")
    public DrugOrder getDrugOrder(@PathVariable(value = "id") int Id) {
        return _drugOrderService.findById(Id);
    }
    @GetMapping("/DrugOrder/get/All/data/")
    public List<DrugOrder> getDrugOrder() {

        String from = "691fa95586-cc12c1@inbox.mailtrap.io";
        String to = "whailu@miu.edu";

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Hello");
        message.setText("This is from PRS");
        mailSender.send(message);

        return _drugOrderService.findAll();
    }

    @DeleteMapping("DrugOrder/delete/{id}")
    public Boolean deleteDrugOrder(@PathVariable int id){
        _drugOrderService.deleteById(id);
        return true;

    }

    @DeleteMapping("DrugOrder/delete/all")
    public Boolean deleteAllDrugOrder(){
        _drugOrderService.deleteAll();
        return true;

    }
}

