package Domain.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.springframework.stereotype.Component;

@Component
@Entity(name = "labResults")
public class LabResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int labResultId;

    @Column(name = "result")
    private String labResult;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laboratoristId", referencedColumnName = "Id")
    private Laboratorist laboratorist;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "labOrderId", referencedColumnName = "Id")
    private LabOrder labOrder;

    public LabResult() {
    }

    public LabResult(String result, Laboratorist laboratorist, LabOrder labOrder) {
        this.labResult = result;
        this.laboratorist = laboratorist;
        this.labOrder = labOrder;
    }

    public LabResult(int labResultId, String result, Laboratorist laboratorist, LabOrder labOrder) {
        this.labResultId = labResultId;
        this.labResult = result;
        this.laboratorist = laboratorist;
        this.labOrder = labOrder;
    }

    public LabResult(int id, String result) {
        labResultId = id;
        this.labResult = result;
    }

    public LabResult(String result) {
        this.labResult = result;

    }

    public int getLabResultId() {
        return labResultId;
    }

    public void setLabResultId(int id) {
        labResultId = id;
    }

    public String getLabResult() {
        return labResult;
    }

    public void setLabResult(String result) {
        this.labResult = result;
    }

}
