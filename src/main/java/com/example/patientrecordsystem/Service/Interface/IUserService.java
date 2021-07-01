package com.example.patientrecordsystem.Service.Interface;



import com.example.patientrecordsystem.Domain.Entity.User;
import com.example.patientrecordsystem.Domain.ViewModel.UserViewModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserService {
    public List<User> findAll();
    //	public List<UserViewModel> findAll(int entryid);
    public List<User> findAll(String status);
    public User findById(int id);
    public User update(UserViewModel userViewModel, int userId);
    public void deleteById(int id);
    public void delete(UserViewModel userViewModel);
    public void deleteAll(Iterable<UserViewModel> userViewModels);
    public void deleteAll();
    public User create(User userViewModel);
    public List<User> createAll(List<UserViewModel> listUserViewModel);
}

