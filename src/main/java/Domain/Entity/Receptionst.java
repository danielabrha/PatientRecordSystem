package Domain.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "Receptionsts")
public class Receptionst {
    @Id
    @Column(name = "Id")
    private int receptionstId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    private User user;


}
