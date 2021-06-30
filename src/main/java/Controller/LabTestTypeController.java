package Controller;

import Domain.Entity.LabTestType;
import Domain.ViewModel.LabTestTypeViewModel;
import Domain.ViewModel.LabTestTypeViewModel;
import Services.Implementation.LabTestTypeService;
import Services.Interface.ILabTestTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LabTestTypeController {
    private ILabTestTypeService _labTestTypeService;
    private LabTestType labTestType;
    private List<LabTestType> _labTestTypeList;
    private LabTestTypeViewModel labTestTypeViewModel;
    private List<LabTestTypeViewModel> _labTestTypeViewModelList;

    public LabTestTypeController() {
        this._labTestTypeService = new LabTestTypeService();
        this.labTestType = new LabTestType();
        this._labTestTypeList = new ArrayList<>();
        this.labTestTypeViewModel = new LabTestTypeViewModel();
        this._labTestTypeViewModelList = new ArrayList<>();
    }
    @PostMapping("LabTestType/post/data/{systemAdminId}")
    public LabTestType postDurg(@RequestBody LabTestTypeViewModel labTestTypeVM,@PathVariable(value = "systemAdminId") int systemAdminId){
        return _labTestTypeService.create(labTestTypeVM,systemAdminId);

    }

    @PostMapping("LabTestType/post/All/data/{systemAdminId}")
    public List<LabTestType> postLabTestType(@RequestBody List<LabTestTypeViewModel> labTestTypeVMList,@PathVariable (value = "systemAdminId") int systemAdminId){
        return  _labTestTypeService.createAll(labTestTypeVMList,systemAdminId);

    }
    @PutMapping("LabTestType/update/{systemAdminId}")
    public LabTestType updateLabTestType(@RequestBody LabTestTypeViewModel labTestTypeVM,@PathVariable (value = "systemAdminId") int systemAdminId){

        return _labTestTypeService.update(labTestTypeVM,systemAdminId);

    }
    @GetMapping("/LabTestType/get/data/{id}")
    public LabTestType getLabTestType(@PathVariable(value = "id") int Id) {
        return _labTestTypeService.findById(Id);
    }
    @GetMapping("/LabTestType/get/All/data/")
    public List<LabTestType> getLabTestType() {

        return _labTestTypeService.findAll();
    }

    @DeleteMapping("LabTestType/delete/{id}")
    public Boolean deleteLabTestType(@PathVariable int id){
        _labTestTypeService.deleteById(id);
        return true;

    }

    @DeleteMapping("LabTestType/delete/all")
    public Boolean deleteAllLabTestType(){
        _labTestTypeService.deleteAll();
        return true;

    }
}
