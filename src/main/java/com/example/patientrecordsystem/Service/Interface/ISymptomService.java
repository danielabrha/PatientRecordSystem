package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.Symptom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISymptomService {
    public List<Symptom> findAll();
    //	public List<Symptom> findAll(int entryid);
    public List<Symptom> findAll(String status);
    public Symptom findById(int id);
    public Symptom update(Symptom symptom);
    public void deleteById(int id);
    public void delete(Symptom symptom);
    public void deleteAll(Iterable<Symptom> symptoms);
    public void deleteAll();
    public Symptom create(Symptom symptom, int doctorId, int visitId);
    public List<Symptom> createAll(List<Symptom> listSymptom, int visitId,
                                   int doctorId);
}
