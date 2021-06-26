package Services.Implementation;

import Domain.Entity.Patient;
import Domain.ViewModel.PatientViewModel;
import Services.Interface.IPatientService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService implements IPatientService {
    @Override
    public List<Patient> findAll() {
        return null;
    }

    @Override
    public List<Patient> findAll(String status) {
        return null;
    }

    @Override
    public Patient findById(int id) {
        return null;
    }

    @Override
    public PatientViewModel update(PatientViewModel patientViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(PatientViewModel patientViewModel) {

    }

    @Override
    public void deleteAll(Iterable<PatientViewModel> patientViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Patient create(PatientViewModel patientViewModel) {
        return null;
    }

    @Override
    public List<Patient> createAll(List<PatientViewModel> listPatientViewModel) {
        return null;
    }
}
