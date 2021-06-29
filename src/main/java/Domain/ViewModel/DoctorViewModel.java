package Domain.ViewModel;

import Domain.Entity.LabOrder;
import Domain.Entity.Symptom;
import Domain.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorViewModel {

    private int doctorViewModelId;
    private User user;
    private List<LabOrder> labOrderList = new ArrayList<>();
    private List<Symptom> symptomList = new ArrayList<>();

    public DoctorViewModel(int doctorViewModelId, User user, List<LabOrder> labOrderList, List<Symptom> symptomList) {
        this.doctorViewModelId = doctorViewModelId;
        this.user = user;
        this.labOrderList = labOrderList;
        this.symptomList = symptomList;
    }

    public DoctorViewModel(User user, List<LabOrder> labOrderList, List<Symptom> symptomList) {
        this.user = user;
        this.labOrderList = labOrderList;
        this.symptomList = symptomList;
    }

    public DoctorViewModel() {
    }

    public int getdoctorViewModelId() {
        return doctorViewModelId;
    }

    public void setdoctorViewModelId(int doctorViewModelId) {
        this.doctorViewModelId = doctorViewModelId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LabOrder> getLabOrderList() {
        return labOrderList;
    }

    public void setLabOrderList(List<LabOrder> labOrderList) {
        this.labOrderList = labOrderList;
    }

    public List<Symptom> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(List<Symptom> symptomList) {
        this.symptomList = symptomList;
    }
}
