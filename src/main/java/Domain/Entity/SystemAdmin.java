package Domain.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name="SystemAdmins")
public class SystemAdmin {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemAdminId;


}
