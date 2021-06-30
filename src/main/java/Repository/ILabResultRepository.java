package Repository;

import Domain.Entity.LabResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILabResultRepository extends JpaRepository<LabResult,Integer> {
    public LabResult findByLabOrderId(int labOrderId);
}
