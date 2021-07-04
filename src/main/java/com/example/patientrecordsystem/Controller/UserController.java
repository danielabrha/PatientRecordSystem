package com.example.patientrecordsystem.Controller;



import com.example.patientrecordsystem.Domain.Entity.User;
import com.example.patientrecordsystem.Service.Implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RestController
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


    @PostMapping(value="/User/post/data")

    public ResponseEntity<User> postUser(@Valid @RequestBody User userVM){
        User createdUser =  _userService.create(userVM);
        return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);

    }
    /*
    public User postUser( @RequestBody User userVM){
        return  _userService.create(userVM);

    }
*/
    @PostMapping("/User/post/All/data")
    public List<User> postUser(@RequestBody List<User> userVMList){
        return  _userService.createAll(userVMList);

    }
    @PutMapping("User/update/{userId}")
    public User updateUser(@RequestBody User userVM,@PathVariable(value = "userId") int userId){

        return _userService.update(userVM,userId);

    }
    @GetMapping("User/get/data/{id}")
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

