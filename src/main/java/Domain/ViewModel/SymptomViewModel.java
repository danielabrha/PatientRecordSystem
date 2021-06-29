package Domain.ViewModel;

import Domain.Entity.Doctor;
import Domain.Entity.Visit;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class SymptomViewModel {
    private int symptomViewModeId;
    private String symptomViewModelName;
    private VisitViewModel visitViewModel;
    private DoctorViewModel doctorViewModel;

    public int getSymptomViewModeId() {
        return symptomViewModeId;
    }

    public void setSymptomViewModelId(int symptomViewModeId) {
        this.symptomViewModeId = symptomViewModeId;
    }

    public String getSymptomViewModelName() {
        return symptomViewModelName;
    }

    public void setSymptomViewModelName(String symptomViewModelName) {
        this.symptomViewModelName = symptomViewModelName;
    }

    public VisitViewModel getVisitViewModel() {
        return visitViewModel;
    }

    public void setVisitViewModel(VisitViewModel visitViewModel) {
        this.visitViewModel = visitViewModel;
    }

    public DoctorViewModel getDoctorViewModel() {
        return doctorViewModel;
    }

    public void setDoctorViewModel(DoctorViewModel doctorViewModel) {
        this.doctorViewModel = doctorViewModel;
    }
}
