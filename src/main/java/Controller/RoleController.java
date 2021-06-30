package Controller;

import Domain.Entity.Role;
import Domain.ViewModel.RoleViewModel;
import Services.Implementation.RoleService;
import Services.Implementation.RoleService;
import Services.Interface.IRoleService;
import Services.Interface.IRoleService;
import Domain.Entity.Role;
import Domain.ViewModel.RoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class RoleController {
    private IRoleService _labTestTypeService;
    private Role labTestType;
    private List<Role> _labTestTypeList;
    private RoleViewModel labTestTypeViewModel;
    private List<RoleViewModel> _labTestTypeViewModelList;

    public RoleController() {
        this._labTestTypeService = new RoleService();
        this.labTestType = new Role();
        this._labTestTypeList = new ArrayList<>();
        this.labTestTypeViewModel = new RoleViewModel();
        this._labTestTypeViewModelList = new ArrayList<>();
    }
    @PostMapping("Role/post/data/")
    public Role postDurg(@RequestBody RoleViewModel labTestTypeVM){
        return _labTestTypeService.create(labTestTypeVM);

    }

    @PostMapping("Role/post/All/data/")
    public List<Role> postRole(@RequestBody List<RoleViewModel> labTestTypeVMList){
        return  _labTestTypeService.createAll(labTestTypeVMList);

    }
    @PutMapping("Role/update/{roleId}")
    public Role updateRole(@RequestBody RoleViewModel labTestTypeVM,@PathVariable (value = "roleId") int roleId){

        return _labTestTypeService.update(labTestTypeVM,roleId);

    }
    @GetMapping("/Role/get/data/{id}")
    public Role getRole(@PathVariable(value = "id") int Id) {
        return _labTestTypeService.findById(Id);
    }
    @GetMapping("/Role/get/All/data/")
    public List<Role> getRole() {

        return _labTestTypeService.findAll();
    }

    @DeleteMapping("Role/delete/{id}")
    public Boolean deleteRole(@PathVariable int id){
        _labTestTypeService.deleteById(id);
        return true;

    }

    @DeleteMapping("Role/delete/all")
    public Boolean deleteAllRole(){
        _labTestTypeService.deleteAll();
        return true;

    }

}
