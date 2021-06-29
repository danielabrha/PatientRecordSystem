package Services.Implementation;

import Domain.Entity.Laboratorist;
import Domain.ViewModel.LaboratoristViewModel;
import Repository.ILaboratoristRepository;
import Services.Interface.ILaboratoristService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaboratoristService implements ILaboratoristService {

    ILaboratoristRepository _iLaboratoristRepository;
    List<Laboratorist> laboratoristList = new ArrayList<>();

    @Override
    public List<Laboratorist> findAll() {

        return null;
    }

    @Override
    public List<Laboratorist> findAll(String status) {
        return _iLaboratoristRepository.findAll();
//        _iLaboratoristRepository.findAll().forEach(laboratoristList::add);
//        return laboratoristList;
    }

    @Override
    public Laboratorist findById(int id) {
        return _iLaboratoristRepository.findById(id).orElse(null);
    }

    @Override
    public Laboratorist update(LaboratoristViewModel laboratoristViewModel) {
        Laboratorist previousLaboratorist = _iLaboratoristRepository.findById(laboratoristViewModel.getLaboratoristId()).orElse(null);
        if (previousLaboratorist != null) {
        }


        return previousLaboratorist;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(LaboratoristViewModel laboratoristViewModel) {

    }

    @Override
    public void deleteAll(Iterable<LaboratoristViewModel> laboratoristViewModels) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Laboratorist create(LaboratoristViewModel laboratoristViewModel) {
        return null;
    }

    @Override
    public List<Laboratorist> createAll(List<LaboratoristViewModel> listLaboratoristViewModel) {
        return null;
    }

    public Laboratorist toLaboratoris(LaboratoristViewModel laboratoristViewModel) {
        Laboratorist laboratorist = _iLaboratoristRepository.findById(laboratoristViewModel.getLaboratoristId()).orElse(null);
        return laboratorist;
    }
}
