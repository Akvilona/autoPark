/**
 * Создал Андрей Антонов 18.09.2023 9:47
 **/
package library.repository.db;

import library.model.Book;
import library.utils.DbUtils;
import nio.dz.CrudRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDBRepository implements CrudRepository<Book, Long> {

    private static final String SELECT_FROM_BOOK_WHERE_ID = "SELECT * FROM book WHERE id = ?";
    private static final String SELECT_FROM_BOOK = "SELECT * FROM book";
    private static final String INSERT_INTO_BOOK = "INSERT INTO book (name, dateOfIssue) VALUES (?, ?)";
    private static final String DELETE_FROM_BOOK_WHERE_ID = "DELETE FROM book WHERE id = ?";

    @Override
    public Optional<Book> findById(Long id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(SELECT_FROM_BOOK_WHERE_ID)) {
            ResultSet resultSet = getResultSetSQL(id, preparedStatement);
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("dateofissue");
                LocalDate dateOfIssue = convertToLocalDateViaMilisecond(date);
                Book book = new Book(id, name, dateOfIssue);
                return Optional.of(book);
            }
            return Optional.empty();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public Book save(Book book) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_INTO_BOOK, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setDate(2, Date.valueOf(book.getDateOfIssue()));
            preparedStatement.executeUpdate();
            book.setId(getGeneratedKeys(preparedStatement));
            connection.commit();
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(final Long id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_BOOK_WHERE_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public List<Book> findAll() {
        try (Connection connection = DbUtils.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_BOOK);
            List<Book> result = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("dateofissue");
                LocalDate dateOfIssue = convertToLocalDateViaMilisecond(date);
                Book book = new Book(id, name, dateOfIssue);
                result.add(book);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    private ResultSet getResultSetSQL(Long id, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, id);
        return preparedStatement.executeQuery();
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
}
