package Domain.ViewModel;

import Domain.Entity.DrugOrder;
import Domain.Entity.SystemAdmin;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class DrugViewModel {

    private int drugViewModelId;
    private String drugName;
    private String drugCode;
    private SystemAdmin systemAdmin;
    private DrugOrder drugOrder;

    public DrugViewModel(int drugId, String drugName, String drugCode, SystemAdmin systemAdmin, DrugOrder drugOrder) {
        this.drugViewModelId = drugId;
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.systemAdmin = systemAdmin;
        this.drugOrder = drugOrder;
    }

    public DrugViewModel() {
    }

    public int getdrugViewModelId() {
        return drugViewModelId;
    }

    public void setdrugViewModelId(int drugId) {
        this.drugViewModelId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(SystemAdmin systemAdmin) {
        this.systemAdmin = systemAdmin;
    }

    public DrugOrder getDrugOrder() {
        return drugOrder;
    }

    public void setDrugOrder(DrugOrder drugOrder) {
        this.drugOrder = drugOrder;
    }
}
