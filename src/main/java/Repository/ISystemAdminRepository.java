package Repository;

import Domain.Entity.SystemAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISystemAdminRepository extends JpaRepository<SystemAdmin,Integer> {
}
