package Services.Implementation;

import Domain.Entity.LabOrder;
import Domain.ViewModel.LabTestTypeViewModel;
import Repository.ILabOrderRepository;
import Repository.ILabTestTypeRepository;
import Services.Interface.ILabTestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LabTestType implements ILabTestType {

    @Autowired
    private ILabTestTypeRepository _labTestTypeRepository;




    private List<Domain.Entity.LabTestType> labTestTypeList;

    public  LabTestType(){
        labTestTypeList = new ArrayList<>();
    }
    @Override
    public List<Domain.Entity.LabTestType> findAllLabTests(int labOrderId){
        _labTestTypeRepository.findByLabTestTypeId(labOrderId)
                .forEach(labTestTypeList::add);
        return labTestTypeList;
    }

    @Override
    public List<Domain.Entity.LabTestType> findAll() {
        return null;
    }

    @Override
    public List<Domain.Entity.LabTestType> findAll(String status) {
        return null;
    }

    @Override
    public Domain.Entity.LabTestType findById(int id) {
        return null;
    }

    @Override
    public LabTestTypeViewModel update(LabTestTypeViewModel labTestTypeViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(LabTestTypeViewModel labTestTypeViewModel) {

    }

    @Override
    public void deleteAll(Iterable<LabTestTypeViewModel> labTestTypeViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Domain.Entity.LabTestType create(LabTestTypeViewModel labTestTypeViewModel) {
        return null;
    }

    @Override
    public List<Domain.Entity.LabTestType> createAll(List<LabTestTypeViewModel> listLabTestTypeViewModel) {
        return null;
    }
}
