package com.example.patientrecordsystem.Service.Implementation;



import com.example.patientrecordsystem.Domain.Entity.Patient;
import com.example.patientrecordsystem.Domain.Entity.Receptionst;
import com.example.patientrecordsystem.Domain.Entity.Visit;
import com.example.patientrecordsystem.Domain.ViewModel.VisitViewModel;
import com.example.patientrecordsystem.Repository.IVisitRepository;
import com.example.patientrecordsystem.Service.Interface.IPatientService;
import com.example.patientrecordsystem.Service.Interface.IReceptionsService;
import com.example.patientrecordsystem.Service.Interface.IVisitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitService implements IVisitService {

    private IVisitRepository _visitRepository;
    private IPatientService _patientService;
    private IReceptionsService _receptionsService;
    private List<Visit> visitList;

    public VisitService() {
        _patientService = new PatientService();
        _receptionsService = new ReceptionstService();
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
    public Visit update(VisitViewModel visitViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(VisitViewModel visitViewModel) {

    }

    @Override
    public void deleteAll(Iterable<VisitViewModel> visitViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Visit create(VisitViewModel visitViewModel, int patientId, int receptionId) {
        Visit visit = new Visit();
        Patient patient = _patientService.findById(patientId);
        Receptionst receptionst = _receptionsService.findById(receptionId);
        visit.setVisitDate(visitViewModel.getVisitDate());
        visit.setPatient(patient);
        visit.setReceptionst(receptionst);

        return _visitRepository.save(visit);
    }

    @Override
    public List<Visit> createAll(List<VisitViewModel> visitViewModelList, int receptionistId, int patientId) {
        Visit visit = new Visit();
        visitViewModelList.forEach(visitVM -> {

            this.visitList.add(toVisit(visitVM,receptionistId, patientId));
        });
        return _visitRepository.saveAll(this.visitList);
    }


    public Visit toVisit (VisitViewModel visitViewModel, int receptionistId,
                          int patientId) {
        Visit visit = new Visit();
        visit.setVisitDate(visitViewModel.getVisitDate());
        visit.setReceptionst(_receptionsService.findById(receptionistId));
        visit.setPatient(_patientService.findById(patientId));
        return visit;
    }

}
