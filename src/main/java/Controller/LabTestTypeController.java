package Controller;

import Domain.ViewModel.LabTestTypeViewModel;
import Services.Interface.ILabTestType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LabTestTypeController {
    private ILabTestType labTestTypeService;
    private LabTestTypeViewModel labTestTypeViewModel;
    private LabTestType labTestType;

    @RequestMapping("LabTestType/post/data")
     public LabTestTypeViewModel postSystemAdmin(@RequestBody LabTestTypeViewModel labTestTypeViewModel){
        return toLabTestTypeViewModel(labTestTypeService.create(labTestTypeViewModel));
    }
    @RequestMapping("LabTestType/update/data")
    public LabTestTypeViewModel update(@RequestBody LabTestTypeViewModel labTestTypeViewModel){
      return  labTestTypeService.update(labTestTypeViewModel);
    }
    @RequestMapping("LabTestType/get/data")
       public List<LabTestTypeViewModel> get(){
        List<Domain.Entity.LabTestType> labTestTypeList=labTestTypeService.findAll();
        List<LabTestTypeViewModel> labTestTypeViewModelList=new ArrayList<>();
        labTestTypeList.forEach(labTestVm->{
            labTestTypeViewModelList.add(toLabTestTypeViewModel((Domain.Entity.LabTestType) labTestTypeList));
        });
                return labTestTypeViewModelList;
            }
     @RequestMapping("LabTestType/deleteAll/data")
     public void delete(){
        labTestTypeService.deleteAll();
     }
    @RequestMapping("LabTestType/deleteById/data")
    public void deleteById(LabTestTypeViewModel labTestTypeViewModel){
        labTestTypeService.deleteById(labTestTypeViewModel.getLabTestTypeViewModel_Id());
    }


    public LabTestTypeViewModel toLabTestTypeViewModel(Domain.Entity.LabTestType labTestType){
        labTestTypeViewModel.setLabTestTypeViewModel_Id(labTestType.getLabTestTypeId());
        labTestTypeViewModel.setLabTestViewModelName(labTestType.getLabTestName());
        labTestTypeViewModel.setLabTestViewModelCode(labTestType.getLabTestCode());
        return labTestTypeViewModel;
    }

}
