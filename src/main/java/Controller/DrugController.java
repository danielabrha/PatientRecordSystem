package Controller;

import Domain.Entity.Drug;
import Domain.ViewModel.DrugViewModel;
import Domain.ViewModel.RoleViewModel;
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
    @PostMapping("Drug/post/data")
    public DrugViewModel postDrug(@RequestBody DrugViewModel drugVM){
        this.drug = _drugService.create(drugVM);
        return toDrugViewModel(this.drug);
    }

    @PostMapping("Drug/post/All/data")
    public List<DrugViewModel> postDrug(@RequestBody List<DrugViewModel> drugVMList){
        this._drugList = _drugService.createAll(drugVMList);
        return toDrugViewModel(this._drugList);
    }
    @GetMapping("/Drug/get/data/{id}")
    public DrugViewModel getDrug(@PathVariable(value = "id") int Id) {
        this.drug = _drugService.findById(Id);
        return toDrugViewModel(this.drug);
    }
    @GetMapping("/Drug/get/All/data/")
    public List<DrugViewModel> getDrug() {
        // to be implemented
        return null;
    }

    @DeleteMapping("Drug/deletebyId/{id}")
    public Boolean deleteDrug(@PathVariable int id){
        _drugService.deleteById(id);
        return true;

    }



    private List<DrugViewModel> toDrugViewModel(List<Drug> drugList){
        return null;
    }

    private DrugViewModel toDrugViewModel(Drug drug) {
        return null;
    }
}
