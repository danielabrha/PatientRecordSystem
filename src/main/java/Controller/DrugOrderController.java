package Controller;

import Domain.Entity.DrugOrder;
import Domain.ViewModel.DrugOrderViewModel;
import Services.Implementation.DrugOrderService;
import Services.Interface.IDrugOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DrugOrderController {
    private IDrugOrderService _labTestTypeService;
    private DrugOrder labTestType;
    private List<DrugOrder> _labTestTypeList;
    private DrugOrderViewModel labTestTypeViewModel;
    private List<DrugOrderViewModel> _labTestTypeViewModelList;

    public DrugOrderController() {
        this._labTestTypeService = new DrugOrderService();
        this.labTestType = new DrugOrder();
        this._labTestTypeList = new ArrayList<>();
        this.labTestTypeViewModel = new DrugOrderViewModel();
        this._labTestTypeViewModelList = new ArrayList<>();
    }
    @PostMapping("DrugOrder/post/data/{visitId}/{doctorId}/{drugId}")
    public DrugOrder postDurg(@PathVariable(value = "visitId") int visitId,
                              @PathVariable(value = "doctorId") int doctorId,
                              @PathVariable(value = "drugId") int drugId,
                              @RequestBody DrugOrderViewModel labTestTypeVM){
        return _labTestTypeService.create(labTestTypeVM,drugId,doctorId,visitId);

    }

    @PostMapping("DrugOrder/post/All/data/")
    public List<DrugOrder> postDrugOrder(@RequestBody List<DrugOrderViewModel> labTestTypeVMList){
        return  _labTestTypeService.createAll(labTestTypeVMList);

    }
    @PutMapping("DrugOrder/update/{visitId}/{doctorId}/{drugId}")
    public DrugOrder updateDrugOrder(@RequestBody DrugOrderViewModel labTestTypeVM,
                                     @PathVariable(value = "visitId") int visitId,
                                     @PathVariable(value = "doctorId") int doctorId,
                                     @PathVariable(value = "drugId") int drugId){

        return _labTestTypeService.update(labTestTypeVM,drugId,doctorId,visitId);

    }
    @GetMapping("/DrugOrder/get/data/{id}")
    public DrugOrder getDrugOrder(@PathVariable(value = "id") int Id) {
        return _labTestTypeService.findById(Id);
    }
    @GetMapping("/DrugOrder/get/All/data/")
    public List<DrugOrder> getDrugOrder() {

        return _labTestTypeService.findAll();
    }

    @DeleteMapping("DrugOrder/delete/{id}")
    public Boolean deleteDrugOrder(@PathVariable int id){
        _labTestTypeService.deleteById(id);
        return true;

    }

    @DeleteMapping("DrugOrder/delete/all")
    public Boolean deleteAllDrugOrder(){
        _labTestTypeService.deleteAll();
        return true;

    }
}
