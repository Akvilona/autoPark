package library.repository.db;

import library.entity.BookUser;
import library.utils.DateTimeUtils;
import library.utils.DbUtils;
import nio.dz.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static library.constant.SqlQuery.BOOK_USER_FIND_ALL;
import static library.constant.SqlQuery.BOOK_USER_FIND_BOOK_USER_ID_SQL;
import static library.constant.SqlQuery.BOOK_USER_FIND_BOOK_USER_SQL;
import static library.constant.SqlQuery.BOOK_USER_INSERT_BOOK_USER_SQL;
import static library.constant.SqlQuery.BOOK_USER_UPDATE_BOOK_USER_SQL;
import static library.constant.SqlTable.BOOK_USER;


public class BookUserDBRepository implements CrudRepository<BookUser, Long> {

    @Override
    public String getTableName() {
        return BOOK_USER.getTableName();
    }

    @Override
    public Optional<BookUser> findById(final Long id) {
        return CrudRepository.super.findById(id);
    }

    @Override
    public Long getGeneratedKeys(final PreparedStatement preparedStatement) {
        return CrudRepository.super.getGeneratedKeys(preparedStatement);
    }

    public Optional<BookUser> findByBookIdAndUserId(final Long bookId, final Long userId) {
        Connection connection = DbUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(BOOK_USER_FIND_BOOK_USER_ID_SQL.getValue())) {
            preparedStatement.setLong(1, bookId);
            preparedStatement.setLong(2, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(convert(resultSet));
            }
            return Optional.empty();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    public Optional<BookUser> findByBookIdAndReturnDateTimeIsNull(final Long bookId) {
        Connection connection = DbUtils.getConnection();
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement(BOOK_USER_FIND_BOOK_USER_SQL.getValue())) {
            ResultSet resultSet = getResultSetSQL(bookId, preparedStatement);
            if (resultSet.next()) {
                return Optional.of(convert(resultSet));
            }
            return Optional.empty();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public BookUser save(final BookUser bookUser) {
        Connection connection = DbUtils.getConnection();

        if (bookUser.getId() == null || findById(bookUser.getId()).isEmpty()) {
            try (var preparedStatement = connection.prepareStatement(BOOK_USER_INSERT_BOOK_USER_SQL.getValue(),
                    Statement.RETURN_GENERATED_KEYS)) {

                preparedStatement.setLong(1, bookUser.getBookId());
                preparedStatement.setLong(2, bookUser.getUserId());
                preparedStatement.setTimestamp(3, Timestamp.valueOf(bookUser.getFrom()));
                preparedStatement.setTimestamp(4, Timestamp.valueOf(bookUser.getTo()));

                preparedStatement.executeUpdate();
                bookUser.setId(getGeneratedKeys(preparedStatement));
                connection.commit();
                return bookUser;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(BOOK_USER_UPDATE_BOOK_USER_SQL.getValue())) {

                preparedStatement.setTimestamp(1, Timestamp.valueOf(bookUser.getTo()));
                preparedStatement.setLong(2, bookUser.getId());
                preparedStatement.executeUpdate();
                connection.commit();
                return bookUser;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

/*
    @Override
    public void delete(final Long id) {
        Connection connection = DbUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(BOOK_USER_DELETE_BY_ID_SQL.getValue())) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }
*/

    @Override
    public List<BookUser> findAll() {
        Connection connection = DbUtils.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(BOOK_USER_FIND_ALL.getValue());
            List<BookUser> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(convert(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookUser convert(final ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        long bookId = resultSet.getLong("book_id");
        long userId = resultSet.getLong("user_id");
        LocalDateTime fromDateTime = DateTimeUtils.convertToLocalDateTime(resultSet.getDate("from_date_time"));
        LocalDateTime toDateTime = DateTimeUtils.convertToLocalDateTime(resultSet.getDate("to_date_time"));
        LocalDateTime returnDateTime = DateTimeUtils.convertToLocalDateTime(resultSet.getDate("return_date_time"));
        return new BookUser(id, bookId, userId, fromDateTime, toDateTime, returnDateTime);
    }
}
