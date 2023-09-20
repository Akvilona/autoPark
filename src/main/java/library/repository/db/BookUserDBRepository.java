package library.repository.db;

import library.model.BookUser;
import library.utils.DbUtils;
import nio.dz.CrudRepository;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookUserDBRepository implements CrudRepository<BookUser, Long> {

    private static final String FIND_BOOK_USER_SQL = "select * from bookuser where book_id = ? and return_date_time IS NULL";
    private static final String FIND_BOOK_USER_ID_SQL = "select * from bookuser where book_id = ? and user_id = ?";
    private static final String INSERT_BOOK_USER_SQL =
            "insert into bookuser (book_id, user_id, from_date_time, to_date_time) values (?, ?, ?, ?)";
    private static final String DELETE_BY_ID_SQL = "delete from bookuser where id = ?";
    private static final String FIND_BY_ID = "select * from bookuser where id = ?";
    private static final String FIND_ALL = "select id, book_id, user_id, from_date_time, to_date_time, return_date_time from bookuser";

    @Override
    public Optional<BookUser> findById(final Long id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(FIND_BY_ID)) {
            ResultSet resultSet = getResultSetSQL(id, preparedStatement);
            return getBookUser(resultSet);

        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    //TODO: реализовать findByBookIdAndUserId
    public static Optional<BookUser> findByBookIdAndUserId(final Long bookId, final Long userId) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(FIND_BOOK_USER_ID_SQL)) {
            preparedStatement.setLong(1, bookId);
            preparedStatement.setLong(2, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return getBookUser(resultSet);
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    public Optional<BookUser> findByBookIdAndReturnDateTimeIsNull(final Long bookId) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(FIND_BOOK_USER_SQL)) {
            ResultSet resultSet = getResultSetSQL(bookId, preparedStatement);
            return getBookUser(resultSet);
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    private static Optional<BookUser> getBookUser(final ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            long id = resultSet.getLong("id");
            long returnBookId = resultSet.getLong("book_id");
            long returnUserId = resultSet.getLong("user_id");
            LocalDateTime fromDateTime = convertToLocalDateTime(resultSet.getTimestamp("from_date_time"));
            LocalDateTime toDateTime = convertToLocalDateTime(resultSet.getTimestamp("to_date_time"));
            LocalDateTime returnDateTime = convertToLocalDateTime(resultSet.getTimestamp("return_date_time"));

            BookUser bookUser = new BookUser(id, returnBookId, returnUserId, fromDateTime, toDateTime, returnDateTime);

            return Optional.of(bookUser);
        }
        return Optional.empty();
    }

    private static LocalDateTime convertToLocalDateTime(final Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return Instant.ofEpochMilli(timestamp.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    private ResultSet getResultSetSQL(final Long id, final PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, id);
        return preparedStatement.executeQuery();
    }

    @Override
    public BookUser save(final BookUser bookUser) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_BOOK_USER_SQL, Statement.RETURN_GENERATED_KEYS)) {

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
    }

    private Long getGeneratedKeys(final PreparedStatement preparedStatement) {
        try {
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(final Long id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_SQL)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public List<BookUser> findAll() {
        try (Connection connection = DbUtils.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            List<BookUser> result = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long book_id = resultSet.getLong("book_id");
                long user_id = resultSet.getLong("user_id");
                LocalDateTime from_date_time = convertToLocalDateViaMilisecond(resultSet.getDate("from_date_time"));
                LocalDateTime to_date_time = convertToLocalDateViaMilisecond(resultSet.getDate("to_date_time"));
                LocalDateTime return_date_time = convertToLocalDateViaMilisecond(resultSet.getDate("return_date_time"));
                BookUser bookUser = new BookUser(id, book_id, user_id, from_date_time, to_date_time, return_date_time);
                result.add(bookUser);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private LocalDateTime convertToLocalDateViaMilisecond(final Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

}
