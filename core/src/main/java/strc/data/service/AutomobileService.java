package strc.data.service;

import entity.AutomobileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.AutomobileRepository;
import strc.data.exceptions.AutomobileNotFoundException;

@Service
@RequiredArgsConstructor
public class AutomobileService {
    private final AutomobileRepository automobileRepository;

    public AutomobileEntity getAutomobileById(Long id){
        return automobileRepository.findById(id).orElseThrow(() -> new AutomobileNotFoundException("Automobile Not Found By This ID"));
    }
}
