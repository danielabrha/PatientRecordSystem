package Domain.Entity;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity(name = "Drugs")
public class Drug {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drugId;
    @Column(name = "drugName")
    private String drugName;
    @Column(name = "drugCode")
    private String drugCode;

    @JsonIgnore
    @OneToMany(mappedBy = "drug")
    private List<DrugOrder> drugOrderList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "systemAdminId", referencedColumnName = "Id")
    private SystemAdmin systemAdmin;

    public Drug(int drugId, String drugName, String drugCode, List<DrugOrder> drugOrderList, SystemAdmin systemAdmin) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.drugOrderList = drugOrderList;
        this.systemAdmin = systemAdmin;
    }

    public Drug(String drugName, String drugCode, List<DrugOrder> drugOrderList, SystemAdmin systemAdmin) {
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.drugOrderList = drugOrderList;
        this.systemAdmin = systemAdmin;
    }

    public Drug() {
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
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

    public List<DrugOrder> getDrugOrderList() {
        return drugOrderList;
    }

    public void setDrugOrderList(List<DrugOrder> drugOrderList) {
        this.drugOrderList = drugOrderList;
    }

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(SystemAdmin systemAdmin) {
        this.systemAdmin = systemAdmin;
    }
}
