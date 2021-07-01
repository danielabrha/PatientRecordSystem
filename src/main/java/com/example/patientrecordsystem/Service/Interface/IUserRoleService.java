package com.example.patientrecordsystem.Service.Interface;



import com.example.patientrecordsystem.Domain.Entity.User;
import com.example.patientrecordsystem.Domain.ViewModel.UserViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IUserRoleService {
    public List<User> findAll();
    public List<User> findAll(String status);
    public User findById(int id);
    public User update(UserViewModel userViewModel);
    public void deleteById(int id);
    public void delete(UserViewModel userViewModel);
    public void deleteAll(Iterable<UserViewModel> userViewModels);
    public void deleteAll();
    public User create(UserViewModel userViewModel);
    public List<User> createAll(List<UserViewModel> listUserViewModel);
}
