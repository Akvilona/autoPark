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

    TopCitiesCount(final int value) {
        this.value = value;
    }

    private final int value;

}
