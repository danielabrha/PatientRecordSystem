package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPatientService {
    public List<Patient> findAll();
    //	public List<Patient> findAll(int entryid);
    public List<Patient> findAll(String status);
    public Patient findById(int id);
    public Patient update(Patient patient, int patientId);
    public void deleteById(int id);
    public void delete(Patient patient);
    public void deleteAll(Iterable<Patient> patients);
    public void deleteAll();
    public Patient create(Patient patient);
    public List<Patient> createAll(List<Patient> listPatient);
}

