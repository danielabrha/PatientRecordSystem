package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.Receptionst;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IReceptionsService {
    public List<Receptionst> findAll();
    //	public List<Receptionst> findAll(int entryid);
    public List<Receptionst> findAll(String status);
    public Receptionst findById(int id);
    public Receptionst update(Receptionst receptionst);
    public void deleteById(int id);
    public void delete(Receptionst receptionst);
    public void deleteAll(Iterable<Receptionst> receptionsts);
    public void deleteAll();
    public Receptionst create(Receptionst receptionst);
    public List<Receptionst> createAll(List<Receptionst> listReceptionst);
}
