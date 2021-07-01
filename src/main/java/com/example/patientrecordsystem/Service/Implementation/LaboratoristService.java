package com.example.patientrecordsystem.Service.Implementation;



import com.example.patientrecordsystem.Domain.Entity.Laboratorist;
import com.example.patientrecordsystem.Repository.ILaboratoristRepository;
import com.example.patientrecordsystem.Service.Interface.ILaboratoristService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaboratoristService implements ILaboratoristService {

    ILaboratoristRepository _laboratoristRepository;
    List<Laboratorist> laboratoristList = new ArrayList<>();

    @Override
    public List<Laboratorist> findAll() {

        return null;
    }

    @Override
    public List<Laboratorist> findAll(String status) {
        return _laboratoristRepository.findAll();

    }

    @Override
    public Laboratorist findById(int id) {
        return _laboratoristRepository.findById(id).orElse(null);
    }

    @Override
    public Laboratorist update(Laboratorist laboratorist) {
        Laboratorist previousLaboratorist = _laboratoristRepository.findById(laboratorist.getLaboratoristId()).orElse(null);
        if (previousLaboratorist != null) {
        }


        return previousLaboratorist;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Laboratorist laboratorist) {

    }

    @Override
    public void deleteAll(Iterable<Laboratorist> laboratorists) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Laboratorist create(Laboratorist laboratorist) {
        return null;
    }

    @Override
    public List<Laboratorist> createAll(List<Laboratorist> listLaboratorist) {
        return null;
    }

    public Laboratorist toLaboratoris(Laboratorist laboratorist1) {
        Laboratorist laboratorist = _laboratoristRepository.findById(laboratorist1.getLaboratoristId()).orElse(null);
        return laboratorist;
    }
}
