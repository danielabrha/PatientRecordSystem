package Services.Implementation;

import Domain.Entity.LabResult;
import Domain.ViewModel.LabResultViewModel;
import Repository.ILabResultRepository;
import Services.Interface.ILabOrderService;
import Services.Interface.ILabResultService;
import Services.Interface.ILaboratoristService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LabResultService implements ILabResultService {

    @Autowired
    ILabResultRepository _labResultRepository;
    @Autowired
    ILabOrderService _LabOrderService;
    @Autowired
    ILaboratoristService _LaboratoristService;
    public LabResultService(){
        _LabOrderService=new LabOrderService();
        _LaboratoristService = new LaboratoristService();
    }
    @Override
    public LabResult create(LabResultViewModel labResultViewModel, int labOrdedrId, int laboratoristId) {
        LabResult labResult=toLabResult(labResultViewModel);
        labResult.setLabOrder(_LabOrderService.findById(labOrdedrId)); 
        labResult.setLaboratorist(_LaboratoristService.findById(laboratoristId));
        
        return _labResultRepository.save(labResult);
    }

    @Override
    public List<LabResult> createAll(List<LabResultViewModel> listLabResultViewModel) {
       
        return null;
    }

    @Override
    public void delete(LabResultViewModel labResultViewModel) {
       
        
    }

    @Override

    public void deleteAll(Iterable<LabResultViewModel> labResultViewModels) {
   

    }

    @Override
    public void deleteAll() {
       _labResultRepository.deleteAll();        
    }

    @Override
    public void deleteById(int id) {
        _labResultRepository.deleteById(id);        
    }

    @Override
    public List<LabResult> findAll() {
       return _labResultRepository.findAll();
    }

    @Override
    public List<LabResult> findAll(String status) {
      
        return null;
    }

    @Override
    public LabResult findById(int id) {
        return _labResultRepository.findById(id).orElse(null);
    }

    @Override
    public LabResultViewModel update(LabResultViewModel labResultViewModel) {
        
        return null;
    }






    public LabResult toLabResult(LabResultViewModel labResultViewModel) {
        LabResult labResult = new LabResult();
        labResult.setLabResult(labResultViewModel.getLabResult());;
        return labResult;
    }

}
