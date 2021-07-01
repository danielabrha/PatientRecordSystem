package com.example.patientrecordsystem.Service.Interface;


import com.example.patientrecordsystem.Domain.Entity.Receptionst;
import com.example.patientrecordsystem.Domain.ViewModel.ReceptionstViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IReceptionsService {
    public List<Receptionst> findAll();
    //	public List<ReceptionstViewModel> findAll(int entryid);
    public List<Receptionst> findAll(String status);
    public Receptionst findById(int id);
    public Receptionst update(ReceptionstViewModel receptionstViewModel);
    public void deleteById(int id);
    public void delete(ReceptionstViewModel receptionstViewModel);
    public void deleteAll(Iterable<ReceptionstViewModel> receptionstViewModels);
    public void deleteAll();
    public Receptionst create(ReceptionstViewModel receptionstViewModel);
    public List<Receptionst> createAll(List<ReceptionstViewModel> listReceptionstViewModel);
}
