/**
 * Создал Андрей Антонов 26.09.2023 13:10
 **/
package db.jdbc.library.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SqlTable {
    BOOK("book"),
    BOOK_USER("bookuser"),
    REVIEW("review"),
    USER("user");

    private final String tableName;
}
