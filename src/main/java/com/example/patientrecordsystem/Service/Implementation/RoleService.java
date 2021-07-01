package com.example.patientrecordsystem.Service.Implementation;


import com.example.patientrecordsystem.Domain.Entity.Role;
import com.example.patientrecordsystem.Repository.IRoleRepository;
import com.example.patientrecordsystem.Service.Interface.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository _roleRepository;

    private List<Role> roleList;

    public RoleService() {
        roleList = new ArrayList<>();
    }

    @Override
    public List<Role> findAll() {
        return _roleRepository.findAll();
    }

    @Override
    public List<Role> findAll(String status) {
        return _roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return _roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role update(Role role, int roleId) {
        Role previousRole = _roleRepository.findById(roleId).orElse(null);
        // Role previousRole = _roleRepository.findById(role.getRoleId()).orElse(null);
        if (previousRole != null) {
            previousRole.setRoleName(role.getRoleName());
            return _roleRepository.save(previousRole);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        _roleRepository.deleteById(id);
    }

    @Override
    public void delete(Role role) {
        Role previousRole = _roleRepository.findById(role.getRoleId()).orElse(null);
        if (previousRole != null) {
            _roleRepository.deleteById(previousRole.getRoleId());
        }

    }

    @Override
    public void deleteAll(Iterable<Role> roles) {

        roles.forEach(role -> {
            Role role1 = _roleRepository.findById(role.getRoleId()).orElse(null);
            if (role != null)
                _roleRepository.deleteById(role.getRoleId());

        });

    }

    @Override
    public void deleteAll() {
        _roleRepository.deleteAll();
    }

    @Override
    public Role create(Role role) {
        return _roleRepository.save(role);
    }

    @Override
    public List<Role> createAll(List<Role> roleList) {
        List<Role> _listRole = new ArrayList<>();
        roleList.forEach(roleVM -> {
            _listRole.add(toRole(roleVM));
        });
        return _roleRepository.saveAll(_listRole);

    }

    public Role toRole(Role role) {
        role.setRoleName(role.getRoleName());
        return role;
    }
}
