/**
 * Создал Андрей Антонов 19.08.2023 13:42
 **/
package http.com.model;

import lombok.Getter;

@Getter
public enum TopCitiesCount {
    FIFTY(50),
    HUNDRED(100),
    HUNDRED_FIFTY(150);

    private final int value;

    TopCitiesCount(final int value) {
        this.value = value;
    }

    public static TopCitiesCount findByValue(final int value) {
        for (TopCitiesCount topCitiesCount : values()) {
            if (topCitiesCount.getValue() == value) {
                return topCitiesCount;
            }
        }
        throw new IllegalStateException("Unknown value" + value);
    }
}
