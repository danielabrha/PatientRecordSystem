package Services.Implementation;

import Domain.Entity.LabResult;
import Domain.ViewModel.LabResultViewModel;
import Repository.ILabResultRepository;
import Services.Interface.ILabResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LabResultService implements ILabResultService {

    @Autowired
    ILabResultRepository _iLabResultRepository;
    
    @Override
    public LabResult create(LabResultViewModel labResultViewModel) {
        return _iLabResultRepository.save(toLabResult(labResultViewModel));
    }

    @Override
    public List<LabResult> createAll(List<LabResultViewModel> listLabResultViewModel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(LabResultViewModel labResultViewModel) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll(Iterable<LabResultViewModel> labResultViewModels) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<LabResult> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<LabResult> findAll(String status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LabResult findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LabResultViewModel update(LabResultViewModel labResultViewModel) {
        // TODO Auto-generated method stub
        return null;
    }






    public LabResult toLabResult(LabResultViewModel labResultViewModel) {
        LabResult labResult = new LabResult();
        labResult.setResult(labResultViewModel.getResult());;
        return labResult;
    }

}
