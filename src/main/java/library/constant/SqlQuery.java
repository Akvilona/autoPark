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
    DELETE_BY_ID_SQL("delete from %s where id = ?"),
    FIND_BY_ID("select * from %s where id = ?"),
    BOOK_USER_FIND_ALL("select id, book_id, user_id, from_date_time, to_date_time, return_date_time from bookuser"),
    BOOK_SELECT_FROM_BOOK_WHERE_ID("SELECT * FROM book WHERE id = ?"),
    BOOK_SELECT_FROM_BOOK("SELECT * FROM book"),
    BOOK_INSERT_INTO_BOOK("INSERT INTO book (name, dateOfIssue) VALUES (?, ?)"),
    BOOK_DELETE_FROM_BOOK_WHERE_ID("DELETE FROM book WHERE id = ?"),
    REVIEW_INSERT_BOOK_USER_SQL("insert into review (book_id, user_id, comment) values (?, ?, ?)"),
    REVIEW_DELETE_BY_ID_SQL("delete from review where id = ?"),
    REVIEW_FIND_BY_ID("select * from review where id = ?"),
    REVIEW_FIND_BY_BOOK_ID("select * from review where book_id = ?"),
    REVIEW_FIND_ALL("select * from review"),
    USER_SELECT_BY_ID_SQL("SELECT * FROM users WHERE id = ?"),
    USER_SELECT_ALL_USER_SQL("select * from users"),
    USER_INSERT_USER_SQL("insert into users (name) VALUES (?)"),
    USER_DELETE_BY_ID_SQL("DELETE FROM users WHERE id = ?");

    private final String value;
}
