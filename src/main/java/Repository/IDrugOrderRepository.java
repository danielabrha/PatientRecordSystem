package Repository;

import Domain.Entity.DrugOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDrugOrderRepository extends JpaRepository<DrugOrder,Integer> {
}
