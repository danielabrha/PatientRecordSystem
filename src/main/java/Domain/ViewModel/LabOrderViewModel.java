package Domain.ViewModel;

import Domain.Entity.Doctor;
import Domain.Entity.Visit;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class LabOrderViewModel {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labOrderViewModelId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="visitViewModelId", referencedColumnName = "Id")
    private VisitViewModel visitViewModel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorViewModelId", referencedColumnName = "Id")
    private DoctorViewModel doctorViewModel;
}
