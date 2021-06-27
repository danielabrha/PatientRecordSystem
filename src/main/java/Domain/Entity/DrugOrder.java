package Domain.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "drugOrder")
public class DrugOrder {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int Id;
private int amount;
public DrugOrder() {
}
public int getAmount() {
    return amount;
}
public void setAmount(int amount) {
    this.amount = amount;
}
public DrugOrder(int id, int amount) {
    Id = id;
    this.amount = amount;
}
public int getId() {
    return Id;
}
public void setId(int id) {
    Id = id;
}


    // This is from doctor drug
}
