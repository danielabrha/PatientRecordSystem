package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Domain.Entity.LabOrder;

public interface ILabOrderRepository extends JpaRepository<LabOrder, Integer> {
    
}
