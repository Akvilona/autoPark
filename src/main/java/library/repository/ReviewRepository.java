/**
 * Создал Андрей Антонов 08.09.2023 15:15
 **/
package library.repository;

import library.model.Review;
import nio.dz.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewRepository implements CrudRepository<Review, Long> {

    private final List<Review> reviews = new ArrayList<>();

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
