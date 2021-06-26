package Services.Implementation;

import Domain.Entity.Role;
import Domain.ViewModel.RoleViewModel;
import Services.Interface.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService {
    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public List<Role> findAll(String status) {
        return null;
    }

    @Override
    public Role findById(int id) {
        return null;
    }

    @Override
    public RoleViewModel update(RoleViewModel roleViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(RoleViewModel roleViewModel) {

    }

    @Override
    public void deleteAll(Iterable<RoleViewModel> roleViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Role create(RoleViewModel roleViewModel) {
        return null;
    }

    @Override
    public List<Role> createAll(List<RoleViewModel> listRoleViewModel) {
        return null;
    }
}
