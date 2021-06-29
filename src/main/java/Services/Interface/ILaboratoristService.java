package Services.Interface;

import Domain.Entity.Laboratorist;
import Domain.ViewModel.LaboratoriestViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ILaboratoristService {
    public List<Laboratorist> findAll();
    //	public List<LaboratoriesViewModel> findAll(int entryid);
    public List<Laboratorist> findAll(String status);
    public Laboratorist findById(int id);
    public Laboratorist update(LaboratoriestViewModel laboratoristViewModel);
    public void deleteById(int id);
    public void delete(LaboratoriestViewModel laboratoristViewModel);
    public void deleteAll(Iterable<LaboratoriestViewModel> laboratoristViewModels);
    public void deleteAll();
    public Laboratorist create(LaboratoriestViewModel laboratoristViewModel);
    public List<Laboratorist> createAll(List<LaboratoriestViewModel> listLaboratoriestViewModel);
}
