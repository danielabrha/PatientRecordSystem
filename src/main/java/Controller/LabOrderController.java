package Controller;

import Domain.Entity.*;
import Domain.ViewModel.DrugViewModel;
import Domain.ViewModel.LabOrderViewModel;
import Repository.ILabOrderRepository;
import Services.Implementation.DrugService;
import Services.Implementation.LabOrderService;
import Services.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LabOrderController {

    private ILabOrderService _labOrderService;
    private LabOrder labOrder;
    private List<LabOrder> _labOrderList;
    private LabOrderViewModel labOrderViewModel;
    private List<LabOrderViewModel> _labOrderViewModelList;

    public LabOrderController() {
        this._labOrderService = new LabOrderService();
        this.labOrder = new LabOrder();
        this._labOrderList = new ArrayList<>();
        this.labOrderViewModel = new LabOrderViewModel();
        this._labOrderViewModelList = new ArrayList<>();
    }

    @PostMapping("/LabOrder/post/data/{visitId}/{doctorId}/{labTestTypeId}")
    public LabOrder postLabOrder(@RequestBody LabOrderViewModel LabOrderVM,
            @PathVariable (value = "visitId") int visitId,
                                          @PathVariable (value = "doctorId") int doctorId,
                                          @PathVariable (value = "labTestTypeId") int labTestTypeId

            ) {
        return _labOrderService.create(LabOrderVM, visitId, doctorId, labTestTypeId);

    }

    @PostMapping("/LabOrder/post/All/data/{visitId}/{doctorId}/{labTestTypeId}")
    public List<LabOrder> postLabOrders(@RequestBody List<LabOrderViewModel> labOrderViewModelList,
                                        @PathVariable (value = "visitId") int visitId,
                                        @PathVariable (value = "doctorId") int doctorId,
                                        @PathVariable (value = "labTestTypeId") int labTestTypeId) {
        return  _labOrderService.createAll(labOrderViewModelList, visitId, doctorId, labTestTypeId);
    }

    @GetMapping("/LabOrder/get/data/{id}")
    public LabOrder getLabOrder(@PathVariable(value = "id") int Id) {
        return _labOrderService.findById(Id);

    }

    @GetMapping("/LabOrders/get/All/data")
    public List<LabOrder> getAllLabOrder() {
        return  _labOrderService.findAll();

    }

    @PutMapping("/LabOrder/update/data")
    private LabOrder updateLabOrder(@RequestBody LabOrderViewModel LabOrderCM,
                                    @PathVariable (value = "visitId") int visitId,
                                    @PathVariable (value = "doctorId") int doctorId,
                                    @PathVariable (value = "labTestTypeId") int labTestTypeId) {
        return _labOrderService.update(LabOrderCM, visitId, doctorId, labTestTypeId);
    }

    @DeleteMapping("/LabOrder/deleteById/data/{id}")
    private Boolean deleteLabOrderById(@PathVariable int id) {
        _labOrderService.deleteById(id);
        return true;
    }

    @DeleteMapping("/LabOrder/deleteAll/data")
    private Boolean deleteAllLabOrder() {
        _labOrderService.deleteAll();
        return true;
    }

    private LabOrderViewModel toLabOrderViewModel(LabOrder LabOrder2) {
        // TODO Auto-generated method stub

        return null;
    }

    private List<LabOrderViewModel> toSetLabOrderViewModel(List<LabOrder> setLabOrder) {
        return null;
    }
}
