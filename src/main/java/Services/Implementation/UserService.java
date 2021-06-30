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
    public User update(UserViewModel userViewModel,int userId) {
        User existingUser=_userRepository.findById(userId).orElse(null);
       // User existingUser=_userRepository.findById(userViewModel.getUserId()).orElse(null);
        if(existingUser !=null){
            existingUser=  toUser(userViewModel);
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
    public User create(UserViewModel userViewModel) {
     User newUser=toUser(userViewModel);
        newUser.setUserName(userViewModel.getEmail());
        newUser.setPassword("123@123");
        return _userRepository.save(newUser);
    }

    @Override
    public List<User> createAll(List<UserViewModel> listUserViewModel) {
        List<User> userList=new ArrayList<>();
        listUserViewModel.forEach(userViewModel->{
            userList.add(toUser(userViewModel));
        });
        return  _userRepository.saveAll(userList);

    }
    public User toUser(UserViewModel userViewModel) {
        User user = new User();

       //this.user.setUserName(userViewModel.getUserName());
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
