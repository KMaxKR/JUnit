package strc.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import strc.data.enums.AutoType;
import strc.data.enums.FuelType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestAutomobileDTO {
    private String name;
    private String model;
    private AutoType type;
    private int minYear;
    private int maxYear;
    private Double engineVolume;
    private Double maxSpeed;
    private int numSeats;
    private FuelType fuelType;
}
