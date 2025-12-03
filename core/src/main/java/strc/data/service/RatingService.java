package strc.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import strc.data.repository.AutomobileRatingRepository;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final AutomobileRatingRepository ratingRepository;

    public void getAllRating(){
    }

    //TODO Car rating system, return cars by rating, save carID and rating of it
}
