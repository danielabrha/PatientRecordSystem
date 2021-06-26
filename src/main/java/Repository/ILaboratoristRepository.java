package Repository;

import Domain.Entity.Laboratorist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaboratoristRepository extends JpaRepository<Laboratorist,Integer> {
}
