/**
 * Создал Андрей Антонов 08.09.2023 15:15
 **/

package db.jdbc.library.repository.list;

import db.jdbc.library.entity.Review;
import nio.dz.CrudRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static db.jdbc.library.constant.SqlTable.REVIEW;

public class ReviewRepository implements CrudRepository<Review, Long> {

    private final List<Review> reviews = new ArrayList<>();

    @Override
    public Review convert(final ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public Long getGeneratedKeys(final PreparedStatement preparedStatement) {
        return CrudRepository.super.getGeneratedKeys(preparedStatement);
    }

    @Override
    public String getTableName() {
        return REVIEW.getTableName();
    }

    @Override
    public Optional<Review> findById(final Long id) {

        for (Review review : reviews) {
            if (review.getId().equals(id)) {

                return Optional.of(review);
            }
        }
        return Optional.empty();
    }

    @Override
    public Review save(final Review review) {
        reviews.add(review);
        return review;
    }

    @Override
    public void delete(final Long id) {
        reviews.removeIf(review -> review.getId().equals(id));
    }

    @Override
    public List<Review> findAll() {
        return reviews;
    }
}
