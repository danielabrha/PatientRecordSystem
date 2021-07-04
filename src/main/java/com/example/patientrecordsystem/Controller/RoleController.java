package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.Role;
import com.example.patientrecordsystem.Service.Implementation.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RestController
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

    @PostMapping("Role/post/data")
    public ResponseEntity<Role> postRole(@Valid @RequestBody Role role){
        Role createdRole = _roleService.create(role);
        return new ResponseEntity<Role>(createdRole, HttpStatus.CREATED);
    }

    @PostMapping("Role/post/All/data")
    public List<Role> postRole(@RequestBody List<Role> roleList){
        return  _roleService.createAll(roleList);

    }
    @PutMapping("Role/update/{roleId}")
    public Role updateRole(@RequestBody Role role,@PathVariable (value = "roleId") int roleId){
        return _roleService.update(role,roleId);

    }
    @GetMapping("Role/get/data/{id}")
    public Role getRole(@PathVariable(value = "id") int Id) {
        return _roleService.findById(Id);
    }
    @GetMapping("Role/get/All/data")
    public List<Role> getRole() {

        return _roleService.findAll();
    }

    @DeleteMapping("Role/delete/{id}")
    public Boolean deleteRole(@PathVariable int id){
        _roleService.deleteById(id);
        return true;

    }

    @DeleteMapping("Role/delete/all")
    public Boolean deleteAllRole(){
        _roleService.deleteAll();
        return true;

    }

}

