package Services.Implementation;
import Domain.Entity.SystemAdmin;
import Domain.ViewModel.SystemAdminViewModel;
import Services.Interface.ISystemAdmin;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SystemAdminService implements ISystemAdmin {
    @Override
    public List<SystemAdmin> findAll() {
        return null;
    }
    @Override
    public List<SystemAdmin> findAll(String status) {
        return null;
    }
    @Override
    public SystemAdmin findById(int id) {
        return null;
    }
    @Override
    public SystemAdmin update(SystemAdminViewModel systemAdminViewModel) {
        return null;
    }
    @Override
    public void deleteById(int id) {
    }
    @Override
    public void delete(SystemAdminViewModel systemAdminViewModel) {
    }
    @Override
    public void deleteAll(Iterable<SystemAdminViewModel> systemAdminViewModels) {
    }
    @Override
    public void deleteAll() {
    }
    @Override
    public SystemAdmin create(SystemAdminViewModel systemAdminViewModel) {
        return null;
    }
    @Override
    public List<SystemAdmin> createAll(List<SystemAdminViewModel> listSystemAdminViewModel) {
        return null;
    }
}
