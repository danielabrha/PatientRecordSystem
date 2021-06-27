package Domain.Entity;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Component
@Entity(name = "Laboratorists")
public class Laboratorist {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int laboratoristId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "laboratorist") // to be copied from LabResult class
    private List<LabResult> labResultList = new LinkedList<>();

    public Laboratorist(int laboratoristId, User user, List<LabResult> labResultList) {
        this.laboratoristId = laboratoristId;
        this.user = user;
        this.labResultList = labResultList;
    }

    public Laboratorist(User user, List<LabResult> labResultList) {
        this.user = user;
        this.labResultList = labResultList;
    }

    public Laboratorist() {
    }


}
