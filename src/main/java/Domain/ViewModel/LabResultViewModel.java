package Domain.ViewModel;

import org.springframework.stereotype.Component;

import Domain.Entity.LabOrder;
import Domain.Entity.Laboratorist;

@Component
public class LabResultViewModel {

    private int labResultId;
    private String result;
    private Laboratorist laboratorist;
    private LabOrder labOrder;

    public LabResultViewModel(int labResultId, String result, Laboratorist laboratorist, LabOrder labOrder) {
        this.labResultId = labResultId;
        this.result = result;
        this.laboratorist = laboratorist;
        this.labOrder = labOrder;
    }

    public LabResultViewModel() {
    }

    public LabResultViewModel(String result, Laboratorist laboratorist) {
        this.result = result;
        this.laboratorist = laboratorist;
    }

    public LabResultViewModel(String result, Laboratorist laboratorist, LabOrder labOrder) {
        this.result = result;
        this.laboratorist = laboratorist;
        this.labOrder = labOrder;
    }

    public int getLabResultId() {
        return labResultId;
    }

    public void setLabResultId(int labResultId) {
        this.labResultId = labResultId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Laboratorist getLaboratorist() {
        return laboratorist;
    }

    public void setLaboratorist(Laboratorist laboratorist) {
        this.laboratorist = laboratorist;
    }

    public LabOrder getLabOrder() {
        return labOrder;
    }

    public void setLabOrder(LabOrder labOrder) {
        this.labOrder = labOrder;
    }

}
