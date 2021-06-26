package Domain.Entity;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Entity(name = "Patients")
public class Patient extends  Person{

    //Property
    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    // relations
    @Column(name = "cardRecordNumber")
    private int cardRecordNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Visit> listVisits=new ArrayList<>();
    // contructors
   // setter and getter
}
