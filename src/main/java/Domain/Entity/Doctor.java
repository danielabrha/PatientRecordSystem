package Domain.Entity;

import javax.persistence.*;

//@Component
@Entity(name="Doctors")
public class Doctor {
    @Id
    @Column(name = "Id")
 private int doctorId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    private User user;

    public Doctor(int doctorId, User user) {
        this.doctorId = doctorId;
        this.user = user;
    }

    public Doctor() {
    }
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
