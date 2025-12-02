package strc.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FuelType {
    DIESEL("DIESEL"),
    PETROL("PETROL"),
    HYBRID("HYBRID"),
    PLUGIN("PLUGIN"),
    ELECTRIC("ELECTRIC");

    public final String Type;
}
