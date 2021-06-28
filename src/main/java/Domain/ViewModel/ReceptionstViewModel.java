package Domain.ViewModel;

import Domain.Entity.User;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Component
public class ReceptionstViewModel {

    private int receptionstViewModelId;
    private UserViewModel userViewModel;
}
