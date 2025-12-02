package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FuelType {
    DIESEL("DIESEL"),
    PETROL("PETROL"),
    HYBRID("HYBRID"),
    PLUGIN("PLUGIN");

    public final String Type;
}
