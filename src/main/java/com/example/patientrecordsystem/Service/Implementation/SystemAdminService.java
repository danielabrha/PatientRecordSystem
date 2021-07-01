package com.example.patientrecordsystem.Service.Implementation;



import com.example.patientrecordsystem.Domain.Entity.SystemAdmin;
import com.example.patientrecordsystem.Repository.ISystemAdminRepository;
import com.example.patientrecordsystem.Service.Interface.ISystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemAdminService implements ISystemAdminService {
    @Autowired
    private ISystemAdminRepository _systemAdminRepository;
    private SystemAdmin systemAdmin;
    @Override
    public List<SystemAdmin> findAll() {
        return _systemAdminRepository.findAll();
    }
    @Override
    public List<SystemAdmin> findAll(String status) {
        return null;
    }
    @Override
    public SystemAdmin findById(int id) {
        return _systemAdminRepository.getById(id);
    }
    @Override
    public SystemAdmin update(SystemAdmin systemAdmin1) {
        SystemAdmin existingSystemAdmin =_systemAdminRepository.findById(systemAdmin1.getSystemAdminId()).orElse(null);
        if(existingSystemAdmin == null) {
            return null;
        }
        systemAdmin.setSystemAdminId(existingSystemAdmin.getSystemAdminId());
        return _systemAdminRepository.save(systemAdmin);
    }
    @Override
    public void deleteById(int id) {
        _systemAdminRepository.deleteById(id);
    }
    @Override
    public void delete(SystemAdmin systemAdmin) {
        systemAdmin=toSystemAdmin(systemAdmin);
        _systemAdminRepository.delete(systemAdmin);

    }
    @Override
    public void deleteAll(Iterable<SystemAdmin> systemAdmins) {

    }
    @Override
    public void deleteAll() {
        _systemAdminRepository.deleteAll();
    }
    @Override
    public SystemAdmin create(SystemAdmin systemAdmin)
    {

        return _systemAdminRepository.save(toSystemAdmin(systemAdmin));
    }
    @Override
    public List<SystemAdmin> createAll(List<SystemAdmin> listSystemAdmin) {
        List<SystemAdmin> systemAdminList=new ArrayList<>();
        listSystemAdmin.forEach(systemAdmin->{
            systemAdminList.add(toSystemAdmin((SystemAdmin) listSystemAdmin));
        });
        return _systemAdminRepository.saveAll(systemAdminList);


    }

    public SystemAdmin toSystemAdmin(SystemAdmin systemAdmin){
        systemAdmin.setSystemAdminId(systemAdmin.getSystemAdminId());
        return systemAdmin;
    }
}

