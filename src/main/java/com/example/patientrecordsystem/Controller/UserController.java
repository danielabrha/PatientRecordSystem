package com.example.patientrecordsystem.Controller;


import com.example.patientrecordsystem.Domain.Entity.User;
import com.example.patientrecordsystem.Domain.ViewModel.UserViewModel;
import com.example.patientrecordsystem.Service.Implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService _userService;
    private User user;
    private List<User> _userList;

    public UserController() {
        this._userService = new UserService();
        this.user = new User();
        this._userList = new ArrayList<>();
        this.user = new User();
        this._userList = new ArrayList<>();
    }


    @PostMapping(value = "post/data")
    public ResponseEntity<User> postUser(@Valid @RequestBody User userVM){
        User createdUser =  _userService.create(userVM);
        return new ResponseEntity<User>(createdUser,HttpStatus.OK);

    }

    @PostMapping("/User/post/All/data")
    public List<User> postUser(@RequestBody List<User> userVMList){
        return  _userService.createAll(userVMList);

    }

    @PutMapping("update/{userId}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User userVM, @PathVariable(value = "userId") int userId) {

        return new ResponseEntity<User>(_userService.update(userVM, userId),HttpStatus.OK);


    }

    @GetMapping("get/data/{id}")
    public User getUser(@PathVariable(value = "id") int Id) {
        return _userService.findById(Id);
    }

    @GetMapping("get/All/data")
    public List<User> getUser() {

        return _userService.findAll();
    }

    @DeleteMapping("delete/{id}")
    public Boolean deleteUser(@PathVariable int id) {
        _userService.deleteById(id);
        return true;

    }

    @DeleteMapping("delete/all")
    public Boolean deleteAllUser() {
        _userService.deleteAll();
        return true;

    }

    // user and role
    @PostMapping("userrole/{roleId}")
    public User assignRoleToUser(@RequestBody UserViewModel user,
                                 @PathVariable(value = "roleId") int roleId) {
        return _userService.assignRoleToUser(user, roleId);
    }

}

