package Domain.Entity;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.List;


@Component
@Entity(name="SystemAdmins")
public class SystemAdmin {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int systemAdminId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userId",referencedColumnName = "Id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="labTestTypeId", referencedColumnName = "Id")
    private List <LabTestType> labTestTypeList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="drugId", referencedColumnName = "Id")
    private List<Drug> drugList;

    public SystemAdmin(int systemAdminId, User user, List<LabTestType> labTestType, List<Drug> drug) {
        this.systemAdminId = systemAdminId;
        this.user = user;
        this.labTestTypeList = labTestType;
        this.drugList = drug;
    }

    public SystemAdmin(User user, List<LabTestType> labTestTypeList, List<Drug> drugList) {
        this.user = user;
        this.labTestTypeList = labTestTypeList;
        this.drugList = drugList;
    }

    public SystemAdmin() {
    }

    public int getSystemAdminId() {
        return systemAdminId;
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
