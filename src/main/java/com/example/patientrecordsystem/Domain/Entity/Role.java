package com.example.patientrecordsystem.Domain.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Component
@Entity(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int roleId;
    @Column(name = "roleName")
    private String roleName;
    // @JsonManagedReference
//    @JsonIgnoreProperties("roleList")
    @JsonIgnore
    @ManyToMany(mappedBy = "roleList")
    private List<User> userList;

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

    // @JsonManagedReference
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
