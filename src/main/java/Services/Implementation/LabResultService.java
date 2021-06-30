package Services.Implementation;

import Domain.Entity.LabOrder;
import Domain.Entity.LabResult;
import Domain.ViewModel.LabResultViewModel;
import Repository.ILabResultRepository;
import Services.Interface.ILabOrderService;
import Services.Interface.ILabResultService;
import Services.Interface.ILaboratoristService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabResultService implements ILabResultService {

    @Autowired
    ILabResultRepository _labResultRepository;

    @Autowired
    private List<LabResult> labResultList;

    @Autowired
    private ILabOrderService _labOrderService;
    @Autowired
    private ILaboratoristService _laboratoristService;

    public LabResultService() {
        _labOrderService = new LabOrderService();
        _laboratoristService = new LaboratoristService();
        labResultList = new ArrayList<>();
    }

    @Override
    public LabResult create(LabResultViewModel labResultViewModel, int labOrderId, int laboratoristId) {
        LabResult labResult=toLabResult(labResultViewModel,labOrderId, laboratoristId);
        return _labResultRepository.save(labResult);
    }

        @Override
    public List<LabResult> createAll(List<LabResultViewModel> labResultViewModelList, int labOrderId,
                                     int laboratoristId) {
            LabResult labResult = new LabResult();
            labResultViewModelList.forEach(labResultVM -> {

                this.labResultList.add(toLabResult(labResultVM,labOrderId, laboratoristId));
            });
            return _labResultRepository.saveAll(this.labResultList);
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
    public LabResult update(LabResultViewModel labResultViewModel) {
        return null;
    }


    public LabResult toLabResult(LabResultViewModel labResultViewModel, int labOrderId, int laboratoristId) {
        LabResult labResult = new LabResult();
        labResult.setLabResultName(labResultViewModel.getLabResultName());
        labResult.setLabOrder(_labOrderService.findById(labOrderId));
        labResult.setLaboratorist(_laboratoristService.findById(laboratoristId));
        return labResult;
    }

}
