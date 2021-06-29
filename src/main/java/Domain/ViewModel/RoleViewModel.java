package Domain.ViewModel;

import Domain.Entity.User;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class RoleViewModel {
    private int roleId;
    private String roleName;
    private List<User> userList =new ArrayList<>();

    public RoleViewModel(int roleId, String roleName, List<User> userList) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userList = userList;
    }

    public RoleViewModel(String roleName, List<User> userList) {
        this.roleName = roleName;
        this.userList = userList;
    }

    public RoleViewModel() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
