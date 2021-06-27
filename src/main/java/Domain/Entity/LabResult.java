package Domain.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "labResult")
public class LabResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private int Id;

    @Column(name = "result")
    private String result;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laboratoristId",referencedColumnName = "Id")
    private Laboratorist laboratorist;


    public LabResult() {
    }
    public LabResult(int id, String result) {
        Id = id;
        this.result = result;
    }
    public LabResult(String result) {
        this.result = result;
 
   }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    

}
