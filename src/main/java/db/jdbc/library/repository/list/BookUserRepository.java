package db.jdbc.library.repository.list;

import db.jdbc.library.entity.BookUser;
import lombok.Data;
import nio.dz.CrudRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static db.jdbc.library.constant.SqlTable.BOOK_USER;

@Data
public class BookUserRepository implements CrudRepository<BookUser, Long> {

    private final List<BookUser> bookUserList = new ArrayList<>();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public BookUser convert(final ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public String getTableName() {
        return BOOK_USER.getTableName();
    }

    @Override
    public Optional<BookUser> findById(final Long id) {
        for (BookUser bookUser : bookUserList) {
            if (bookUser.getBookId().equals(id)) {
                return Optional.of(bookUser);
            }
        }
        return Optional.empty();
    }

    @Override
    public ResultSet getresultsetsql(final Long id, final PreparedStatement preparedStatement) throws SQLException {
        return CrudRepository.super.getresultsetsql(id, preparedStatement);
    }

    @Override
    public Long getGeneratedKeys(final PreparedStatement preparedStatement) {
        return CrudRepository.super.getGeneratedKeys(preparedStatement);
    }

    @Override
    public BookUser save(final BookUser bookUser) {
        bookUserList.add(bookUser);
        return bookUser;
    }

    @Override
    public void delete(final Long id) {

    }

    @Override
    public List<BookUser> findAll() {
        return bookUserList;
    }

    public Optional<BookUser> findByBookId(final Long bookId) {
        for (BookUser bookUser : bookUserList) {
            if (bookUser.getBookId().equals(bookId)) {
                return Optional.of(bookUser);
            }
        }
        return Optional.empty();
    }

    public Optional<BookUser> findByBookIdAndReturnDateTimeIsNull(final Long bookId) {
        return bookUserList.stream()
                .filter(bookUser -> bookUser.getBookId().equals(bookId))
                .filter(bookUser -> bookUser.getReturnDateTime() == null)
                .findFirst();
    }

    public Optional<BookUser> findByBookIdAndUserId(final Long bookId, final Long userId) {
        return bookUserList.stream()
                .filter(bookUser -> bookUser.getBookId().equals(bookId)
                        && bookUser.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
