package Domain.Entity;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name="Drugs")
public class Drug {
    @Id
    @Column(name="Id")
    private Long drugId;

    private String drugName;
    
    @ManyToOne
    @JoinColumn(name="systemAdmin_id")
    private SystemAdmin systemAdmin;

    public Drug(Long drugId, String drugName, SystemAdmin systemAdmin) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.systemAdmin = systemAdmin;
    }

    public Drug(String drugName, SystemAdmin systemAdmin) {
        this.drugName = drugName;
        this.systemAdmin = systemAdmin;
    }

    public Drug() {
    }

}
