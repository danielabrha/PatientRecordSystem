package Controller;

import Domain.Entity.Drug;
import Domain.Entity.DrugOrder;
import Domain.Entity.SystemAdmin;
import Domain.ViewModel.DrugOrderViewModel;
import Domain.ViewModel.DrugViewModel;
import Domain.ViewModel.RoleViewModel;
import Domain.ViewModel.SystemAdminViewModel;
import Services.Implementation.DrugService;
import Services.Interface.IDrugService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DrugController {

    private IDrugService _drugService;
    private Drug drug;
    private List<Drug> _drugList;
    private DrugViewModel drugViewModel;
    private List<DrugViewModel> _drugViewModelList;

    public DrugController() {
        this._drugService = new DrugService();
        this.drug = new Drug();
        this._drugList = new ArrayList<>();
        this.drugViewModel = new DrugViewModel();
        this._drugViewModelList = new ArrayList<>();
    }
    @PostMapping("Drug/post/data/{systemAdminId}")
    public Drug postDurg(@RequestBody DrugViewModel drugVM,@PathVariable (value = "systemAdminId") int systemAdminId){
       return _drugService.create(drugVM,systemAdminId);

    }

    @PostMapping("Drug/post/All/data/{systemAdminId}")
    public List<Drug> postDrug(@RequestBody List<DrugViewModel> drugVMList,@PathVariable (value = "systemAdminId") int systemAdminId){
        return  _drugService.createAll(drugVMList,systemAdminId);

    }
    @PutMapping("Drug/update/{systemAdminId}")
    public Drug updateDrug(@RequestBody DrugViewModel drugVM,@PathVariable (value = "systemAdminId") int systemAdminId){

        return _drugService.update(drugVM,systemAdminId);

    }
    @GetMapping("/Drug/get/data/{id}")
    public Drug getDrug(@PathVariable(value = "id") int Id) {
       return _drugService.findById(Id);
    }
    @GetMapping("/Drug/get/All/data/")
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

    private List<DrugViewModel> toDrugViewModel(List<Drug> drugList){
        return null;
    }

    private DrugViewModel toDrugViewModel(Drug drug) {
        DrugViewModel drugVM=new DrugViewModel();
        List<DrugOrderViewModel> drugOrderViewModelList=new ArrayList<>();
        DrugOrderViewModel drugOrderViewModel=new DrugOrderViewModel();
        drugVM.setDrugId(drug.getDrugId());
        drugVM.setDrugCode(drug.getDrugCode());
        List<DrugOrder> drugOrderList= drug.getDrugOrderList();
        drugOrderList.forEach(drugOrder -> {
            drugOrderViewModel.setDrugOrderId(drugOrder.getDrugOrderId());
            drugOrderViewModel.setAmount(drugOrder.getAmount());
            drugOrderViewModel.setVisit(drugOrder.getVisit());
            drugOrderViewModel.setDrug(drugOrder.getDrug());
            drugOrderViewModel.setDoctor(drugOrder.getDoctor());
            drugOrderViewModelList.add(drugOrderViewModel);
        });
        drugVM.setDrugOrderViewModelList(drugOrderViewModelList);
        SystemAdmin systemAdmin=drug.getSystemAdmin();
        SystemAdminViewModel systemAdminViewModel=new SystemAdminViewModel();
        systemAdminViewModel.setSystemAdminId(systemAdmin.getSystemAdminId());
        systemAdminViewModel.setUser(systemAdmin.getUser());
        drugVM.setSystemAdminViewModel(systemAdminViewModel);
        return  drugVM;
    }
}
