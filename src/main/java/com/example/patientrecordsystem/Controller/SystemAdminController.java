package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.SystemAdmin;
import com.example.patientrecordsystem.Domain.ViewModel.SystemAdminViewModel;
import com.example.patientrecordsystem.Service.Interface.ISystemAdminService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SystemAdminController {

    private ISystemAdminService systemAdminService;
    private SystemAdminViewModel systemAdminViewModel;
    private SystemAdmin systemAdmin;

    @RequestMapping("SystemAdmin/post/data")
    public SystemAdminViewModel postSystemAdmin(@RequestBody SystemAdminViewModel systemAdminViewModel){
        return toSystemAdminViewModel(systemAdminService.create(systemAdminViewModel));
    }
    @RequestMapping("SystemAdmin/update/data")
    public SystemAdminViewModel updateSystemAdmin(@RequestBody SystemAdminViewModel systemAdminViewModel){
        return toSystemAdminViewModel(systemAdminService.update(systemAdminViewModel));
    }
    @RequestMapping("SystemAdmin/delete/data")
    public void deleteAllSystemAdmin(){
        systemAdminService.deleteAll();
    }

    @RequestMapping("SystemAdmin/get/data")
    public List<SystemAdminViewModel> getSystemAdmin(){
        List<SystemAdmin> listSystemAdmin=systemAdminService.findAll();
        List<SystemAdminViewModel> listSystemAdminVM=new ArrayList<>();
        listSystemAdmin.forEach(systemAdminVM->{
            listSystemAdminVM.add( toSystemAdminViewModel(systemAdminVM));
        });
        return listSystemAdminVM;
    }

    public SystemAdminViewModel toSystemAdminViewModel(SystemAdmin systemAdmin){
        this.systemAdminViewModel=new SystemAdminViewModel();
        this.systemAdminViewModel.setSystemAdminId(systemAdmin.getSystemAdminId());
        return this.systemAdminViewModel;
    }
}
