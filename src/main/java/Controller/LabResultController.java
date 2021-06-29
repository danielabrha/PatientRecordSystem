package Controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Domain.ViewModel.LabResultViewModel;
import Domain.Entity.*;
import Services.Implementation.LabResultService;
import Services.Interface.ILabResultService;

@RestController
public class LabResultController {
    @Autowired
    private ILabResultService _LabResultService;
    @Autowired
    private LabResultViewModel labResultViewModel;
    @Autowired
    private LabOrder labOrder;
    @Autowired
    private Laboratorist laboratorist;
    @Autowired
    private LabResult labResult;
    @Autowired
    private List<LabResultViewModel> labResultViewModelList;
    @Autowired
    private List<LabResult> labResultList;
    public LabResultController() {
        _LabResultService = new LabResultService();
        labOrder = new LabOrder();
        labResult = new LabResult();
        labResultViewModelList = new LinkedList<>();
        labResultList = new LinkedList<>();
        
    }

    @PostMapping("/Lab/post/result/{labOrderId}/{laboratoristId}")
    public LabResultViewModel postResult(@PathVariable(value = "labOrdedrId") int labOrderId,
        @PathVariable(value = "laboratoristId") int laboratoristId,
        @RequestBody LabResultViewModel labResultViewModel){
        this.labResult = _LabResultService.create(labResultViewModel,labOrderId,laboratoristId);

        return toSetLabResultViewModel(labResult);
    }
    @GetMapping("Lab/get/result/{labOrderId}")
    public LabResultViewModel getResult(@PathVariable(value = "labOrderId")int id){
        this.labResult = _LabResultService.findById(id);
        return toGetLabResultViewModel(this.labResult);
    }
    @GetMapping("Lab/get/result/all")
    public List<LabResultViewModel> getAllLabResult(){
        this.labResultList = _LabResultService.findAll();
        return toGetResultViewModel(this.labResultList);
    }

    @DeleteMapping("Lab/delete/result/{labResultId}")
    public Boolean deleteLabResult(@PathVariable(value = "labResultId") int labResultId){
        _LabResultService.deleteById(labResultId);
        return true;
    }
    @DeleteMapping("Lab/delete/result/all")
    public Boolean deleteAllResult(){
        _LabResultService.deleteAll();
        return true;
    }
    public List<LabResultViewModel> toGetResultViewModel(List<LabResult> setLabResult){
        setLabResult.forEach(LabResult ->{
            this.labResultViewModelList.add(toSetLabResultViewModel(LabResult));
        });
        return this.labResultViewModelList;
    }

    public LabResultViewModel toSetLabResultViewModel(LabResult labResult) {
        this.labResultViewModel = new LabResultViewModel();
        this.labResultViewModel.setLabResultId(labResult.getLabResultId());
        this.labResultViewModel.setLabResult(labResult.getLabResult());
        
        return this.labResultViewModel;
    }

    public LabResultViewModel toGetLabResultViewModel(LabResult labResult){
        this.labResultViewModel = new LabResultViewModel();
        this.labResultViewModel.setLabResultId(labResult.getLabResultId());
        this.labResultViewModel.setLabOrder(labResult.getLabOrder());
        this.labResultViewModel.setLabResult(labResult.getLabResult());

        return this.labResultViewModel;
    }

    
}
