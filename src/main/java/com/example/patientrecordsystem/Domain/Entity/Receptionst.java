package com.example.patientrecordsystem.Domain.Entity;



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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    private User user;

    @OneToMany(mappedBy = "receptionst")
    private List<Visit> listVisit = new ArrayList<>();

    public Receptionst(int receptionstId, User user, List<Visit> listVisit) {
        this.receptionstId = receptionstId;
        this.user = user;
        this.listVisit = listVisit;
    }
    public Receptionst(User user, List<Visit> listVisit) {

        this.user = user;
        this.listVisit = listVisit;
    }
    public Receptionst( ) {

    }

    public int getReceptionstId() {
        return receptionstId;
    }

    public void setReceptionstId(int receptionstId) {
        this.receptionstId = receptionstId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Visit> getListVisit() {
        return listVisit;
    }

    public void setListVisit(List<Visit> listVisit) {
        this.listVisit = listVisit;
    }
}

