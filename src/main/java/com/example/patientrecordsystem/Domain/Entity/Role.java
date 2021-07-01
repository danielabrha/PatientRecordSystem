package com.example.patientrecordsystem.Domain.Entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Component
@Entity(name = "roles")
public class Role {
    @Column(name="Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    @Column(name = "roleName")
    private String roleName;

    @ManyToMany(mappedBy ="roleList" )
    private List<User> userList =new ArrayList<>();

    public Role(int roleId, String roleName, List<User> userList) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userList = userList;
    }
    public Role(String roleName, List<User> userList) {

        this.roleName = roleName;
        this.userList = userList;
    }
    public Role() {
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