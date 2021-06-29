package Domain.Entity;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name="Drugs")
public class Drug {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drugId;

    private String drugName;
    private String drugCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "systemAdminId", referencedColumnName = "Id")
    private SystemAdmin systemAdmin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drugList", referencedColumnName = "Id")
    private DrugOrder drugOrder;

    public Drug(int drugId, String drugName, String drugCode, SystemAdmin systemAdmin) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.systemAdmin = systemAdmin;
    }

    public Drug(String drugName, String drugCode, SystemAdmin systemAdmin) {
        this.drugName = drugName;
        this.drugCode = drugCode;
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

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(SystemAdmin systemAdmin) {
        this.systemAdmin = systemAdmin;
    }


}
