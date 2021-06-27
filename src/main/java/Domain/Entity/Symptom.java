package Domain.Entity;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "symptoms")
public class Symptom {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int symptomId;

    @Column(name = "symptom")
    private String symptom;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitId", referencedColumnName = "Id")
    private Visit visit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId", referencedColumnName = "Id")
    private Doctor doctor;

    public Symptom(int symptomId, String symptom, Visit visit, Doctor doctor) {
        this.symptomId = symptomId;
        this.symptom = symptom;
        this.visit = visit;
        this.doctor = doctor;
    }

    public Symptom(String symptom, Visit visit, Doctor doctor) {
        this.symptom = symptom;
        this.visit = visit;
        this.doctor = doctor;
    }

    public  Symptom(){

    }
}
