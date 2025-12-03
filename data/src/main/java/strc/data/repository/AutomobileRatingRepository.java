package strc.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import strc.data.entity.AutomobileRatingEntity;

@Repository
public interface AutomobileRatingRepository extends JpaRepository<AutomobileRatingEntity, Long> {
}
