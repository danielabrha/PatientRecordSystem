package Domain.ViewModel;

import Domain.Entity.Visit;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PatientViewModel extends PersonViewModel{
    private int patientId;
    private int cardRecordNumber;
    private List<Visit> visitList = new ArrayList<>();

    public PatientViewModel(String fName, String lName, String mName, String gender,
                            String email, String phoneNumber, String address, Date dateOfBirth,
                            int patientId, int cardRecordNumber, List<Visit> visitList) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.patientId = patientId;
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public PatientViewModel(int patientId, int cardRecordNumber, List<Visit> visitList) {
        this.patientId = patientId;
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public PatientViewModel(String fName, String lName, String mName, String gender, String email, String phoneNumber, String address, Date dateOfBirth, int cardRecordNumber, List<Visit> visitList) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public PatientViewModel(int cardRecordNumber, List<Visit> visitList) {
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public PatientViewModel(String fName, String lName, String mName, String gender, String email, String phoneNumber, String address, Date dateOfBirth) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
    }

    public PatientViewModel() {
        super();
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
