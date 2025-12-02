package strc.data.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import strc.data.dto.RequestAutomobileDTO;
import strc.data.entity.AutomobileEntity;
import strc.data.service.AutomobileService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final AutomobileService automobileService;

    @RequestMapping("/")
    public String method(){
        RequestAutomobileDTO auto = RequestAutomobileDTO.builder()
                .name("AUDI")
                .build();
        List<AutomobileEntity> l = automobileService.getAutomobileBy(auto);
        for (AutomobileEntity el : l){
            System.out.println(el.getAutoSpecs());
        }
        return null;
    }
}
