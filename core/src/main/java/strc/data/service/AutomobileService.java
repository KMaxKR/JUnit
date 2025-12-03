package strc.data.service;

import strc.data.dto.RequestAutomobileDTO;
import strc.data.entity.AutomobileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import strc.data.repository.AutomobileRepository;
import strc.data.exceptions.AutomobileNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutomobileService {
    private final AutomobileRepository automobileRepository;

    public List<AutomobileEntity> getAutomobile(){
        return automobileRepository.findAll();
    }

    public AutomobileEntity getAutomobileById(Long id){
        return automobileRepository.findById(id).orElseThrow(() -> new AutomobileNotFoundException("Automobile Not Found By This ID"));
    }

    public List<AutomobileEntity> getAutomobileBy(RequestAutomobileDTO automobileDTO){
        List<AutomobileEntity> result = getAutomobile();
        if (automobileDTO.getName() != null){
            result = result.stream()
                    .filter(e -> e.getName().equalsIgnoreCase(automobileDTO.getName()))
                    .toList();
        }
        if (automobileDTO.getModel() != null){
            result = result.stream()
                    .filter(e -> e.getModel().equalsIgnoreCase(automobileDTO.getModel()))
                    .toList();
        }
        if (automobileDTO.getType() != null){
            result = result.stream()
                    .filter(e -> e.getType().equals(automobileDTO.getType()))
                    .toList();
        }
        if (automobileDTO.getMinYear() > 1999){
            result = result.stream()
                    .filter(e -> e.getYear() >= automobileDTO.getMinYear())
                    .toList();
        }
        if (automobileDTO.getMaxYear() > 1999){
            result = result.stream()
                    .filter(e -> e.getYear() <= automobileDTO.getMaxYear())
                    .toList();
        }
        if (automobileDTO.getEngineVolume() != null){
            result = result.stream()
                    .filter(e -> e.getEngineVolume() >= automobileDTO.getEngineVolume())
                    .toList();
        }
        if (automobileDTO.getMaxSpeed() != null){
            result = result.stream()
                    .filter(e -> e.getMaxSpeed() > automobileDTO.getMaxSpeed())
                    .toList();
        }
        if (automobileDTO.getNumSeats() >= 2 && automobileDTO.getNumSeats() <= 7){
            result = result.stream()
                    .filter(e -> e.getNumSeats() == automobileDTO.getNumSeats())
                    .toList();
        }
        if (automobileDTO.getFuelType() != null){
            result = result.stream()
                    .filter(e -> e.getFuelType().equals(automobileDTO.getFuelType()))
                    .toList();
        }
        return result;
    }
    
    public AutomobileEntity saveAutomobile(RequestAutomobileDTO automobileDTO){
        AutomobileEntity automobile = AutomobileEntity.builder()
                .name(automobileDTO.getName())
                .model(automobileDTO.getModel())
                .type(automobileDTO.getType())
                .year(automobileDTO.getMinYear())
                .engineVolume(automobileDTO.getEngineVolume())
                .maxSpeed(automobileDTO.getMaxSpeed())
                .numSeats(automobileDTO.getNumSeats())
                .fuelType(automobileDTO.getFuelType())
                .build();
        automobileRepository.save(automobile);
        return automobile;
    }


}
