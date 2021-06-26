package Services.Interface;

import Domain.Entity.LabTestType;
import Domain.ViewModel.LabTestTypeViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ILabTestType {
    public List<LabTestType> findAll();
    //	public List<LabTestTypeViewModel> findAll(int entryid);
    public List<LabTestType> findAll(String status);
    public LabTestType findById(int id);
    public LabTestTypeViewModel update(LabTestTypeViewModel labTestTypeViewModel);
    public void deleteById(int id);
    public void delete(LabTestTypeViewModel labTestTypeViewModel);
    public void deleteAll(Iterable<LabTestTypeViewModel> labTestTypeViewModels);
    public void deleteAll();
    public LabTestType create(LabTestTypeViewModel labTestTypeViewModel);
    public List<LabTestType> createAll(List<LabTestTypeViewModel> listLabTestTypeViewModel);
}
