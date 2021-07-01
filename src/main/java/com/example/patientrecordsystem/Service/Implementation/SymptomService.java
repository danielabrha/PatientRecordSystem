package com.example.patientrecordsystem.Service.Implementation;



import com.example.patientrecordsystem.Domain.Entity.Symptom;
import com.example.patientrecordsystem.Repository.ISymptomRepository;
import com.example.patientrecordsystem.Service.Interface.IDoctorService;
import com.example.patientrecordsystem.Service.Interface.ISymptomService;
import com.example.patientrecordsystem.Service.Interface.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymptomService implements ISymptomService {

    @Autowired
    private ISymptomRepository _symptomRepository;

    @Autowired
    private DoctorService _doctorService;

    @Autowired
    private VisitService _visitService;

    @Autowired
    private List<Symptom> symptomList;

    public SymptomService() {
        _doctorService = new DoctorService();
        _visitService = new VisitService();
        symptomList=new ArrayList<>();
    }

    @Override
    public List<Symptom> findAll() {

        return  _symptomRepository.findAll();
    }

    @Override
    public List<Symptom> findAll(String status) {
        return null;
    }

    @Override
    public Symptom findById(int id) {
        return _symptomRepository.findById(id).orElse(null);
    }

    @Override
    public Symptom update(Symptom symptom) {
        return null;
    }

    @Override
    public void deleteById(int id) {

        _symptomRepository.deleteById(id);
    }

    @Override
    public void delete(Symptom symptom) {

        _symptomRepository.deleteById(symptom.getSymptomId());
    }

    @Override
    public void deleteAll(Iterable<Symptom> symptoms) {
        symptoms.forEach(symptom -> {
            _symptomRepository.deleteById(symptom.getSymptomId());

        });


    }

    @Override
    public void deleteAll() {
        _symptomRepository.deleteAll();
    }

    @Override
    public Symptom create(Symptom symptom1, int doctorId, int visitId) {
        Symptom symptom =new Symptom();
        symptom.setSymptomName(symptom1.getSymptomName());
        symptom.setDoctor(_doctorService.findById(doctorId));
        symptom.setVisit(_visitService.findById(visitId));
        return _symptomRepository.save(symptom);
    }

    @Override
    public List<Symptom> createAll(List<Symptom> symptomList, int visitId,
                                   int doctorId) {
        Symptom symptom = new Symptom();
        symptomList.forEach(symptom1 -> {

            this.symptomList.add(toSymptom(symptom1,visitId, doctorId));
        });
        return _symptomRepository.saveAll(this.symptomList);
    }


    public Symptom toSymptom (Symptom symptom1, int visitId,
                              int doctorId) {
        Symptom symptom = new Symptom();
        symptom.setSymptomName(symptom1.getSymptomName());
        symptom.setVisit(_visitService.findById(visitId));
        symptom.setDoctor(_doctorService.findById(doctorId));
        return symptom;
    }

}

