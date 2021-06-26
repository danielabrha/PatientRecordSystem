package Services.Implementation;

import Domain.ViewModel.VisitViewModel;
import Services.Interface.IVisitService;
import Domain.Entity.Visit;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VisitService implements IVisitService {
    @Override
    public List<Visit> findAll() {
        return null;
    }

    @Override
    public List<Visit> findAll(String status) {
        return null;
    }

    @Override
    public Visit findById(int id) {
        return null;
    }

    @Override
    public VisitViewModel update(VisitViewModel visitViewModel) {
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
    public Visit create(VisitViewModel visitViewModel) {
        return null;
    }

    @Override
    public List<Visit> createAll(List<VisitViewModel> listVisitViewModel) {
        return null;
    }
}
