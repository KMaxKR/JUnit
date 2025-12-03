package strc.data.entity;

import strc.data.enums.AutoType;
import strc.data.enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auto_db")
public class AutomobileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private AutoType type;

    @Column(name = "year")
    private int year;

    @Column(name = "engine_volume")
    private Double engineVolume;

    @Column(name = "max_speed")
    private Double maxSpeed;

    @Column(name = "num_seats")
    private int numSeats;

    @Column(name = "fuel_type")
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType;

    public String getAutoSpecs(){
        String s = "Name: " + name + "\nModel: " + model
                + "\nType: " + type.getType() + "\nYear: " + year
                + "\nEngineVolume: " + engineVolume + "\nMaxSpeed: " + maxSpeed
                +"\nNumSeats: " + numSeats + "\nFuelType: " + fuelType.getType();
        return s;
    }
}
