package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.SystemAdmin;
import com.example.patientrecordsystem.Domain.ViewModel.SystemAdminViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISystemAdminService {
    public List<SystemAdmin> findAll();
    //	public List<SystemAdminViewModel> findAll(int entryid);
    public List<SystemAdmin> findAll(String status);
    public SystemAdmin findById(int id);
    public SystemAdmin update(SystemAdminViewModel systemAdminViewModel);
    public void deleteById(int id);
    public void delete(SystemAdminViewModel systemAdminViewModel);
    public void deleteAll(Iterable<SystemAdminViewModel> systemAdminViewModels);
    public void deleteAll();
    public SystemAdmin create(SystemAdminViewModel systemAdminViewModel);
    public List<SystemAdmin> createAll(List<SystemAdminViewModel> listSystemAdminViewModel);
}
