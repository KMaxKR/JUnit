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

    @Column(name = "engineVolume")
    private Double engineVolume;

    @Column(name = "maxSpeed")
    private Double maxSpeed;

    @Column(name = "numSeats")
    private int numSeats;

    @Column(name = "fuelType")
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
