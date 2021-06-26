package Repository;

import Domain.Entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDrugRepository extends JpaRepository<Drug,Integer> {
}
