package com.example.patientrecordsystem.Service.Interface;



import com.example.patientrecordsystem.Domain.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IUserRoleService {
    public List<User> findAll();
    public List<User> findAll(String status);
    public User findById(int id);
    public User update(User user);
    public void deleteById(int id);
    public void delete(User user);
    public void deleteAll(Iterable<User> users);
    public void deleteAll();
    public User create(User user);
    public List<User> createAll(List<User> listUser);
}
