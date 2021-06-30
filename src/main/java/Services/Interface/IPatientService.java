package Services.Interface;

import Domain.Entity.Patient;
import Domain.ViewModel.PatientViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IPatientService {
    public List<Patient> findAll();
    //	public List<PatientViewModel> findAll(int entryid);
    public List<Patient> findAll(String status);
    public Patient findById(int id);
    public Patient update(PatientViewModel patientViewModel,int patientId);
    public void deleteById(int id);
    public void delete(PatientViewModel patientViewModel);
    public void deleteAll(Iterable<PatientViewModel> patientViewModels);
    public void deleteAll();
    public Patient create(PatientViewModel patientViewModel);
    public List<Patient> createAll(List<PatientViewModel> listPatientViewModel);
}
