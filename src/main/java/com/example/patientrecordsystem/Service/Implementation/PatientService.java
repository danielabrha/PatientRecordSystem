package com.example.patientrecordsystem.Service.Implementation;



import com.example.patientrecordsystem.Domain.Entity.Patient;
import com.example.patientrecordsystem.Domain.ViewModel.PatientViewModel;
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
    public Patient update(PatientViewModel patientViewModel, int patientId) {
        Patient existingPatient = _patientRepository.findById(patientId).orElse(null);
//        Patient existingPatient = _patientRepository.findById(patientViewModel.getPatientId()).orElse(null);
        if (existingPatient != null) {
            existingPatient = toPatient(patientViewModel);
            existingPatient.setPatientId(patientViewModel.getPatientId());
            return _patientRepository.save(existingPatient);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        _patientRepository.deleteById(id);
    }

    @Override
    public void delete(PatientViewModel patientViewModel) {

    }

    @Override
    public void deleteAll(Iterable<PatientViewModel> patientViewModels) {

    }

    @Override
    public void deleteAll() {
        _patientRepository.deleteAll();
    }

    @Override
    public Patient create(PatientViewModel patientViewModel) {
        int cardNumber=(int) ((Math.random() * (maximum - minimum)) + minimum);
        Patient patient = toPatient(patientViewModel);

//        while (true) {
//            cardNumber = (int) ((Math.random() * (maximum - minimum)) + minimum);
//            Patient existingPatientWithCardNumber = _patientRepository.findByCardNumber(cardNumber);
//            if (existingPatientWithCardNumber == null) {
//                break;
//            }
//        }
        patient.setCardRecordNumber(cardNumber);
        return _patientRepository.save(patient);
    }

    @Override
    public List<Patient> createAll(List<PatientViewModel> listPatientViewModel) {
        return null;
    }

    public Patient toPatient(PatientViewModel patientViewModel) {
        Patient patient = new Patient();

        patient.setfName(patientViewModel.getfName());
        patient.setlName(patientViewModel.getlName());
        patient.setmName(patientViewModel.getmName());
        patient.setAddress(patientViewModel.getAddress());
        patient.setEmail(patientViewModel.getEmail());
        patient.setGender(patientViewModel.getGender());
        patient.setDateOfBirth(patientViewModel.getDateOfBirth());
        patient.setPhoneNumber(patientViewModel.getPhoneNumber());
        return patient;
    }
}
