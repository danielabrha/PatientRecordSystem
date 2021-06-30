package Services.Interface;

import Domain.Entity.Role;
import Domain.ViewModel.RoleViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IRoleService {
    public List<Role> findAll();
    //	public List<RoleViewModel> findAll(int entryid);
    public List<Role> findAll(String status);
    public Role findById(int id);
    public Role update(RoleViewModel roleViewModel,int roleId);
    public void deleteById(int id);
    public void delete(RoleViewModel roleViewModel);
    public void deleteAll(Iterable<RoleViewModel> roleViewModels);
    public void deleteAll();
    public Role create(RoleViewModel roleViewModel);
    public List<Role> createAll(List<RoleViewModel> listRoleViewModel);
}
