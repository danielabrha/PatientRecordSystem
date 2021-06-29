package Domain.ViewModel;

import Domain.Entity.LabResult;
import Domain.Entity.User;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class LaboratoristViewModel {
    private int laboratoristId;

    private User user;

    private List<LabResult> labResultList = new ArrayList<>();

    public LaboratoristViewModel(int laboratoristId, User user, List<LabResult> labResultList) {
        this.laboratoristId = laboratoristId;
        this.user = user;
        this.labResultList = labResultList;
    }

    public LaboratoristViewModel(User user, List<LabResult> labResultList) {
        this.user = user;
        this.labResultList = labResultList;
    }

    public LaboratoristViewModel() {
    }

    public int getLaboratoristId() {
        return laboratoristId;
    }

    public void setLaboratoristId(int laboratoristId) {
        this.laboratoristId = laboratoristId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LabResult> getLabResultList() {
        return labResultList;
    }

    public void setLabResultList(List<LabResult> labResultList) {
        this.labResultList = labResultList;
    }
}
