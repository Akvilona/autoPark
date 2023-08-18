package http.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TopCitiesCount {
    FIFTY(50),
    HUNDRED(100),
    HUNDRED_FIFTY(150);

    private final int value;
}
