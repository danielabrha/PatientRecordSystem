package Domain.ViewModel;

import org.springframework.stereotype.Component;

@Component
public class DoctorViewModel {

    private int doctorId;

    private UserViewModel userViewModel;

    public DoctorViewModel(int doctorId, UserViewModel userViewModel) {
        this.doctorId = doctorId;
        this.userViewModel = userViewModel;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public UserViewModel getUser() {
        return userViewModel;
    }

    public void setUser(UserViewModel user) {
        this.userViewModel = user;
    }
}
