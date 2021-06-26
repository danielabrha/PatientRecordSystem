package Services.Interface;

import Domain.Entity.Visit;
import Domain.ViewModel.VisitViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IVisitService {
    public List<Visit> findAll();
    //	public List<VisitViewModel> findAll(int entryid);
    public List<Visit> findAll(String status);
    public Visit findById(int id);
    public VisitViewModel update(VisitViewModel visitViewModel);
    public void deleteById(int id);
    public void delete(VisitViewModel visitViewModel);
    public void deleteAll(Iterable<VisitViewModel> visitViewModels);
    public void deleteAll();
    public Visit create(VisitViewModel visitViewModel);
    public List<Visit> createAll(List<VisitViewModel> listVisitViewModel);
}
