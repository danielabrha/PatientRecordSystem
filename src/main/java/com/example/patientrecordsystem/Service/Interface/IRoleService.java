package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.Role;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface IRoleService {
    public List<Role> findAll();
    //	public List<Role> findAll(int entryid);
    public List<Role> findAll(String status);
    public Role findById(int id);
    public Role update(Role role, int roleId);
    public void deleteById(int id);
    public void delete(Role role);
    public void deleteAll(Iterable<Role> roles);
    public void deleteAll();
    public Role create(Role role);
    public List<Role> createAll(List<Role> listRole);
}

