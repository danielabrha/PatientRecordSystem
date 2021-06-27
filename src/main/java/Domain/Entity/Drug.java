package Domain.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name="Drugs")
public class Drug {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugId;

    private String drugName;
    private String drugCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "systemAdminId", referencedColumnName = "Id")
    private SystemAdmin systemAdmin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drugListId", referencedColumnName = "Id")
    private DrugOrder drugOrder;

    public Drug(Long drugId, String drugName, String drugCode, SystemAdmin systemAdmin) {
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

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
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
