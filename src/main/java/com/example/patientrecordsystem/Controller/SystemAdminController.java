package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.SystemAdmin;
import com.example.patientrecordsystem.Service.Interface.ISystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SystemAdminController {
    @Autowired
    private ISystemAdminService systemAdminService;
    private SystemAdmin systemAdmin;

    @RequestMapping("SystemAdmin/post/data")
    public SystemAdmin postSystemAdmin(@RequestBody SystemAdmin systemAdmin){
        return toSystemAdmin(systemAdminService.create(systemAdmin));
    }
    @RequestMapping("SystemAdmin/update/data")
    public SystemAdmin updateSystemAdmin(@RequestBody SystemAdmin systemAdmin){
        return toSystemAdmin(systemAdminService.update(systemAdmin));
    }
    @RequestMapping("SystemAdmin/delete/data")
    public void deleteAllSystemAdmin(){
        systemAdminService.deleteAll();
    }

    @RequestMapping("SystemAdmin/get/data")
    public List<SystemAdmin> getSystemAdmin(){
        List<SystemAdmin> listSystemAdmin=systemAdminService.findAll();
        List<SystemAdmin> listSystemAdminVM=new ArrayList<>();
        listSystemAdmin.forEach(systemAdminVM->{
            listSystemAdminVM.add( toSystemAdmin(systemAdminVM));
        });
        return listSystemAdminVM;
    }

    public SystemAdmin toSystemAdmin(SystemAdmin systemAdmin){
        this.systemAdmin=new SystemAdmin();
        this.systemAdmin.setSystemAdminId(systemAdmin.getSystemAdminId());
        return this.systemAdmin;
    }
}
