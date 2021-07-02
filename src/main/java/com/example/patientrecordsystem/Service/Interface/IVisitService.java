package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.Visit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVisitService {
    public List<Visit> findAll();
    //	public List<Visit> findAll(int entryid);
    public List<Visit> findAll(String status);
    public Visit findById(int id);
    public Visit update(Visit visit);
    public void deleteById(int id);
    public void delete(Visit visit);
    public void deleteAll(Iterable<Visit> visits);
    public void deleteAll();
    public Visit create(int patientId);
    public List<Visit> createAll(List<Visit> listVisit, int patientId);
}
