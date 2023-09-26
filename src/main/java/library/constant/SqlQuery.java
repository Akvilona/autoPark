package library.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SqlQuery {
    BOOK_USER_FIND_BOOK_USER_SQL("select * from bookuser where book_id = ? and return_date_time IS NULL"),
    BOOK_USER_FIND_BOOK_USER_ID_SQL("select * from bookuser where book_id = ? and user_id = ?"),
    BOOK_USER_INSERT_BOOK_USER_SQL("insert into bookuser (book_id, user_id, from_date_time, to_date_time) values (?, ?, ?, ?)"),
    BOOK_USER_UPDATE_BOOK_USER_SQL("update bookuser set return_date_time = ? where id = ?"),
    BOOK_USER_DELETE_BY_ID_SQL("delete from bookuser where id = ?"),
    FIND_BY_ID("select * from %s where id = ?"),
    BOOK_USER_FIND_ALL("select id, book_id, user_id, from_date_time, to_date_time, return_date_time from bookuser");

    private final String value;
}
