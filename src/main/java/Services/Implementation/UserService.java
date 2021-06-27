package Services.Implementation;

import Domain.Entity.Role;
import Domain.Entity.User;
import Domain.ViewModel.UserViewModel;
import Repository.IUserRepository;
import Services.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository _userRepository;
    @Autowired
    private List<User> listUser;
//    @Autowired
    private RoleService _roleService;
    User user;
    public UserService(){
        listUser=new ArrayList<>();
        _roleService=new RoleService();
    }
    @Override
    public List<User> findAll() {
        return null;
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
    public UserViewModel update(UserViewModel userViewModel) {
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
    public User create(UserViewModel userViewModel) {
       // List<Role> listRole=new ArrayList<>();
       // Role role=_roleService.findById(roleId);
        List<Role> listRoles=new ArrayList<>();
        userViewModel.getListOfRole().forEach(role->{
            listRoles.add(_roleService.toRole(role));
        });
       // listRole.add(role);
        User user=toUser(userViewModel);
        user.setRoleList(listRoles);

        user= _userRepository.save(user);
//if(role.getRoleName().equals("Doctor")){
//
//}
//        if(role.getRoleName().equals("Doctor")){
//
//        }
//        if(role.getRoleName().equals("Receptions")){
//
//        }
//        if(role.getRoleName().equals("Laboratoriest")){
//
//        }
//        if(role.getRoleName().equals("Laboratoriest")){
//
//        }
         return user;
    }

    @Override
    public List<User> createAll(List<UserViewModel> listUserViewModel) {

//        listUserViewModel.forEach(userVM -> {
//            this.listUser.add(toUser(userVM));
//        });
//        return _userRepository.saveAll(this.listUser);
        return  null;

    }
    public User toUser(UserViewModel userViewModel) {
        User user = new User();

        this.user.setUserName(userViewModel.getUserName());
        this.user.setfName(userViewModel.getfName());
        this.user.setlName(userViewModel.getlName());
        this.user.setmName(userViewModel.getmName());
        this.user.setAddress(userViewModel.getAddress());
        this.user.setEmail(userViewModel.getEmail());
        this.user.setGender(userViewModel.getGender());
        this.user.setDateOfBirth(userViewModel.getDateOfBirth());
        this.user.setPhoneNumber(userViewModel.getPhoneNumber());

        //user.setListOfRole(listRole);
        return this.user;
    }
}
