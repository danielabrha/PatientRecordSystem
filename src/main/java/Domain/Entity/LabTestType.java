package Domain.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component
@Entity(name="LabTestTypes")
public class LabTestType {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labTestTypeId;
    private String labTestName;
    private String labTestCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="systemAdminId", referencedColumnName = "Id")
    private SystemAdmin systemAdmin;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="labOrderId", referencedColumnName  ="Id")
    private LabOrder labOrder;

    public LabTestType(int labTestTypeId, String labTestName, String labTestCode, SystemAdmin systemAdmin, LabOrder labOrder) {
        this.labTestTypeId = labTestTypeId;
        this.labTestName = labTestName;
        this.labTestCode = labTestCode;
        this.systemAdmin = systemAdmin;
        this.labOrder = labOrder;
    }

    public LabTestType() {
    }

    public LabTestType(String labTestName, String labTestCode, SystemAdmin systemAdmin, LabOrder labOrder) {
        this.labTestName = labTestName;
        this.labTestCode = labTestCode;
        this.systemAdmin = systemAdmin;
        this.labOrder = labOrder;
    }

    public int getLabTestTypeId() {
        return labTestTypeId;
    }



    public String getLabTestName() {
        return labTestName;
    }

    public void setLabTestName(String labTestName) {
        this.labTestName = labTestName;
    }

    public String getLabTestCode() {
        return labTestCode;
    }

    public void setLabTestCode(String labTestCode) {
        this.labTestCode = labTestCode;
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
