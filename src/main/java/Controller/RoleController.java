package Controller;

import Services.Implementation.RoleService;
import Services.Interface.IRoleService;
import Domain.Entity.Role;
import Domain.ViewModel.RoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class RoleController {
//    @Autowired
    private IRoleService _RoleService;
//    @Autowired
    private Role userRole;
//    @Autowired
    private RoleViewModel RoleVM;
//    @Autowired
    private List<RoleViewModel> _listRoleVM;
//    @Autowired
    private List<Role> _listRoles;

    public RoleController() {
        _RoleService = new RoleService();
        userRole = new Role();
        _listRoleVM = new LinkedList<RoleViewModel>();
        _listRoles = new LinkedList<Role>();
    }

    @PostMapping("/Role/post/data")
    public RoleViewModel postRole(@RequestBody RoleViewModel RoleVM) {
        this.userRole = _RoleService.create(RoleVM);

        return toRoleViewModel(this.userRole);
        //return new RoleViewModel();

    }

    @PostMapping("/Role/post/All/data")
    public List<RoleViewModel> postRoles(@RequestBody List<RoleViewModel> setRoleVM) {
        this._listRoles = _RoleService.createAll(setRoleVM);
        return toSetRoleViewModel(this._listRoles);
    }

    @GetMapping("/Role/get/data/{id}")
    public RoleViewModel getRole(@PathVariable(value = "id") int Id) {
        this.userRole = _RoleService.findById(Id);
        return toRoleViewModel(this.userRole);

    }

    @GetMapping("/Roles/get/All/data")
    public List<RoleViewModel> getAllRole() {

//        this._listRoles = _RoleService.findAll();
//        return toSetRoleViewModel(this._listRoles);
        return null;

    }

//	@PutMapping("/Role/update/data")
//	private RoleViewModel updateRole(@RequestBody RoleViewModel RoleCM) {
//		return toRoleViewModel(_RoleService.update(RoleCM));
//	}

    @DeleteMapping("/Role/deleteById/data/{id}")
    private Boolean deleteRoleById(@PathVariable int id) {
        _RoleService.deleteById(id);
        return true;
    }

    @DeleteMapping("/Role/deleteAll/data")
    private Boolean deleteAllRole() {
        _RoleService.deleteAll();
        return true;
    }

    private RoleViewModel toRoleViewModel(Role Role2) {
        // TODO Auto-generated method stub

        this.RoleVM = new RoleViewModel();
        this.RoleVM.setRoleViewModel_Id(Role2.getRoleId());
        this.RoleVM.setRoleViewModelName(Role2.getRoleName());
        return this.RoleVM;
    }

    private List<RoleViewModel> toSetRoleViewModel(List<Role> setRole) {
        setRole.forEach(Role -> {
            this._listRoleVM.add(toRoleViewModel(Role));
        });
        return this._listRoleVM;
    }
}
