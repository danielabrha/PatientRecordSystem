package com.example.patientrecordsystem.Service.Implementation;



import com.example.patientrecordsystem.Domain.Entity.Patient;
import com.example.patientrecordsystem.Repository.IPatientRepository;
import com.example.patientrecordsystem.Service.Interface.IPatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {
    private static int minimum = 10000;
    private static int maximum = 99999;
    
    private IPatientRepository _patientRepository;

    @Override
    public List<Patient> findAll() {
        return _patientRepository.findAll();
    }

    @Override
    public List<Patient> findAll(String status) {
        return null;
    }

    @Override
    public Patient findById(int id) {
        return _patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient update(Patient patient, int patientId) {
        Patient existingPatient = _patientRepository.findById(patientId).orElse(null);
        if (existingPatient != null) {
            return _patientRepository.save(existingPatient);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        _patientRepository.deleteById(id);
    }

    @Override
    public void delete(Patient patient) {

    }

    @Override
    public void deleteAll(Iterable<Patient> patients) {

    }

    @Override
    public void deleteAll() {
        _patientRepository.deleteAll();
    }

    @Override
    public Patient create(Patient patient) {
        int cardNumber=(int) ((Math.random() * (maximum - minimum)) + minimum);
        patient.setCardRecordNumber(cardNumber);
        return _patientRepository.save(patient);
    }

    @Override
    public List<Patient> createAll(List<Patient> listPatient) {
        return null;
    }

}
