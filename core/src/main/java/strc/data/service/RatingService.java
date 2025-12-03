package strc.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import strc.data.entity.AutomobileEntity;
import strc.data.entity.AutomobileRatingEntity;
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

    public void saveRating(AutomobileEntity automobile){
        ratingRepository.save(AutomobileRatingEntity
                .builder()
                        .carID(automobile.getId())
                        .rating(0)
                        .isValid(0)
                .build());
    }

    private double calcRating(AutomobileEntity automobile){
        double ageScore = Math.max(1, 10 - (2025 - automobile.getYear()) * 0.5);   // mașinile mai noi = scor mai mare
        double engineScore = Math.min(10, automobile.getEngineVolume()) * 2;        // motor mare = scor mai mare
        double speedScore = Math.min(10, automobile.getMaxSpeed()) / 30;
        return (ageScore * 0.4) + (engineScore * 0.3) + (speedScore * 0.3);
    }

    private double calcIsValid(AutomobileEntity automobile){
        double fuelScore =
                switch (automobile.getFuelType()) {
                    case ELECTRIC -> 10;
                    case PLUGIN -> 9;
                    case HYBRID -> 8;
                    case PETROL -> 6.5;
                    case DIESEL -> 5;
                };

        double seatsScore = Math.min(10, automobile.getNumSeats()) * 1.2;   // 5 locuri = 6.0
        double engineScore = (automobile.getEngineVolume() != null && automobile.getEngineVolume() > 0) ? 8 : 1;

        double raw = (fuelScore * 0.5) + (seatsScore * 0.2) + (engineScore * 0.3);

        return Math.max(1, Math.min(10, raw)); // clamp la [1,10]
    }
}
