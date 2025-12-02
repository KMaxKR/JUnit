package strc.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AutoType {
    SEDAN("SEDAN"),
    CROSSOVER("CROSSOVER"),
    HATCHBACK("HATCHBACK");

    public final String Type;
}
