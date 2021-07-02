package com.example.patientrecordsystem.Domain.Entity;


import net.minidev.json.annotate.JsonIgnore;
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
    @ManyToMany
    @JoinTable(name = "userRoles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roleList = new ArrayList<>();
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Doctor doctor;

    @OneToOne(mappedBy = "user")
    private Receptionst receptionst;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Laboratorist laboratorist;
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private SystemAdmin systemAdmin;

    public User(String fName, String lName, String mName, String gender, String email, String phoneNumber, String address, String dateOfBirth, int userId, String userName,String password, List<Role> roleList, Doctor doctor, Receptionst receptionst, Laboratorist laboratorist, SystemAdmin systemAdmin) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.userId = userId;
        this.userName = userName;
        this.password=password;
        this.roleList = roleList;
        this.doctor = doctor;
        this.receptionst = receptionst;
        this.laboratorist = laboratorist;
        this.systemAdmin = systemAdmin;
    }

    public User(int userId, String userName,String password, List<Role> roleList, Doctor doctor, Receptionst receptionst, Laboratorist laboratorist, SystemAdmin systemAdmin) {
        this.userId = userId;
        this.userName = userName;
        this.password=password;
        this.roleList = roleList;
        this.doctor = doctor;
        this.receptionst = receptionst;
        this.laboratorist = laboratorist;
        this.systemAdmin = systemAdmin;
    }

    public User(String fName, String lName, String mName, String gender, String email,
                String phoneNumber, String address, String dateOfBirth, String userName,String password, List<Role> roleList, Doctor doctor, Receptionst receptionst, Laboratorist laboratorist, SystemAdmin systemAdmin) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.userName = userName;
        this.password=password;
        this.roleList = roleList;
        this.doctor = doctor;
        this.receptionst = receptionst;
        this.laboratorist = laboratorist;
        this.systemAdmin = systemAdmin;
    }

    public User(String userName,String password, List<Role> roleList,
                Doctor doctor, Receptionst receptionst, Laboratorist laboratorist, SystemAdmin systemAdmin) {
        this.userName = userName;
        this.password=password;
        this.roleList = roleList;
        this.doctor = doctor;
        this.receptionst = receptionst;
        this.laboratorist = laboratorist;
        this.systemAdmin = systemAdmin;
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

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Receptionst getReceptionst() {
        return receptionst;
    }

    public void setReceptionst(Receptionst receptionst) {
        this.receptionst = receptionst;
    }

    public Laboratorist getLaboratorist() {
        return laboratorist;
    }

    public void setLaboratorist(Laboratorist laboratorist) {
        this.laboratorist = laboratorist;
    }

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(SystemAdmin systemAdmin) {
        this.systemAdmin = systemAdmin;
    }
}
