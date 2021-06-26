package Repository;

import Services.Implementation.LabTestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILabTestTypeRepository extends JpaRepository<LabTestType,Integer> {
}
