package com.example.patientrecordsystem.Service.Implementation;


import com.example.patientrecordsystem.Domain.Entity.Patient;
import com.example.patientrecordsystem.Domain.Entity.Receptionst;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Repository.IVisitRepository;
import com.example.patientrecordsystem.Service.Interface.IPatientService;
import com.example.patientrecordsystem.Service.Interface.IReceptionsService;
import com.example.patientrecordsystem.Service.Interface.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VisitService implements IVisitService {
    @Autowired
    private IVisitRepository _visitRepository;
    @Autowired
    private PatientService _patientService;
//    @Autowired
//    private ReceptionstService _receptionsService;
    private List<Visit> visitList;

    public VisitService() {
        _patientService = new PatientService();
       // _receptionsService = new ReceptionstService();
        visitList = new ArrayList<>();
    }

    @Override
    public List<Visit> findAll() {
        return _visitRepository.findAll();
    }

    @Override
    public List<Visit> findAll(String status) {
        return null;
    }

    @Override
    public Visit findById(int id) {
        return _visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit update(Visit visit) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Visit visit) {

    }

    @Override
    public void deleteAll(Iterable<Visit> visits) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Visit create( int patientId) {
        Visit visit=new Visit();
        visit.setPatient(_patientService.findById(patientId));
        visit.setVisitDate(new Date());
        return _visitRepository.save(visit);
    }

    @Override
    public List<Visit> createAll(List<Visit> visitList, int patientId) {
        List<Visit> visitList1 = new ArrayList<>();
        visitList.forEach(visitVM -> {
            Visit visit = new Visit();
            visit.setPatient(_patientService.findById(patientId));
          //  visit = toVisit(visitVM, patientId);
            visit.setVisitDate(new Date());
            visitList1.add(visit);
        });
        return _visitRepository.saveAll(visitList1);
    }


//    public Visit toVisit(Visit visit,
//                         int patientId) {
//       // visit.setReceptionst(_receptionsService.findById(receptionistId));
//        visit.setPatient(_patientService.findById(patientId));
//        return visit;
//    }

}
