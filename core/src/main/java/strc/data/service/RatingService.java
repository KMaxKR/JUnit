package strc.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import strc.data.entity.AutomobileEntity;
import strc.data.entity.AutomobileRatingEntity;
import strc.data.enums.FuelType;
import strc.data.repository.AutomobileRatingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final AutomobileRatingRepository ratingRepository;
    private final AutomobileService automobileService;

    //TODO Car rating system, return cars by rating, save carID and rating of it

    public List<AutomobileRatingEntity> getAllRating(){
        return ratingRepository.findAll();
    }

    public AutomobileRatingEntity saveRating(AutomobileEntity automobile){
        return ratingRepository.save(AutomobileRatingEntity
                .builder()
                        .carID(automobile.getId())
                        .rating(calcRating(automobile))
                        .isValid(calcIsValid(automobile))
                .build());
    }

    public double calcRating(AutomobileEntity automobile){
        double ageScore = Math.max(1, 10 - (2026 - automobile.getYear()) * 0.5);
        double engineScore = Math.min(7, automobile.getEngineVolume()) * 2;
        double speedScore = Math.min(10, automobile.getMaxSpeed()) / 30;
        return (ageScore * 0.4) + (engineScore * 0.3) + (speedScore * 0.3);
    }

    public double calcIsValid(AutomobileEntity automobile){
        double fuelScore =
                switch (automobile.getFuelType()) {
                    case ELECTRIC -> 9.4;
                    case PLUGIN -> 9;
                    case HYBRID -> 8.5;
                    case PETROL -> 8.2;
                    case DIESEL -> 8;
                };

        double seatsScore = Math.min(7, automobile.getNumSeats()) * 1.2;
        double engineScore = 0;
        if (automobile.getFuelType().equals(FuelType.ELECTRIC)){
            engineScore = 9.4;
        }else {
            engineScore = (automobile.getEngineVolume() != null && automobile.getEngineVolume() > 0) ? 8 : 1;
        }

        double raw = (fuelScore * 0.5) + (seatsScore * 0.2) + (engineScore * 0.3);

        return Math.max(1, Math.min(10, raw));
    }
}
