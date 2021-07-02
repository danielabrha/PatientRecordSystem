package com.example.patientrecordsystem.Service.Implementation;
import com.example.patientrecordsystem.Domain.Entity.User;
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
    public User update(User user, int userId) {
        User existingUser = _userRepository.findById(userId).orElse(null);
        // User existingUser=_userRepository.findById(user.getUserId()).orElse(null);
        if (existingUser != null) {

            if (user.getfName() != null)
                existingUser.setfName(user.getfName());
            if (user.getlName() != null)
                existingUser.setlName(user.getlName());
            if (user.getmName() != null)
                existingUser.setmName(user.getmName());
            if (user.getEmail() != null)
                existingUser.setEmail(user.getEmail());
            if (user.getGender() != null)
                existingUser.setGender(user.getGender());
            if (user.getPhoneNumber() != null)
                existingUser.setPhoneNumber(user.getPhoneNumber());
            if (user.getDateOfBirth() != null)
                existingUser.setDateOfBirth(user.getDateOfBirth());
            if (user.getAddress() != null)
                existingUser.setDateOfBirth(user.getAddress());

            return _userRepository.save(existingUser);
        }

        return null;
    }

    @Override
    public void deleteById(int id) {
        _userRepository.deleteById(id);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteAll(Iterable<User> users) {

    }

    @Override
    public void deleteAll() {
        _userRepository.deleteAll();
    }

    @Override
    public User create(User user) {
        user.setDateOfBirth("");
        user.setUserName(user.getEmail());
        user.setPassword("123@123");
        return _userRepository.save(user);
    }

    @Override
    public List<User> createAll(List<User> listUser) {
        List<User> userList = new ArrayList<>();
        listUser.forEach(user -> {
            user.setUserName(user.getEmail());
            user.setPassword("123@123");
            user.setDateOfBirth("");
            userList.add(user);
        });
        return _userRepository.saveAll(userList);

    }


}

