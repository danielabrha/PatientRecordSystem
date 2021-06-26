package Services.Implementation;

import Domain.Entity.Doctor;
import Domain.Entity.Receptionst;
import Domain.ViewModel.DoctorViewModel;
import Domain.ViewModel.ReceptionstViewModel;
import Services.Interface.IDoctorService;
import Services.Interface.IReceptionsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService implements IDoctorService {
    @Override
    public List<Doctor> findAll() {
        return null;
    }

    @Override
    public List<Doctor> findAll(String status) {
        return null;
    }

    @Override
    public Doctor findById(int id) {
        return null;
    }

    @Override
    public DoctorViewModel update(DoctorViewModel doctorViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(DoctorViewModel doctorViewModel) {

    }

    @Override
    public void deleteAll(Iterable<DoctorViewModel> doctorViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Doctor create(DoctorViewModel doctorViewModel) {
        return null;
    }

    @Override
    public List<Doctor> createAll(List<DoctorViewModel> listDoctorViewModel) {
        return null;
    }

    public static class ReceptionsService implements IReceptionsService {
        @Override
        public List<Receptionst> findAll() {
            return null;
        }

        @Override
        public List<Receptionst> findAll(String status) {
            return null;
        }

        @Override
        public Receptionst findById(int id) {
            return null;
        }

        @Override
        public ReceptionstViewModel update(ReceptionstViewModel receptionstViewModel) {
            return null;
        }

        @Override
        public void deleteById(int id) {

        }

        @Override
        public void delete(ReceptionstViewModel receptionstViewModel) {

        }

        @Override
        public void deleteAll(Iterable<ReceptionstViewModel> receptionstViewModels) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public Receptionst create(ReceptionstViewModel receptionstViewModel) {
            return null;
        }

        @Override
        public List<Receptionst> createAll(List<ReceptionstViewModel> listReceptionstViewModel) {
            return null;
        }
    }
}
