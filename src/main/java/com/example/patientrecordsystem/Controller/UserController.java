package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.User;
import com.example.patientrecordsystem.Domain.ViewModel.UserViewModel;
import com.example.patientrecordsystem.Service.Implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserService _userService;
    private User user;
    private List<User> _userList;
    private UserViewModel userViewModel;
    private List<UserViewModel> _userViewModelList;

    public UserController() {
        this._userService = new UserService();
        this.user = new User();
        this._userList = new ArrayList<>();
        this.userViewModel = new UserViewModel();
        this._userViewModelList = new ArrayList<>();
    }
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping("User/post/data")
    public User postDurg(@RequestBody User userVM){
        return _userService.create(userVM);

    }

    @PostMapping("User/post/All/data")
    public List<User> postUser(@RequestBody List<UserViewModel> userVMList){
        return  _userService.createAll(userVMList);

    }
    @PutMapping("User/update/{userId}")
    public User updateUser(@RequestBody UserViewModel userVM,@PathVariable(value = "userId") int userId){

        return _userService.update(userVM,userId);

    }
    @GetMapping("/User/get/data/{id}")
    public User getUser(@PathVariable(value = "id") int Id) {
        return _userService.findById(Id);
    }

    @GetMapping("User/get/All/data")
    public List<User> getUser() {

        return _userService.findAll();
    }

    @DeleteMapping("User/delete/{id}")
    public Boolean deleteUser(@PathVariable int id){
        _userService.deleteById(id);
        return true;

    }

    @DeleteMapping("User/delete/all")
    public Boolean deleteAllUser(){
        _userService.deleteAll();
        return true;

    }

}

