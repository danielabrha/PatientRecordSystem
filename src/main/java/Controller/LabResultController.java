package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Domain.ViewModel.LabResultViewModel;
import Domain.Entity.*;
import Services.Implementation.LabResultService;

@RestController
public class LabResultController {
    @Autowired
    private LabResultService _LabResultService;
    @Autowired
    private LabResultViewModel labResultViewModel;
    @Autowired
    private LabOrder labOrder;
    @Autowired
    private Laboratorist laboratorist;
    @Autowired
    private LabResult labResult;
    public LabResultController() {
        _LabResultService = new LabResultService();
        labOrder = new LabOrder();
        labResult = new LabResult();
    }

    @PostMapping("/Lab/Result/data")
    public LabResultViewModel postResult(@RequestBody LabResultViewModel labResultViewModel){
        this.labResult = _LabResultService.create(labResultViewModel);
        return toLabResultViewModel(labResult);
    }
    private LabResultViewModel toLabResultViewModel(LabResult labResult) {
        this.labResultViewModel = new LabResultViewModel();
        this.labResultViewModel.setLabResultId(labResult.getLabResultId());
        this.labResultViewModel.setLabResult(labResult.getLabResult());
        
        return this.labResultViewModel;
    }

    
}
