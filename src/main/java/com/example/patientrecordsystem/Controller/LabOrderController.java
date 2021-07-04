package com.example.patientrecordsystem.Controller;


import com.example.patientrecordsystem.Domain.Entity.LabOrder;
import com.example.patientrecordsystem.Service.Implementation.LabOrderService;
import com.example.patientrecordsystem.Service.Interface.ILabOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/LabOrder")
public class LabOrderController {
    @Autowired
    private LabOrderService _labOrderService;
    private LabOrder labOrder;
    private List<LabOrder> _labOrderList;

    public LabOrderController() {
        this._labOrderService = new LabOrderService();
        this.labOrder = new LabOrder();
        this._labOrderList = new ArrayList<>();
        this.labOrder = new LabOrder();
        this._labOrderList = new ArrayList<>();
    }

    @PostMapping("post/data/{visitId}/{labTestTypeId}")
    public LabOrder postLabOrder(@RequestBody LabOrder labOrder,
            @PathVariable(value = "visitId") int visitId,
            @PathVariable(value = "labTestTypeId") int labTestTypeId) {
        return _labOrderService.create(visitId, labTestTypeId);

    }

    @PostMapping("post/All/data/{visitId}/{labTestTypeId}")
    public List<LabOrder> postLabOrders(@RequestBody List<LabOrder> labOrderList,
                                        @PathVariable(value = "visitId") int visitId,
                                        @PathVariable(value = "labTestTypeId") int labTestTypeId) {
        return _labOrderService.createAll(labOrderList, visitId, labTestTypeId);
    }

    @GetMapping("get/data/{id}")
    public LabOrder getLabOrder(@PathVariable(value = "id") int Id) {
        return _labOrderService.findById(Id);

    }

    @GetMapping("LabOrders/get/All/data")
    public List<LabOrder> getAllLabOrder() {
        return _labOrderService.findAll();

    }

    @PutMapping("update/data/{visitId}/{labTestTypeId}")
    private LabOrder updateLabOrder(@RequestBody LabOrder LabOrderCM,
                                    @PathVariable(value = "visitId") int visitId,
                                    @PathVariable(value = "labTestTypeId") int labTestTypeId) {
        return _labOrderService.update(LabOrderCM, visitId, labTestTypeId);
    }

    @DeleteMapping("deleteById/data/{id}")
    private Boolean deleteLabOrderById(@PathVariable int id) {
        _labOrderService.deleteById(id);
        return true;
    }

    @DeleteMapping("deleteAll/data")
    private Boolean deleteAllLabOrder() {
        _labOrderService.deleteAll();
        return true;
    }

    private LabOrder toLabOrder(LabOrder LabOrder2) {
        // TODO Auto-generated method stub

        return null;
    }

    private List<LabOrder> toSetLabOrder(List<LabOrder> setLabOrder) {
        return null;
    }
}

