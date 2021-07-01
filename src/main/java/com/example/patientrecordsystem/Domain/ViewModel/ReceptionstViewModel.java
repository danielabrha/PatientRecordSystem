package com.example.patientrecordsystem.Domain.ViewModel;


import com.example.patientrecordsystem.Domain.Entity.User;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReceptionstViewModel {
    private int receptionstId;
    private User user;
    private List<Visit> listVisit = new ArrayList<>();

    public ReceptionstViewModel(int receptionstId, User user, List<Visit> listVisit) {
        this.receptionstId = receptionstId;
        this.user = user;
        this.listVisit = listVisit;
    }

    public ReceptionstViewModel(User user, List<Visit> listVisit) {
        this.user = user;
        this.listVisit = listVisit;
    }

    public ReceptionstViewModel() {
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

