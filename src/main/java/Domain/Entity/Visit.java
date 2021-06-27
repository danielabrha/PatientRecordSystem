package Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//
@Component
@Entity(name = "visits")
public class Visit {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visitId;

    @Column(name = "visitDate")
    private Date visitDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patientId",referencedColumnName = "Id")
    private Patient patient;

    @JsonIgnore
    @OneToMany(mappedBy = "visit")
    private List<LabOrder> labOrderList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "visit")
    private List<Symptom> symptomList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "visit")
    private List<DrugOrder> drugOrderList = new ArrayList<>();



}
