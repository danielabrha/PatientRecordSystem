package com.example.patientrecordsystem.Service.Implementation;



import com.example.patientrecordsystem.Domain.Entity.SystemAdmin;
import com.example.patientrecordsystem.Domain.ViewModel.SystemAdminViewModel;
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
    private SystemAdminViewModel systemAdminViewModel;
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
    public SystemAdmin update(SystemAdminViewModel systemAdminViewModel1) {
        SystemAdmin existingSystemAdmin =_systemAdminRepository.findById(systemAdminViewModel1.getSystemAdminId()).orElse(null);
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
    public void delete(SystemAdminViewModel systemAdminViewModel) {
        systemAdmin=toSystemAdmin(systemAdminViewModel);
        _systemAdminRepository.delete(systemAdmin);

    }
    @Override
    public void deleteAll(Iterable<SystemAdminViewModel> systemAdminViewModels) {

    }
    @Override
    public void deleteAll() {
        _systemAdminRepository.deleteAll();
    }
    @Override
    public SystemAdmin create(SystemAdminViewModel systemAdminViewModel)
    {

        return _systemAdminRepository.save(toSystemAdmin(systemAdminViewModel));
    }
    @Override
    public List<SystemAdmin> createAll(List<SystemAdminViewModel> listSystemAdminViewModel) {
        List<SystemAdmin> systemAdminList=new ArrayList<>();
        listSystemAdminViewModel.forEach(systemAdmin->{
            systemAdminList.add(toSystemAdmin((SystemAdminViewModel) listSystemAdminViewModel));
        });
        return _systemAdminRepository.saveAll(systemAdminList);


    }

    public SystemAdmin toSystemAdmin(SystemAdminViewModel systemAdminViewModel){
        systemAdmin.setSystemAdminId(systemAdminViewModel.getSystemAdminId());
        return systemAdmin;
    }
}

