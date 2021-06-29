package Domain.ViewModel;

import Domain.Entity.Doctor;
import Domain.Entity.LabTestType;
import Domain.Entity.Visit;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class LabOrderViewModel {

    private int labOrderViewModelId;
    private VisitViewModel visitViewModel;
    private DoctorViewModel doctorViewModel;
    private List<LabTestTypeViewModel> labTestTypeViewModel = new ArrayList<>();

    public int getLabOrderViewModelId() {
        return labOrderViewModelId;
    }

    public void setLabOrderViewModelId(int labOrderViewModelId) {
        this.labOrderViewModelId = labOrderViewModelId;
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
