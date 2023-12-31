/**
 * Создал Андрей Антонов 19.09.2023 15:21
 **/

package db.jdbc.library.repository.db;

import db.jdbc.library.entity.Review;
import db.jdbc.library.utils.DbUtils;
import nio.dz.CrudRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static db.jdbc.library.constant.SqlQuery.REVIEW_FIND_ALL;
import static db.jdbc.library.constant.SqlQuery.REVIEW_FIND_BY_BOOK_ID;
import static db.jdbc.library.constant.SqlQuery.REVIEW_FIND_BY_ID;
import static db.jdbc.library.constant.SqlQuery.REVIEW_INSERT_BOOK_USER_SQL;
import static db.jdbc.library.constant.SqlTable.REVIEW;

public class ReviewDbRepository implements CrudRepository<Review, Long> {
    @Override
    public Review convert(final ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        long returnBookId = resultSet.getLong("book_id");
        long returnUserId = resultSet.getLong("user_id");
        String comment = resultSet.getString("comment");
        return new Review(id, returnBookId, returnUserId, comment);
    }

    @Override
    public void delete(final Long id) {
        CrudRepository.super.delete(id);
    }

    @Override
    public String getTableName() {
        return REVIEW.getTableName();
    }

    @Override
    public Optional<Review> findById(final Long id) {
        Connection connection = DbUtils.getConnection();
        try (var preparedStatement = connection.prepareStatement(REVIEW_FIND_BY_ID.getValue())) {
            ResultSet resultSet = getresultsetsql(id, preparedStatement);
            if (resultSet.next()) {
                return Optional.of(convert(resultSet));
            }
            return Optional.empty();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public Optional<Review> findByBookId(final Long bookId) {
        Connection connection = DbUtils.getConnection();
        try (var preparedStatement = connection.prepareStatement(REVIEW_FIND_BY_BOOK_ID.getValue())) {
            ResultSet resultSet = getresultsetsql(bookId, preparedStatement);
            if (resultSet.next()) {
                return Optional.of(convert(resultSet));
            }
            return Optional.empty();

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public Review save(final Review review) {
        Connection connection = DbUtils.getConnection();
        try (var preparedStatement = connection.prepareStatement(REVIEW_INSERT_BOOK_USER_SQL.getValue(), Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, review.getBookId());
            preparedStatement.setLong(2, review.getUserId());
            preparedStatement.setString(3, review.getComment());

            preparedStatement.executeUpdate();
            review.setId(getGeneratedKeys(preparedStatement));
            connection.commit();
            return review;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }

    }

    @Override
    public List<Review> findAll() {
        Connection connection = DbUtils.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(REVIEW_FIND_ALL.getValue());
            List<Review> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(convert(resultSet));
            }
            return result;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
