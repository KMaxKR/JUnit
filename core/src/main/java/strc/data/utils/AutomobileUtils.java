package strc.data.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import strc.data.service.AutomobileService;

@Component
@RequiredArgsConstructor
public class AutomobileUtils {
    private final AutomobileService automobileService;

    public double evalCarRating(){

        return -1;
    }

    // main login used in controllers.
    // use rating service and automobile service
}
