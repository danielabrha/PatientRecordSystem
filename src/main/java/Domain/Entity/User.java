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
    private  int User_Id;

    @Column(name = "User_Name")
    private  String userName;

    @ManyToMany
    @JoinTable(name="UserRoles",
            joinColumns=@JoinColumn(name="User_Id"),
            inverseJoinColumns = @JoinColumn(name="Role_Id"))
            private List<Role> listOfRole = new ArrayList<>();
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Doctor doctor;
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Receptionst receptionst;

    public User(String fName, String lName, String mName, String gender, String email, String phoneNumber, String address, Date dateOfBirth,String userName) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.userName=userName;
    }

    public User() {
    }

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Role> getListOfRole() {
        return listOfRole;
    }

    public void setListOfRole(List<Role> listOfRole) {
        this.listOfRole = listOfRole;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
