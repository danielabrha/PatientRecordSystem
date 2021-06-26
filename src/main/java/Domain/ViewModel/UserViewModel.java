package Domain.ViewModel;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class UserViewModel extends PersonViewModel {

    private  int User_Id;

    private  String userName;

    private List<RoleViewModel> listOfRole = new LinkedList<>();
    private DoctorViewModel doctorViewModel;

    public UserViewModel(String fName, String lName, String mName, String gender, String email, String phoneNumber, String address, Date dateOfBirth, String userName) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.userName=userName;
    }

    public UserViewModel() {
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

    public List<RoleViewModel> getListOfRole() {
        return listOfRole;
    }

    public void setListOfRole(List<RoleViewModel> listOfRole) {
        this.listOfRole = listOfRole;
    }

    public DoctorViewModel getDoctor() {
        return doctorViewModel;
    }

    public void setDoctor(DoctorViewModel doctor) {
        this.doctorViewModel = doctor;
    }
}
