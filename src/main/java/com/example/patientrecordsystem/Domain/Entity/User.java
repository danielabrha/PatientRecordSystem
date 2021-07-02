package com.example.patientrecordsystem.Domain.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity(name = "Users")
public class User extends Person {


    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;

//    @JsonIgnoreProperties("userList")
    @ManyToMany
    @JoinTable(name = "userRoles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roleList;
 //   @JsonIgnore
   // @JsonIgnoreProperties("user")
//    @OneToOne(mappedBy = "user")
//    private Doctor doctor;
//   // @JsonIgnore
////    @JsonIgnoreProperties("user")
//    @OneToOne(mappedBy = "user")
//    private Receptionst receptionst;
//  //  @JsonIgnore
////    @JsonIgnoreProperties("user")
//    @OneToOne(mappedBy = "user")
//    private Laboratorist laboratorist;
//
////    @JsonIgnoreProperties("user")
//   // @JsonIgnore
//    @OneToOne(mappedBy = "user")
//    private SystemAdmin systemAdmin;

    public User(String fName, String lName, String mName, String gender, String email,
                String phoneNumber, String address, String dateOfBirth, int userId,
                String userName,String password, List<Role> roleList
               ) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.userId = userId;
        this.userName = userName;
        this.password=password;
        this.roleList = roleList;
//        this.doctor = doctor;
//        this.receptionst = receptionst;
//        this.laboratorist = laboratorist;
//        this.systemAdmin = systemAdmin;
    }

    public User(int userId, String userName,String password, List<Role> roleList) {
        this.userId = userId;
        this.userName = userName;
        this.password=password;
        this.roleList = roleList;
//        this.doctor = doctor;
//        this.receptionst = receptionst;
//        this.laboratorist = laboratorist;
//        this.systemAdmin = systemAdmin;
    }

    public User(String fName, String lName, String mName, String gender, String email,
                String phoneNumber, String address, String dateOfBirth, String userName,String password, List<Role> roleList) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.userName = userName;
        this.password=password;
        this.roleList = roleList;
//        this.doctor = doctor;
//        this.receptionst = receptionst;
//        this.laboratorist = laboratorist;
//        this.systemAdmin = systemAdmin;
    }

    public User(String userName,String password, List<Role> roleList,
                Doctor doctor, Receptionst receptionst, Laboratorist laboratorist, SystemAdmin systemAdmin) {
        this.userName = userName;
        this.password=password;
        this.roleList = roleList;

    }

//    public User(String fName, String lName, String mName, String gender, String email, String phoneNumber,
//                String address, String dateOfBirth, String userName, String password) {
//        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
//        this.userName = userName;
//        this.password = password;
//    }

    public User() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //@JsonManagedReference
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
  //  @JsonIgnore
//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
//   // @JsonIgnore
//    public Receptionst getReceptionst() {
//        return receptionst;
//    }
//
//    public void setReceptionst(Receptionst receptionst) {
//        this.receptionst = receptionst;
//    }
//  // @JsonIgnore
//    public Laboratorist getLaboratorist() {
//        return laboratorist;
//    }
//
//    public void setLaboratorist(Laboratorist laboratorist) {
//        this.laboratorist = laboratorist;
//    }
//   // @JsonIgnore
//    public SystemAdmin getSystemAdmin() {
//        return systemAdmin;
//    }
//
//    public void setSystemAdmin(SystemAdmin systemAdmin) {
//        this.systemAdmin = systemAdmin;
//    }
}
