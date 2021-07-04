package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.Role;
import com.example.patientrecordsystem.Service.Implementation.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/Role")
public class RoleController {
    @Autowired
    private RoleService _roleService;
    private Role roleService;
    private List<Role> _roleServiceList;
   

    public RoleController() {
        this._roleService = new RoleService();
        this.roleService = new Role();
        this._roleServiceList = new ArrayList<>();
        
    }

    @PostMapping("post/data")
    public Role postRole(@RequestBody Role role){
        return _roleService.create(role);

    }

    @PostMapping("post/All/data")
    public List<Role> postRole(@RequestBody List<Role> roleList){
        return  _roleService.createAll(roleList);

    }
    @PutMapping("update/{roleId}")
    public Role updateRole(@RequestBody Role role,@PathVariable (value = "roleId") int roleId){
        return _roleService.update(role,roleId);

    }
    @GetMapping("get/data/{id}")
    public Role getRole(@PathVariable(value = "id") int Id) {
        return _roleService.findById(Id);
    }
    @GetMapping("get/All/data")
    public List<Role> getRole() {

        return _roleService.findAll();
    }

    @DeleteMapping("delete/{id}")
    public Boolean deleteRole(@PathVariable int id){
        _roleService.deleteById(id);
        return true;

    }

    @DeleteMapping("delete/all")
    public Boolean deleteAllRole(){
        _roleService.deleteAll();
        return true;

    }

}

