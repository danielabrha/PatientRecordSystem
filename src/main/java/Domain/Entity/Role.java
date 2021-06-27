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
    private int Role_Id;
    @Column(name = "Role_Name")
    private String roleName;

    @ManyToMany(mappedBy ="listOfRole" )
    private List<User> listOfUser=new ArrayList<>();

    public Role() {
    }

    public Role(int role_Id, String roleName, List<User> listOfUser) {
        Role_Id = role_Id;
        this.roleName = roleName;
        this.listOfUser = listOfUser;
    }

    public int getRole_Id() {
        return Role_Id;
    }

    public void setRole_Id(int role_Id) {
        Role_Id = role_Id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getListOfUser() {
        return listOfUser;
    }

    public void setListOfUser(List<User> listOfUser) {
        this.listOfUser = listOfUser;
    }
}
