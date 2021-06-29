package Repository;

import Domain.Entity.LabOrder;
import Domain.Entity.Laboratorist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILabOrderRepository extends JpaRepository<LabOrder,Integer> {
}
