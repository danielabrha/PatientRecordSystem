package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.Laboratorist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILaboratoristService {
    public List<Laboratorist> findAll();
    //	public List<Laboratories> findAll(int entryid);
    public List<Laboratorist> findAll(String status);
    public Laboratorist findById(int id);
    public Laboratorist update(Laboratorist laboratorist);
    public void deleteById(int id);
    public void delete(Laboratorist laboratorist);
    public void deleteAll(Iterable<Laboratorist> laboratorists);
    public void deleteAll();
    public Laboratorist create(Laboratorist laboratorist);
    public List<Laboratorist> createAll(List<Laboratorist> listLaboratorist);
}

