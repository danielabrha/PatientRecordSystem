package Services.Interface;

import Domain.Entity.LabResult;
import Domain.ViewModel.LabResultViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ILabResultService {
    public List<LabResult> findAll();
    //	public List<LabResultViewModel> findAll(int entryid);
    public List<LabResult> findAll(String status);
    public LabResult findById(int id);
    public LabResult update(LabResultViewModel labResultViewModel);
    public void deleteById(int id);
    public void delete(LabResultViewModel labResultViewModel);
    public void deleteAll(Iterable<LabResultViewModel> labResultViewModels);
    public void deleteAll();
    public LabResult create(LabResultViewModel labResultViewModel, int labOrderId, int laboratoristId);
    public List<LabResult> createAll(List<LabResultViewModel> listLabResultViewModel);
}
