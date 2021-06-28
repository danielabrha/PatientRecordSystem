package Domain.ViewModel;

import Domain.Entity.LabOrder;
import Domain.Entity.SystemAdmin;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Component
public class LabTestTypeViewModel {
    private int labTestTypeViewModel_Id;
    private String labTestViewModelName;
    private String labTestViewModelCode;


    private SystemAdmin systemAdmin;

    private LabOrder labOrder;

    public LabTestTypeViewModel(int labTestTypeViewModel_Id, String labTestViewModelName, String labTestViewModelCode, SystemAdmin systemAdmin, LabOrder labOrder) {
        this.labTestTypeViewModel_Id = labTestTypeViewModel_Id;
        this.labTestViewModelName = labTestViewModelName;
        this.labTestViewModelCode = labTestViewModelCode;
        this.systemAdmin = systemAdmin;
        this.labOrder = labOrder;
    }

    public LabTestTypeViewModel() {
    }

    public LabTestTypeViewModel( String labTestViewModelName, String labTestViewModelCode, SystemAdmin systemAdmin, LabOrder labOrder) {
        this.labTestViewModelName = labTestViewModelName;
        this.labTestViewModelCode = labTestViewModelCode;
        this.systemAdmin = systemAdmin;
        this.labOrder = labOrder;
    }

    public int getLabTestTypeViewModel_Id() {
        return labTestTypeViewModel_Id;
    }

    public void setLabTestTypeViewModel_Id(int labTestTypeViewModel_Id) {
        this.labTestTypeViewModel_Id = labTestTypeViewModel_Id;
    }

    public String getLabTestViewModelName() {
        return labTestViewModelName;
    }

    public void setLabTestViewModelName(String labTestViewModelName) {
        this.labTestViewModelName = labTestViewModelName;
    }

    public String getLabTestViewModelCode() {
        return labTestViewModelCode;
    }

    public void setLabTestViewModelCode(String labTestViewModelCode) {
        this.labTestViewModelCode = labTestViewModelCode;
    }

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdminId(SystemAdmin systemAdminId) {
        this.systemAdmin = systemAdmin;
    }

    public LabOrder getLabOrder() {
        return labOrder;
    }

    public void setLabOrder(LabOrder labOrder) {
        this.labOrder = labOrder;
    }
}
