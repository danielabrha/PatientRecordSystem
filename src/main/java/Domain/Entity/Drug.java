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
    private Long drugId;

    private String drugName;
    private String drugCode;
    
    @ManyToOne
    @JoinColumn(name="systemAdminId")
    private SystemAdmin systemAdmin;

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
}
