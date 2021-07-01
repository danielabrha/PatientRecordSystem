package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.Laboratorist;
import com.example.patientrecordsystem.Domain.ViewModel.LaboratoristViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILaboratoristService {
    public List<Laboratorist> findAll();
    //	public List<LaboratoriesViewModel> findAll(int entryid);
    public List<Laboratorist> findAll(String status);
    public Laboratorist findById(int id);
    public Laboratorist update(LaboratoristViewModel laboratoristViewModel);
    public void deleteById(int id);
    public void delete(LaboratoristViewModel laboratoristViewModel);
    public void deleteAll(Iterable<LaboratoristViewModel> laboratoristViewModels);
    public void deleteAll();
    public Laboratorist create(LaboratoristViewModel laboratoristViewModel);
    public List<Laboratorist> createAll(List<LaboratoristViewModel> listLaboratoristViewModel);
}

