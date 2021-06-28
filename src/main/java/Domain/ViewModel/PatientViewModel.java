package Domain.ViewModel;

import Domain.Entity.Visit;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PatientViewModel {

    private int patientViewModelId;
    private int cardRecordNumber;
    private List<VisitViewModel> visitViewModelList=new ArrayList<>();
}
