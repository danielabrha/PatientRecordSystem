package Domain.ViewModel;

import Domain.Entity.Drug;
import Domain.Entity.LabTestType;
import Domain.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class SystemAdminViewModel {
    private int systemAdminViewModel_Id;
    private User user;
    private List<LabTestType> labTestTypeList;
    private List<Drug> drugList;

    public SystemAdminViewModel(int systemAdminViewModel_Id, User user, List<LabTestType> labTestTypeList, List<Drug> drugList) {
        this.systemAdminViewModel_Id = systemAdminViewModel_Id;
        this.user = user;
        this.labTestTypeList = labTestTypeList;
        this.drugList = drugList;
    }

    public SystemAdminViewModel( User user, List<LabTestType> labTestTypeList, List<Drug> drugList) {
        this.user = user;
        this.labTestTypeList = labTestTypeList;
        this.drugList = drugList;
    }

    public SystemAdminViewModel() {
    }

    public int getSystemAdminViewModel_Id() {
        return systemAdminViewModel_Id;
    }

    public void setSystemAdminViewModel_Id(int systemAdminViewModel_Id) {
        this.systemAdminViewModel_Id = systemAdminViewModel_Id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LabTestType> getLabTestType() {
        return labTestTypeList;
    }

    public void setLabTestType(List<LabTestType> labTestType) {
        this.labTestTypeList = labTestType;
    }

    public List<Drug> getDrug() {
        return drugList;
    }

    public void setDrug(List<Drug> drug) {
        this.drugList = drug;
    }
}

