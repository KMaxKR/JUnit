package strc.data.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import strc.data.dto.RequestAutomobileDTO;
import strc.data.entity.AutomobileEntity;
import strc.data.enums.AutoType;
import strc.data.enums.FuelType;
import strc.data.service.AutomobileService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final AutomobileService automobileService;

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
                .name("BMW")
                .model("XM7")
                .type(AutoType.CROSSOVER)
                .minYear(2020)
                .engineVolume(3.0)
                .maxSpeed(320d)
                .numSeats(5)
                .fuelType(FuelType.HYBRID)
                .build();
        return automobileService.saveAutomobile(auto);
    }
}
