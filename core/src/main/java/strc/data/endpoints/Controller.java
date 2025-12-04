package strc.data.endpoints;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import strc.data.dto.RequestAutomobileDTO;
import strc.data.entity.AutomobileEntity;
import strc.data.enums.AutoType;
import strc.data.enums.FuelType;
import strc.data.service.AutomobileService;
import strc.data.service.RatingService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {
    private final AutomobileService automobileService;
    private final RatingService ratingService;

    @RequestMapping("/")
    public String method(){
        RequestAutomobileDTO auto = RequestAutomobileDTO.builder()
                .name("BMW")
                .model("XM7")
                .build();
        List<AutomobileEntity> l = automobileService.getAutomobileBy(auto);
        for (AutomobileEntity el : l){
            System.out.println(el.getAutoSpecs());
        }
        return null;
    }

    @RequestMapping("/save")
    public AutomobileEntity saveEntity(){
        RequestAutomobileDTO auto = RequestAutomobileDTO
                .builder()
                .name("BYD")
                .model("QING")
                .type(AutoType.SEDAN)
                .minYear(2026)
                .engineVolume(2.0)
                .maxSpeed(220d)
                .numSeats(5)
                .fuelType(FuelType.ELECTRIC)
                .build();
        AutomobileEntity automobile = automobileService.saveAutomobile(auto);
        ;
        log.info("Rating: {}", ratingService.saveRating(automobile));
        return automobile;
    }
}
