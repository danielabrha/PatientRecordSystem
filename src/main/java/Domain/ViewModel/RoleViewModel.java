package Domain.ViewModel;

import Domain.Entity.User;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;

@Component
public class RoleViewModel {
    @Column(name="Id")
    @Id
    private int RoleViewModel_Id;
    @Column(name = "RoleViewModel_Name")
    private String roleName;

    @ManyToMany(mappedBy ="listOfRoleViewModel" )
    private List<User> listOfUser=new LinkedList<>();

    public RoleViewModel() {
    }

    public RoleViewModel(int role_Id, String roleName, List<User> listOfUser) {
        RoleViewModel_Id = role_Id;
        this.roleName = roleName;
        this.listOfUser = listOfUser;
    }

    public int getRoleViewModel_Id() {
        return RoleViewModel_Id;
    }

    public void setRoleViewModel_Id(int role_Id) {
        RoleViewModel_Id = role_Id;
    }

    public String getRoleViewModelName() {
        return roleName;
    }

    public void setRoleViewModelName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getListOfUser() {
        return listOfUser;
    }

    public void setListOfUser(List<User> listOfUser) {
        this.listOfUser = listOfUser;
    }
}
