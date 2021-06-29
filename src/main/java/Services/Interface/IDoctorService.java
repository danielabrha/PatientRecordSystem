package Services.Interface;

import Domain.Entity.Doctor;
import Domain.ViewModel.DoctorViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IDoctorService {
    public List<Doctor> findAll();
    //	public List<DoctorViewModel> findAll(int entryid);
    public List<Doctor> findAll(String status);
    public Doctor findById(int id);
    public Doctor update(DoctorViewModel doctorViewModel);
    public void deleteById(int id);
    public void delete(DoctorViewModel doctorViewModel);
    public void deleteAll(Iterable<DoctorViewModel> doctorViewModels);
    public void deleteAll();
    public Doctor create(DoctorViewModel doctorViewModel);
    public List<Doctor> createAll(List<DoctorViewModel> listDoctorViewModel);
}
