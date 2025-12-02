package repository;

import entity.AutomobileEntity;
import enums.AutoType;
import enums.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AutomobileRepository extends JpaRepository<AutomobileEntity, Long> {
    List<AutomobileEntity> findByName(String name);
    List<AutomobileEntity> findByModel(String name);
    List<AutomobileEntity> findByType(AutoType type);
    List<AutomobileEntity> findByYear(Date year);
    List<AutomobileEntity> findByEngineVolume(Double engineVolume);
    List<AutomobileEntity> findByMaxSpeed(Double maxSpeed);
    List<AutomobileEntity> findByNumSeats(Integer numSeats);
    List<AutomobileEntity> findByFuelType(FuelType type);
}
