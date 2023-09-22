package library.repository.db;

import library.model.BookUser;
import library.service.BookService;
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

public class BookUserDBRepository implements CrudRepository<BookUser, Long> {

    private static final String FIND_BOOK_USER_SQL = "select * from bookuser where book_id = ? and return_date_time IS NULL";
    private static final String FIND_BOOK_USER_ID_SQL = "select * from bookuser where book_id = ? and user_id = ?";
    private static final String INSERT_BOOK_USER_SQL =
            "insert into bookuser (book_id, user_id, from_date_time, to_date_time) values (?, ?, ?, ?)";
    private static final String UPDATE_BOOK_USER_SQL =
            "update bookuser set return_date_time = ? where id = ?";
    private static final String DELETE_BY_ID_SQL = "delete from bookuser where id = ?";
    private static final String FIND_BY_ID = "select * from bookuser where id = ?";
    private static final String FIND_ALL = "select id, book_id, user_id, from_date_time, to_date_time, return_date_time from bookuser";

    public Optional<BookUser> findByBookIdAndUserId(final Long bookId, final Long userId) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BOOK_USER_ID_SQL)) {
            preparedStatement.setLong(1, bookId);
            preparedStatement.setLong(2, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getUser(resultSet));
            }
            return Optional.empty();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public Optional<BookUser> findById(final Long id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(FIND_BY_ID)) {
            ResultSet resultSet = getResultSetSQL(id, preparedStatement);
            if (resultSet.next()) {
                return Optional.of(getUser(resultSet));
            }
            return Optional.empty();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    public Optional<BookUser> findByBookIdAndReturnDateTimeIsNull(final Long bookId) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(FIND_BOOK_USER_SQL)) {
            ResultSet resultSet = getResultSetSQL(bookId, preparedStatement);
            if (resultSet.next()) {
                return Optional.of(getUser(resultSet));
            }
            return Optional.empty();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public BookUser save(final BookUser bookUser) {

        if (findById(bookUser.getId()).isEmpty()){      // INSERT
            try (Connection connection = DbUtils.getConnection();

                 PreparedStatement preparedStatement =
                         connection.prepareStatement(INSERT_BOOK_USER_SQL, Statement.RETURN_GENERATED_KEYS)){

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
        } else {                                        // UPDATE
            try (Connection connection = DbUtils.getConnection();

                 PreparedStatement preparedStatement =
                         connection.prepareStatement(UPDATE_BOOK_USER_SQL)){

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
                result.add(getUser(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private BookUser getUser(final ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        long bookId = resultSet.getLong("book_id");
        long userId = resultSet.getLong("user_id");
        LocalDateTime fromDateTime = DateTimeUtils.convertToLocalDateTime(resultSet.getDate("from_date_time"));
        LocalDateTime toDateTime = DateTimeUtils.convertToLocalDateTime(resultSet.getDate("to_date_time"));
        LocalDateTime returnDateTime = DateTimeUtils.convertToLocalDateTime(resultSet.getDate("return_date_time"));
        return new BookUser(id, bookId, userId, fromDateTime, toDateTime, returnDateTime);
    }

}
