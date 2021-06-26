package Services.Implementation;

import Domain.Entity.User;
import Domain.ViewModel.UserViewModel;
import Services.Interface.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(String status) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public UserViewModel update(UserViewModel userViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(UserViewModel userViewModel) {

    }

    @Override
    public void deleteAll(Iterable<UserViewModel> userViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public User create(UserViewModel userViewModel) {
        return null;
    }

    @Override
    public List<User> createAll(List<UserViewModel> listUserViewModel) {
        return null;
    }
}
