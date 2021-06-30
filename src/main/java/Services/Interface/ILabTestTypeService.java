package Services.Interface;

import Domain.Entity.LabTestType;
import Domain.ViewModel.LabTestTypeViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ILabTestTypeService {
    public List<LabTestType> findAll();
    //	public List<LabTestTypeViewModel> findAll(int entryid);
    public List<LabTestType> findAll(String status);
    public List<LabTestType> findAllLabTests(int labOrderId);
    public LabTestType findById(int id);
    public LabTestType update(LabTestTypeViewModel labTestTypeViewModel,int systemAdminId);
    public void deleteById(int id);
    public void delete(LabTestTypeViewModel labTestTypeViewModel);
    public void deleteAll(Iterable<LabTestTypeViewModel> labTestTypeViewModels);
    public void deleteAll();
    public LabTestType create(LabTestTypeViewModel labTestTypeViewModel,int systemAdminId);
    public List<LabTestType> createAll(List<LabTestTypeViewModel> listLabTestTypeViewModel,int systemAdminId);
}
