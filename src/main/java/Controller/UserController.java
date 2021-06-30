package Controller;

import Domain.Entity.User;
import Domain.ViewModel.UserViewModel;
import Services.Implementation.UserService;
import Services.Interface.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private IUserService _labTestTypeService;
    private User labTestType;
    private List<User> _labTestTypeList;
    private UserViewModel labTestTypeViewModel;
    private List<UserViewModel> _labTestTypeViewModelList;

    public UserController() {
        this._labTestTypeService = new UserService();
        this.labTestType = new User();
        this._labTestTypeList = new ArrayList<>();
        this.labTestTypeViewModel = new UserViewModel();
        this._labTestTypeViewModelList = new ArrayList<>();
    }
    @PostMapping("User/post/data/")
    public User postDurg(@RequestBody UserViewModel labTestTypeVM){
        return _labTestTypeService.create(labTestTypeVM);

    }

    @PostMapping("User/post/All/data/")
    public List<User> postUser(@RequestBody List<UserViewModel> labTestTypeVMList){
        return  _labTestTypeService.createAll(labTestTypeVMList);

    }
    @PutMapping("User/update/{userId}")
    public User updateUser(@RequestBody UserViewModel labTestTypeVM,@PathVariable(value = "userId") int userId){

        return _labTestTypeService.update(labTestTypeVM,userId);

    }
    @GetMapping("/User/get/data/{id}")
    public User getUser(@PathVariable(value = "id") int Id) {
        return _labTestTypeService.findById(Id);
    }
    @GetMapping("/User/get/All/data/")
    public List<User> getUser() {

        return _labTestTypeService.findAll();
    }

    @DeleteMapping("User/delete/{id}")
    public Boolean deleteUser(@PathVariable int id){
        _labTestTypeService.deleteById(id);
        return true;

    }

    @DeleteMapping("User/delete/all")
    public Boolean deleteAllUser(){
        _labTestTypeService.deleteAll();
        return true;

    }

}
