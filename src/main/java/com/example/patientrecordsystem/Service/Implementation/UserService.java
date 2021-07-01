package com.example.patientrecordsystem.Service.Implementation;



import com.example.patientrecordsystem.Domain.Entity.User;
import com.example.patientrecordsystem.Domain.ViewModel.UserViewModel;
import com.example.patientrecordsystem.Repository.IUserRepository;
import com.example.patientrecordsystem.Service.Interface.IRoleService;
import com.example.patientrecordsystem.Service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class UserService implements IUserService {
    @Autowired
    private IUserRepository _userRepository;
    @Autowired
    private List<User> listUser;
    //    @Autowired
    private IRoleService _roleService;
    User user;

    public UserService() {
        listUser = new ArrayList<>();
        _roleService = new RoleService();
    }

    @Override
    public List<User> findAll() {

        return _userRepository.findAll();
    }

    @Override
    public List<User> findAll(String status) {
        return _userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return _userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(UserViewModel userViewModel, int userId) {
        User existingUser = _userRepository.findById(userId).orElse(null);
        // User existingUser=_userRepository.findById(userViewModel.getUserId()).orElse(null);
        if (existingUser != null) {
            existingUser = toUser(userViewModel);
            existingUser.setUserId(userViewModel.getUserId());
            return _userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        _userRepository.deleteById(id);
    }

    @Override
    public void delete(UserViewModel userViewModel) {

    }

    @Override
    public void deleteAll(Iterable<UserViewModel> userViewModels) {

    }

    @Override
    public void deleteAll() {
        _userRepository.deleteAll();
    }

    @Override
    public User create(User userViewModel) {
        User newUser = userViewModel;
        newUser.setDateOfBirth("");
        newUser.setUserName(userViewModel.getEmail());
        newUser.setPassword("123@123");
        return _userRepository.save(newUser);
    }

    @Override
    public List<User> createAll(List<UserViewModel> listUserViewModel) {
        List<User> userList = new ArrayList<>();
        listUserViewModel.forEach(userViewModel -> {
            userList.add(toUser(userViewModel));
        });
        return _userRepository.saveAll(userList);

    }

    public User toUser(UserViewModel userViewModel) {
        User user = new User();
        String lett = userViewModel.getfName();
        //this.user.setUserName(userViewModel.getUserName());
        user.setfName(userViewModel.getfName());
        user.setlName(userViewModel.getlName());
        user.setmName(userViewModel.getmName());
        user.setAddress(userViewModel.getAddress());
        user.setEmail(userViewModel.getEmail());
        user.setGender(userViewModel.getGender());
        user.setDateOfBirth(userViewModel.getDateOfBirth());
        user.setPhoneNumber(userViewModel.getPhoneNumber());

        //user.setListOfRole(listRole);
        return user;
    }
}

