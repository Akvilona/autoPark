/**
 * Создал Андрей Антонов 19.09.2023 15:21
 **/
package library.repository.db;

import library.entity.Review;
import library.utils.DbUtils;
import nio.dz.CrudRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewDBRepository implements CrudRepository<Review, Long> {
    @Override
    public Review convert(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public String getTableName() {
        return null;
    }

    private static final String INSERT_BOOK_USER_SQL = "insert into review (book_id, user_id, comment) values (?, ?, ?)";
    private static final String FIND_BOOK_USER_SQL = "select * from review where book_id = ?";
    private static final String FIND_BOOK_USER_ID_SQL = "select * from review where book_id = ? and user_id = ?";
    private static final String DELETE_BY_ID_SQL = "delete from review where id = ?";
    private static final String FIND_BY_ID = "select * from review where id = ?";
    private static final String FIND_BY_BOOK_ID = "select * from review where book_id = ?";
    private static final String FIND_ALL = "select * from review";

    @Override
    public Optional<Review> findById(Long id) {
        Connection connection = DbUtils.getConnection();
        try (var preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            ResultSet resultSet = getResultSetSQL(id, preparedStatement);
            if (resultSet.next()) {
                return Optional.of(getReview(resultSet));
            }
            return Optional.empty();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    public Optional<Review> findByBookId(Long bookId) {
        Connection connection = DbUtils.getConnection();
        try (var preparedStatement = connection.prepareStatement(FIND_BY_BOOK_ID)) {
            ResultSet resultSet = getResultSetSQL(bookId, preparedStatement);
            if (resultSet.next()) {
                return Optional.of(getReview(resultSet));
            }
            return Optional.empty();

        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public Review save(Review review) {
        Connection connection = DbUtils.getConnection();
        try (var preparedStatement = connection.prepareStatement(INSERT_BOOK_USER_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, review.getBookId());
            preparedStatement.setLong(2, review.getUserId());
            preparedStatement.setString(3, review.getComment());

            preparedStatement.executeUpdate();
            review.setId(getGeneratedKeys(preparedStatement));
            connection.commit();
            return review;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Long id) {
        Connection connection = DbUtils.getConnection();
        try (var preparedStatement = connection.prepareStatement(DELETE_BY_ID_SQL)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public List<Review> findAll() {
        Connection connection = DbUtils.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            List<Review> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(getReview(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Review getReview(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        long returnBookId = resultSet.getLong("book_id");
        long returnUserId = resultSet.getLong("user_id");
        String comment = resultSet.getString("comment");
        return new Review(id, returnBookId, returnUserId, comment);
    }

}
