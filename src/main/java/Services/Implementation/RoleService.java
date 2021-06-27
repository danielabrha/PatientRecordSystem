package Services.Implementation;

import Domain.Entity.Role;
import Domain.ViewModel.RoleViewModel;
import Repository.IRoleRepository;
import Services.Interface.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository _roleRepository;
    @Autowired
    private List<Role> roleList;
    public RoleService(){
        roleList=new ArrayList<>();
    }
    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public List<Role> findAll(String status) {
        return _roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return _roleRepository.findById(id).orElse(null);
    }

    @Override
    public RoleViewModel update(RoleViewModel roleViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        _roleRepository.deleteById(id);
    }

    @Override
    public void delete(RoleViewModel roleViewModel) {

    }

    @Override
    public void deleteAll(Iterable<RoleViewModel> roleViewModels) {

    }

    @Override
    public void deleteAll() {
        _roleRepository.deleteAll();
    }

    @Override
    public Role create(RoleViewModel roleViewModel) {
        return _roleRepository.save(toRole(roleViewModel));
    }

    @Override
    public List<Role> createAll(List<RoleViewModel> roleListViewModel) {

        roleListViewModel.forEach(roleVM -> {
            this.roleList.add(toRole(roleVM));
        });
        return _roleRepository.saveAll(this.roleList);

    }
    public Role toRole(RoleViewModel roleViewModel) {
        Role role = new Role();
        role.setRoleName(roleViewModel.getRoleViewModelName());
        return role;
    }
}
