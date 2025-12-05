package strc.data.service;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import strc.data.entity.AutomobileEntity;
import strc.data.enums.FuelType;
import strc.data.repository.AutomobileRatingRepository;

public class RatingServiceTest {

    @InjectMocks
    private RatingService ratingService;

    @Mock
    private AutomobileRatingRepository ratingRepository;

    @Mock
    private AutomobileService automobileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("Rating Calc Passed Test")
    void testRatingPassed() {
        double rating = ratingService.calcRating(
                AutomobileEntity.builder()
                        .year(2020)
                        .engineVolume(2.0)
                        .maxSpeed(220d)
                        .build()
        );

        double delta = 1.5; // tolerance
        Assertions.assertEquals(5, rating, delta,
                "Expected rating ~5 but received: " + rating);
    }

    @Test
    @DisplayName("Rating Calc For Old Car")
    void testRatingOldCar() {
        double rating = ratingService.calcRating(
                AutomobileEntity.builder()
                        .year(2000)
                        .engineVolume(1.4)
                        .maxSpeed(160d)
                        .build()
        );

        Assertions.assertTrue(rating < 4.5,
                "Old car should give low rating, got: " + rating);
    }


    @Test
    @DisplayName("calcIsValid - ELECTRIC car should produce high validity score")
    void testIsValidElectric() {

        AutomobileEntity auto = AutomobileEntity.builder()
                .fuelType(FuelType.ELECTRIC)
                .numSeats(5)
                .engineVolume(0.0)
                .build();

        double score = ratingService.calcIsValid(auto);
        //System.out.println(score);
        Assertions.assertTrue(score > 7,
                "Electric cars should have high validity, got: " + score);
    }

    @Test
    @DisplayName("calcIsValid - DIESEL car with low seats should be lower score")
    void testIsValidDieselLowSeats() {

        AutomobileEntity auto = AutomobileEntity.builder()
                .fuelType(FuelType.DIESEL)
                .numSeats(2)
                .engineVolume(2.2)
                .build();

        double score = ratingService.calcIsValid(auto);

        Assertions.assertTrue(score < 7,
                "Diesel low-seat car should have lower validity, got: " + score);
    }


    @Test
    @DisplayName("calcIsValid - engineVolume null should reduce score dramatically")
    void testIsValidNullEngineVolume() {

        AutomobileEntity auto = AutomobileEntity.builder()
                .fuelType(FuelType.PETROL)
                .numSeats(4)
                .engineVolume(null)
                .build();

        double score = ratingService.calcIsValid(auto);

        Assertions.assertTrue(score <= 7,
                "Null engineVolume should lower validity score, got: " + score);
    }
}
