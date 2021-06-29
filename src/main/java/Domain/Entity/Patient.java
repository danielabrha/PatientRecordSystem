package Domain.Entity;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Entity(name = "Patients")
public class Patient extends Person {

    //Property
    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;


    @Column(name = "cardRecordNumber")
    private int cardRecordNumber;

    // relations
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Visit> visitList = new ArrayList<>();

    public Patient(String fName, String lName, String mName, String gender, String email, String phoneNumber,
                   String address, Date dateOfBirth, int patientId,
                   int cardRecordNumber, List<Visit> visitList) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.patientId = patientId;
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public Patient(int patientId, int cardRecordNumber, List<Visit> visitList) {
        this.patientId = patientId;
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public Patient(String fName, String lName, String mName, String gender, String email,
                   String phoneNumber, String address, Date dateOfBirth,
                   int cardRecordNumber, List<Visit> visitList) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public Patient(int cardRecordNumber, List<Visit> visitList) {
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public Patient(String fName, String lName, String mName, String gender, String email, String phoneNumber, String address, Date dateOfBirth) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
    }

    public Patient() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getCardRecordNumber() {
        return cardRecordNumber;
    }

    public void setCardRecordNumber(int cardRecordNumber) {
        this.cardRecordNumber = cardRecordNumber;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }
}
