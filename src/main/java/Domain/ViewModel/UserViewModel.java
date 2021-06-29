package Domain.ViewModel;

import Domain.Entity.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserViewModel extends PersonViewModel {
    private int userId;
    private String userName;
    private String password;
    private List<Role> roleList = new ArrayList<>();
    private Doctor doctor;
    private Receptionst receptionst;
    private Laboratorist laboratorist;
    private SystemAdmin systemAdmin;

    public UserViewModel(String fName, String lName, String mName, String gender, String email,
                         String phoneNumber, String address, Date dateOfBirth,
                         int userId, String userName, String password,
                         List<Role> roleList, Doctor doctor, Receptionst receptionst, Laboratorist laboratorist,
                         SystemAdmin systemAdmin) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;
        this.doctor = doctor;
        this.receptionst = receptionst;
        this.laboratorist = laboratorist;
        this.systemAdmin = systemAdmin;
    }

    public UserViewModel(int userId, String userName, String password, List<Role> roleList, Doctor doctor,
                         Receptionst receptionst, Laboratorist laboratorist, SystemAdmin systemAdmin) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;
        this.doctor = doctor;
        this.receptionst = receptionst;
        this.laboratorist = laboratorist;
        this.systemAdmin = systemAdmin;
    }

    public UserViewModel(String fName, String lName, String mName, String gender, String email,
                         String phoneNumber, String address, Date dateOfBirth, String userName,
                         String password, List<Role> roleList,
                         Doctor doctor, Receptionst receptionst, Laboratorist laboratorist, SystemAdmin systemAdmin) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;
        this.doctor = doctor;
        this.receptionst = receptionst;
        this.laboratorist = laboratorist;
        this.systemAdmin = systemAdmin;
    }

    public UserViewModel(String userName, String password, List<Role> roleList,
                         Doctor doctor, Receptionst receptionst,
                         Laboratorist laboratorist, SystemAdmin systemAdmin) {
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;
        this.doctor = doctor;
        this.receptionst = receptionst;
        this.laboratorist = laboratorist;
        this.systemAdmin = systemAdmin;
    }

    public UserViewModel(String fName, String lName, String mName, String gender, String email,
                         String phoneNumber, String address, Date dateOfBirth) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
    }

    public UserViewModel() {
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
