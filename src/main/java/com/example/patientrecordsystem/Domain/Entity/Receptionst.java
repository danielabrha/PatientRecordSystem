package com.example.patientrecordsystem.Domain.Entity;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity(name = "Receptionsts")
public class Receptionst {
    @Id
    @Column(name = "Id")
    private int receptionstId;

//    @JsonIgnoreProperties("receptionst")
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "UserId", referencedColumnName = "Id")
//    private User user;
  //  @JsonManagedReference
//  @JsonIgnoreProperties("receptionst")
//    @OneToMany(mappedBy = "receptionst")
//    private List<Visit> listVisit;

    public Receptionst(int receptionstId) {
        this.receptionstId = receptionstId;
      //  this.user = user;
      //  this.listVisit = listVisit;
    }
//    public Receptionst( List<Visit> listVisit) {
//
//       // this.user = user;
//        //this.listVisit = listVisit;
//    }
    public Receptionst( ) {

    }

    public int getReceptionstId() {
        return receptionstId;
    }

    public void setReceptionstId(int receptionstId) {
        this.receptionstId = receptionstId;
    }
//   // @JsonIgnore
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
   // @JsonManagedReference
//    public List<Visit> getListVisit() {
//        return listVisit;
//    }
//
//    public void setListVisit(List<Visit> listVisit) {
//        this.listVisit = listVisit;
//    }
}

