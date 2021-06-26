package Services.Implementation;

import Domain.Entity.Receptionst;
import Domain.ViewModel.ReceptionstViewModel;
import Services.Interface.IReceptionsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReceptionstService implements IReceptionsService {
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
