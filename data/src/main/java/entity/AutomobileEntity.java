package entity;

import enums.AutoType;
import enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date year;

    @Column(name = "engineVolume")
    private Double engineVolume;

    @Column(name = "maxSpeed")
    private Double maxSpeed;

    @Column(name = "numSeats")
    private int numSeats;

    @Column(name = "fuelType")
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType;
}
