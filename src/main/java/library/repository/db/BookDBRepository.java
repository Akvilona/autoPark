/**
 * Создал Андрей Антонов 18.09.2023 9:47
 **/
package library.repository.db;

import library.entity.Book;
import library.utils.DateTimeUtils;
import library.utils.DbUtils;
import nio.dz.CrudRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDBRepository implements CrudRepository<Book, Long> {

    //TODO: вынести в енам
    //TODO сделать реализацию интерфейса CrudRepository во всех репозиториях (реализовать методы интерфейса)
    //TODO: cделать delete общим методом как findById

    @Override
    public Book convert(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public String getTableName() {
        return null;
    }

    private static final String SELECT_FROM_BOOK_WHERE_ID = "SELECT * FROM book WHERE id = ?";
    private static final String SELECT_FROM_BOOK = "SELECT * FROM book";
    private static final String INSERT_INTO_BOOK = "INSERT INTO book (name, dateOfIssue) VALUES (?, ?)";
    private static final String DELETE_FROM_BOOK_WHERE_ID = "DELETE FROM book WHERE id = ?";

    @Override
    public Optional<Book> findById(final Long id) {
        Connection connection = DbUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_BOOK_WHERE_ID)) {
            ResultSet resultSet = getResultSetSQL(id, preparedStatement);
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("dateofissue");
                LocalDate dateOfIssue = DateTimeUtils.convertToLocalDate(date);
                Book book = new Book(id, name, dateOfIssue);
                return Optional.of(book);
            }
            return Optional.empty();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public Book save(final Book book) {
        Connection connection = DbUtils.getConnection();
        try (PreparedStatement preparedStatement =
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
        Connection connection = DbUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_BOOK_WHERE_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public List<Book> findAll() {
        Connection connection = DbUtils.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_BOOK);
            List<Book> result = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("dateofissue");
                LocalDate dateOfIssue = DateTimeUtils.convertToLocalDate(date);
                Book book = new Book(id, name, dateOfIssue);
                result.add(book);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
