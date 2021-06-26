package Domain.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity(name = "visits")
public class Visit {
    @Id
    @Column(name = "Id")
    private int visitId;
    @Column(name = "visitDate")
    private Date visistDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patientId",referencedColumnName = "Id")
    private Patient patient;

}
