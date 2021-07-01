package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.SystemAdmin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISystemAdminService {
    public List<SystemAdmin> findAll();
    //	public List<SystemAdmin> findAll(int entryid);
    public List<SystemAdmin> findAll(String status);
    public SystemAdmin findById(int id);
    public SystemAdmin update(SystemAdmin systemAdmin);
    public void deleteById(int id);
    public void delete(SystemAdmin systemAdmin);
    public void deleteAll(Iterable<SystemAdmin> systemAdmins);
    public void deleteAll();
    public SystemAdmin create(SystemAdmin systemAdmin);
    public List<SystemAdmin> createAll(List<SystemAdmin> listSystemAdmin);
}
