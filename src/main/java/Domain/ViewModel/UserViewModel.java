package Domain.ViewModel;

import Domain.Entity.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class UserViewModel extends PersonViewModel {
    private  int userViewModelId;
    private  String userName;
    private List<RoleViewModel> roleViewModelList = new ArrayList<>();
    private DoctorViewModel doctorViewModel;
    private ReceptionstViewModel receptionstViewModel;
    private LaboratoriestViewModel laboratoriestViewModel;
    private SystemAdminViewModel systemAdminViewModel;
}
