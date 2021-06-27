package Domain.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//@Component
@Entity(name = "roles")
public class Role {
    @Column(name="Id")
    @Id
    private int roleId;
    @Column(name = "roleName")
    private String roleName;

    @ManyToMany(mappedBy ="userList" )
    private List<User> userList =new ArrayList<>();

    public Role() {
    }

    public Role(int roleId, String roleName, List<User> userList) {
        roleId = roleId;
        this.roleName = roleName;
        this.userList = userList;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        roleId = roleId;
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
