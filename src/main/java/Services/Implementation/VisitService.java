package Services.Implementation;

import Domain.Entity.Patient;
import Domain.Entity.Receptionst;
import Domain.ViewModel.VisitViewModel;
import Repository.IVisitRepository;
import Services.Interface.IPatientService;
import Services.Interface.IReceptionsService;
import Services.Interface.IVisitService;
import Domain.Entity.Visit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService implements IVisitService {

    private IVisitRepository _visitRepository;
    private IPatientService _patientService;
    private IReceptionsService _receptionsService;

    public VisitService() {
        _patientService = new PatientService();
        _receptionsService = new ReceptionstService();
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
    public List<Visit> createAll(List<VisitViewModel> listVisitViewModel) {
        return null;
    }

}
