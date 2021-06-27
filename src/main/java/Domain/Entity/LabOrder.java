package Domain.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "laborders")
public class LabOrder {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labOrderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="visitId", referencedColumnName = "Id")
    private Visit visit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId", referencedColumnName = "Id")
    private Doctor doctor;

    public LabOrder(int labOrderId, Visit visit, Doctor doctor) {
        this.labOrderId = labOrderId;
        this.visit = visit;
        this.doctor = doctor;
    }

    public LabOrder(Visit visit, Doctor doctor) {
        this.visit = visit;
        this.doctor = doctor;
    }

    public LabOrder(){

    }
}
