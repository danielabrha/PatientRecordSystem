package Services.Implementation;

import Domain.Entity.Laboratorist;
import Domain.ViewModel.LaboratoriestViewModel;
import Services.Interface.ILaboratoristService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LaboratoristService implements ILaboratoristService {
    @Override
    public List<Laboratorist> findAll() {
        return null;
    }

    @Override
    public List<Laboratorist> findAll(String status) {
        return null;
    }

    @Override
    public Laboratorist findById(int id) {
        return null;
    }

    @Override
    public LaboratoriestViewModel update(LaboratoriestViewModel laboratoristViewModel) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(LaboratoriestViewModel laboratoristViewModel) {

    }

    @Override
    public void deleteAll(Iterable<LaboratoriestViewModel> laboratoristViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Laboratorist create(LaboratoriestViewModel laboratoristViewModel) {
        return null;
    }

    @Override
    public List<Laboratorist> createAll(List<LaboratoriestViewModel> listLaboratoriestViewModel) {
        return null;
    }
}
