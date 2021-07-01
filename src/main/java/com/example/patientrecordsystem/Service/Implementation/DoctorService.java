package com.example.patientrecordsystem.Service.Implementation;


import com.example.patientrecordsystem.Domain.Entity.Doctor;
import com.example.patientrecordsystem.Domain.ViewModel.DoctorViewModel;
import com.example.patientrecordsystem.Repository.IDoctorRepository;
import com.example.patientrecordsystem.Service.Interface.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    IDoctorRepository _doctorRepository;


    List<Doctor> doctorList;

    public DoctorService() {
        doctorList = new ArrayList<>();
    }


    @Override
    public List<Doctor> findAll() {
        return _doctorRepository.findAll();
        // return null;

    }

    @Override
    public List<Doctor> findAll(String status) {
        return _doctorRepository.findAll();
    }

    @Override
    public Doctor findById(int id) {
        return _doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor update(DoctorViewModel doctorViewModel) {
        Doctor previousDoctor = _doctorRepository.findById(doctorViewModel.getDoctorId()).orElse(null);
        if (previousDoctor != null) {
            previousDoctor = toDoctor(doctorViewModel);
        }
        return _doctorRepository.save(previousDoctor);
    }

    @Override
    public void deleteById(int id) {
        _doctorRepository.deleteById(id);
    }

    @Override
    public void delete(DoctorViewModel doctorViewModel) {
        Doctor doctor = _doctorRepository.findById(doctorViewModel.getDoctorId()).orElse(null);
        if(doctor != null){
            _doctorRepository.deleteById(doctor.getDoctorId());
        }
    }

    @Override
    public void deleteAll(Iterable<DoctorViewModel> doctorViewModels) {
        doctorViewModels.forEach(roleViewModel -> {
            Doctor doctor = _doctorRepository.findById(roleViewModel.getDoctorId()).orElse(null);
            if (doctor!=null)
                _doctorRepository.deleteById(doctor.getDoctorId());
        });
    }
    @Override
    public void deleteAll() {
        _doctorRepository.deleteAll();
    }
    @Override
    public Doctor create(DoctorViewModel doctorViewModel) {
        _doctorRepository.save(toDoctor(doctorViewModel));
        return null;
    }
    @Override
    public List<Doctor> createAll(List<DoctorViewModel> listDoctorViewModel) {
        listDoctorViewModel.forEach(roleVM -> {
            this.doctorList.add(toDoctor(roleVM));
        });
        return _doctorRepository.saveAll(this.doctorList);
    }
    public Doctor toDoctor(DoctorViewModel doctorViewModel){
        Doctor doctor = new Doctor();
//       Doctor doctor.setDoctorId(doctorViewModel.getdoctorViewModelId());
//        doctor.setLabOrderList(doctorViewModel.getLabOrderViewModelList());
//        doctor.setSymptomList(doctorViewModel.getSymptomList());
//        doctor.setUser(doctorViewModel.getUser());
        return doctor;
    }


}
