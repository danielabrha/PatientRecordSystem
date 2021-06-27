package Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

//@Component
@Entity(name = "Users")
public class User extends Person {

    @Column(name = "Id")
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  int userId;

    @Column(name = "userName")
    private  String userName;

    @ManyToMany
    @JoinTable(name="userRoles",
            joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns = @JoinColumn(name="roleId"))
            private List<Role> userList = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Doctor doctor;

    @OneToOne(mappedBy = "user")
    private Receptionst receptionst;


    @OneToOne(mappedBy = "user")
    private Laboratorist laboratorist;


    public User(String fName, String lName, String mName, String gender, String email, String phoneNumber, String address, Date dateOfBirth,String userName) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.userName=userName;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Role> getUserList() {
        return userList;
    }

    public void setUserList(List<Role> userList) {
        this.userList = userList;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
