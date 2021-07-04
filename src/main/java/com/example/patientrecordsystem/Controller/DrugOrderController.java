package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.*;
import com.example.patientrecordsystem.Service.Implementation.DoctorService;
import com.example.patientrecordsystem.Service.Implementation.DrugOrderService;
import com.example.patientrecordsystem.Service.Implementation.DrugService;
import com.example.patientrecordsystem.Service.Implementation.VisitService;
import com.example.patientrecordsystem.Service.Interface.IDrugOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/DrugOrder")
public class DrugOrderController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VisitService _visitService;

    @Autowired
    private DoctorService _doctorService;

    @Autowired
    private DrugService _drugService;

    @Autowired
    private DrugOrderService _drugOrderService;
    private DrugOrder drugOrder;
    private List<DrugOrder> _drugOrderList;

    public DrugOrderController() {
        this._drugOrderService = new DrugOrderService();
        this.drugOrder = new DrugOrder();
        this._drugOrderList = new ArrayList<>();
    
    }
    @PostMapping("post/data/{visitId}/{drugId}")
    public DrugOrder postDurg(@PathVariable(value = "visitId") int visitId,
                              @PathVariable(value = "drugId") int drugId,
                              @RequestBody DrugOrder drugOrder){
        // send email notification to patient;

        Visit visit = _visitService.findById(visitId);
        Patient patient = visit.getPatient();
        String fullName = patient.getfName() + " " + patient.getmName() + " " + patient.getlName();
        String age = patient.getDateOfBirth();
        String phoneNumber = patient.getPhoneNumber();
        String address = patient.getAddress();
        int cardNumber = patient.getCardRecordNumber();

        Drug drug = _drugService.findById(drugId);

        String drugName = drug.getDrugName();
        int drugAmount = drugOrder.getAmount();

        String body = "fullName: " + fullName + "\n" +
                        "age: " + age + "\n" +
                        "phoneNumber: " + phoneNumber + "\n" +
                        "address: " + address + "\n" +
                        "cardNumber: " + cardNumber + "\n" +
                        "drugName: " + drugName + "\n" +
                        "drugAmount: " + drugAmount + "\n";


        String from = "691fa95586-cc12c1@inbox.mailtrap.io";
        String to = patient.getEmail();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Drug Order");
        message.setText(body);
        mailSender.send(message);

        return _drugOrderService.create(drugOrder,drugId,visitId);    }

    @PostMapping("post/All/data")
    public List<DrugOrder> postDrugOrder(@RequestBody List<DrugOrder> drugOrderList){
        return  _drugOrderService.createAll(drugOrderList);

    }
    @PutMapping("update/{visitId}/{drugId}")
    public DrugOrder updateDrugOrder(@RequestBody DrugOrder drugOrder,
                                     @PathVariable(value = "visitId") int visitId,
                                     @PathVariable(value = "drugId") int drugId){

        return _drugOrderService.update(drugOrder,drugId,visitId);

    }
    @GetMapping("get/data/{id}")
    public DrugOrder getDrugOrder(@PathVariable(value = "id") int Id) {
        return _drugOrderService.findById(Id);
    }
    @GetMapping("get/All/data")
    public List<DrugOrder> getDrugOrder() {



        return _drugOrderService.findAll();
    }

    @DeleteMapping("delete/{id}")
    public Boolean deleteDrugOrder(@PathVariable int id){
        _drugOrderService.deleteById(id);
        return true;

    }

    @DeleteMapping("delete/all")
    public Boolean deleteAllDrugOrder(){
        _drugOrderService.deleteAll();
        return true;

    }
}

