package Controller;

import Domain.Entity.*;
import Domain.ViewModel.LabOrderViewModel;
import Services.Implementation.LabOrderService;
import Services.Interface.ILabOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LabOrderController {

    //@Autowired
    private ILabOrderService _LabOrderService;

    //@Autowired
    private LabOrder labOrder;
    //@Autowired
    private LabOrderViewModel LabOrderVM;
    //    @Autowired
    private List<LabOrderViewModel> _listLabOrderVM;
    //    @Autowired
    private List<LabOrder> _listLabOrders;

    private Visit visit;
    private Doctor doctor;
    private LabResult labResult;
    private LabTestType labTestType;


    public LabOrderController() {
        _LabOrderService = new LabOrderService();
        labOrder = new LabOrder();
        visit = new Visit();
        doctor = new Doctor();
        labResult = new LabResult();
        labTestType = new LabTestType();
        _listLabOrderVM = new ArrayList<LabOrderViewModel>();
        _listLabOrders = new ArrayList<LabOrder>();
    }

    @PostMapping("/LabOrder/post/data/{visitId}/{doctorId}/{labTestTypeId}/{labResultId}/")
    public LabOrderViewModel postLabOrder(@RequestBody LabOrderViewModel LabOrderVM,
            @PathVariable (value = "visitId") int visitId,
                                          @PathVariable (value = "doctorId") int doctorId,
                                          @PathVariable (value = "labTestTypeId") int labTestTypeId,
                                          @PathVariable (value = "labResultId") int labResultId

            ) {
        this.labOrder = _LabOrderService.create(LabOrderVM, visitId, doctorId, labTestTypeId, labResultId);

        return toLabOrderViewModel(this.labOrder);
        //return new LabOrderViewModel();

    }

    @PostMapping("/LabOrder/post/All/data")
    public List<LabOrderViewModel> postLabOrders(@RequestBody List<LabOrderViewModel> setLabOrderVM) {
        this._listLabOrders = _LabOrderService.createAll(setLabOrderVM);
        return toSetLabOrderViewModel(this._listLabOrders);
    }

    @GetMapping("/LabOrder/get/data/{id}")
    public LabOrderViewModel getLabOrder(@PathVariable(value = "id") int Id) {
        this.labOrder = _LabOrderService.findById(Id);
        return toLabOrderViewModel(this.labOrder);

    }

    @GetMapping("/LabOrders/get/All/data")
    public List<LabOrderViewModel> getAllLabOrder() {
        this._listLabOrders = _LabOrderService.findAll();
        return toSetLabOrderViewModel(this._listLabOrders);

    }

    @PutMapping("/LabOrder/update/data")
    private LabOrderViewModel updateLabOrder(@RequestBody LabOrderViewModel LabOrderCM) {
        return toLabOrderViewModel(_LabOrderService.update(LabOrderCM));
    }

    @DeleteMapping("/LabOrder/deleteById/data/{id}")
    private Boolean deleteLabOrderById(@PathVariable int id) {
        _LabOrderService.deleteById(id);
        return true;
    }

    @DeleteMapping("/LabOrder/deleteAll/data")
    private Boolean deleteAllLabOrder() {
        _LabOrderService.deleteAll();
        return true;
    }

    private LabOrderViewModel toLabOrderViewModel(LabOrder LabOrder2) {
        // TODO Auto-generated method stub

        this.LabOrderVM = new LabOrderViewModel();
        this.LabOrderVM.setLabOrderViewModelId(LabOrder2.getLabOrderId());
        return this.LabOrderVM;
    }

    private List<LabOrderViewModel> toSetLabOrderViewModel(List<LabOrder> setLabOrder) {
        setLabOrder.forEach(LabOrder -> {
            this._listLabOrderVM.add(toLabOrderViewModel(LabOrder));
        });
        return this._listLabOrderVM;
    }
}
