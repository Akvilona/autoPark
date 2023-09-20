/**
 * Создал Андрей Антонов 19.09.2023 15:21
 **/
package library.repository.db;

import library.model.Review;
import library.utils.DbUtils;
import nio.dz.CrudRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewDBRepository implements CrudRepository<Review, Long> {
    private static final String INSERT_BOOK_USER_SQL = "insert into review (book_id, user_id, comment) values (?, ?, ?)";
    private static final String FIND_BOOK_USER_SQL = "select * from review where book_id = ?";
    private static final String FIND_BOOK_USER_ID_SQL = "select * from review where book_id = ? and user_id = ?";
    private static final String DELETE_BY_ID_SQL = "delete from review where id = ?";
    private static final String FIND_BY_ID = "select * from review where id = ?";
    private static final String FIND_BY_BOOK_ID = "select * from review where book_id = ?";
    private static final String FIND_ALL = "select * from review";

    @Override
    public Optional<Review> findById(Long id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(FIND_BY_ID)) {
            ResultSet resultSet = getResultSetSQL(id, preparedStatement);
            return getReview(resultSet);

        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    public Optional<Review> findByBookId(Long bookId) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(FIND_BY_BOOK_ID)) {
            ResultSet resultSet = getResultSetSQL(bookId, preparedStatement);
            return getReview(resultSet);

        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }

    @Override
    public Review save(Review review) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_BOOK_USER_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, review.getBookId());
            preparedStatement.setLong(2, review.getUserId());
            preparedStatement.setString(3,review.getComment());

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
    public List<Review> findAll() {
        try (Connection connection = DbUtils.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            List<Review> result = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long book_id = resultSet.getLong("book_id");
                long user_id = resultSet.getLong("user_id");
                String comment = resultSet.getString("comment");
                Review review = new Review(id, book_id, user_id, comment);
                result.add(review);
            }
            return result;
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

    private static Optional<Review> getReview(final ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            long id = resultSet.getLong("id");
            long returnBookId = resultSet.getLong("book_id");
            long returnUserId = resultSet.getLong("user_id");
            String comment = resultSet.getString("comment");
            Review review = new Review(id, returnBookId, returnUserId, comment);

            return Optional.of(review);
        }
        return Optional.empty();
    }

    private ResultSet getResultSetSQL(final Long id, final PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, id);
        return preparedStatement.executeQuery();
    }

}
