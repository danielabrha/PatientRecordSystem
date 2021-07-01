package com.example.patientrecordsystem.Service.Implementation;


import com.example.patientrecordsystem.Domain.Entity.Receptionst;
import com.example.patientrecordsystem.Repository.IReceptionstRepository;
import com.example.patientrecordsystem.Service.Interface.IReceptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionstService implements IReceptionsService {
    @Autowired
    IReceptionstRepository _receptionstRepository;

    @Override
    public List<Receptionst> findAll() {
        return _receptionstRepository.findAll();
    }

    @Override
    public List<Receptionst> findAll(String status) {
        return null;
    }

    @Override
    public Receptionst findById(int id) {
        return _receptionstRepository.findById(id).orElse(null);
    }

    @Override
    public Receptionst update(Receptionst receptionst) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Receptionst receptionst) {

    }

    @Override
    public void deleteAll(Iterable<Receptionst> receptionsts) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Receptionst create(Receptionst receptionst) {
        return null;
    }

    @Override
    public List<Receptionst> createAll(List<Receptionst> listReceptionst) {
        return null;
    }
}

