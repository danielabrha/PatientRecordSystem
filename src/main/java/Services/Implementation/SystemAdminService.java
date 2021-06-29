package Services.Implementation;
import Domain.Entity.SystemAdmin;
import Domain.ViewModel.SystemAdminViewModel;
import Repository.ISystemAdminRepository;
import Services.Interface.ISystemAdmin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SystemAdminService implements ISystemAdmin {
    private ISystemAdminRepository systemAdminRepository;
    private SystemAdmin systemAdmin;
    private SystemAdminViewModel systemAdminViewModel;
    @Override
    public List<SystemAdmin> findAll() {
        return systemAdminRepository.findAll();
    }
    @Override
    public List<SystemAdmin> findAll(String status) {
        return null;
    }
    @Override
    public SystemAdmin findById(int id) {
        return systemAdminRepository.getById(id);
    }
    @Override
    public SystemAdmin update(SystemAdminViewModel systemAdminViewModel1) {
        SystemAdmin existingSystemAdmin =systemAdminRepository.findById(systemAdminViewModel1.getSystemAdminViewModel_Id()).orElse(null);
        if(existingSystemAdmin == null) {
            return null;
        }
        systemAdmin.setSystemAdminId(existingSystemAdmin.getSystemAdminId());
        return systemAdminRepository.save(systemAdmin);
    }
    @Override
    public void deleteById(int id) {
        systemAdminRepository.deleteById(id);
    }
    @Override
    public void delete(SystemAdminViewModel systemAdminViewModel) {
        systemAdmin=toSystemAdmin(systemAdminViewModel);
    systemAdminRepository.delete(systemAdmin);

    }
    @Override
    public void deleteAll(Iterable<SystemAdminViewModel> systemAdminViewModels) {

    }
    @Override
    public void deleteAll() {
        systemAdminRepository.deleteAll();
    }
    @Override
    public SystemAdmin create(SystemAdminViewModel systemAdminViewModel)
    {

       return systemAdminRepository.save(toSystemAdmin(systemAdminViewModel));
    }
    @Override
    public List<SystemAdmin> createAll(List<SystemAdminViewModel> listSystemAdminViewModel) {
        List<SystemAdmin> systemAdminList=new ArrayList<>();
        listSystemAdminViewModel.forEach(systemAdmin->{
            systemAdminList.add(toSystemAdmin((SystemAdminViewModel) listSystemAdminViewModel));
        });
        return systemAdminRepository.saveAll(systemAdminList);


    }

    public SystemAdmin toSystemAdmin(SystemAdminViewModel systemAdminViewModel){
        systemAdmin.setSystemAdminId(systemAdminViewModel.getSystemAdminViewModel_Id());
        return systemAdmin;
    }
}
