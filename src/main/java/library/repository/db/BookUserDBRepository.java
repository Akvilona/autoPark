package library.repository.db;

import library.model.BookUser;
import library.utils.DbUtils;
import nio.dz.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

public class BookUserDBRepository implements CrudRepository<BookUser, Long> {

    private static final String findBookUserSQL = "select * from bookuser where book_id = ? and return_date_time IS NULL";
    private static final String insertBookUserSQL =
            "insert into bookuser (book_id, user_id, from_date_time, to_date_time) values (?, ?, ?, ?)";

    //TODO: реализовать findByBookIdAndUserId
    public static Optional<BookUser> findByBookIdAndUserId(Long bookId, Long userId) {
        return null;
    }

    public Optional<BookUser> findByBookIdAndReturnDateTimeIsNull(Long bookId) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(findBookUserSQL)) {
            ResultSet resultSet = getResultSetSQL(bookId, preparedStatement);
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
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    private LocalDateTime convertToLocalDateTime(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return Instant.ofEpochMilli(timestamp.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    private ResultSet getResultSetSQL(Long id, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, id);
        return preparedStatement.executeQuery();
    }

    @Override
    public Optional<BookUser> findById(Long id) {
        return Optional.empty();
    }


    @Override
    public BookUser save(BookUser bookUser) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(insertBookUserSQL, Statement.RETURN_GENERATED_KEYS)) {

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
    public void delete(Long id) {

    }

    @Override
    public List<BookUser> findAll() {
        return null;
    }
}
