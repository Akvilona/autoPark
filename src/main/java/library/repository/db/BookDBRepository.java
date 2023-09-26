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

import static library.constant.SqlQuery.BOOK_SELECT_FROM_BOOK_WHERE_ID;
import static library.constant.SqlQuery.BOOK_INSERT_INTO_BOOK;
import static library.constant.SqlQuery.BOOK_SELECT_FROM_BOOK;
import static library.constant.SqlTable.BOOK;

public class BookDBRepository implements CrudRepository<Book, Long> {

    //сделано TODO: вынести в енам
    //TODO сделать реализацию интерфейса CrudRepository во всех репозиториях (реализовать методы интерфейса)
    //TODO: cделать delete общим методом как findById

    @Override
    public Book convert(final ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        Date date = resultSet.getDate("dateofissue");
        LocalDate dateOfIssue = DateTimeUtils.convertToLocalDate(date);
        Book book = new Book(id, name, dateOfIssue);
        return book;
    }

    @Override
    public String getTableName() {
        return BOOK.getTableName();
    }

    @Override
    public Optional<Book> findById(final Long id) {
        Connection connection = DbUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(BOOK_SELECT_FROM_BOOK_WHERE_ID.getValue())) {
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
                     connection.prepareStatement(BOOK_INSERT_INTO_BOOK.getValue(), Statement.RETURN_GENERATED_KEYS)) {
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

/*
    @Override
    public void delete(final Long id) {
        Connection connection = DbUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(BOOK_DELETE_FROM_BOOK_WHERE_ID.getValue())) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }
*/

    @Override
    public List<Book> findAll() {
        Connection connection = DbUtils.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(BOOK_SELECT_FROM_BOOK.getValue());
            List<Book> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(convert(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
