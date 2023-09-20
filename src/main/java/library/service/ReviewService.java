/**
 * Создал Андрей Антонов 08.09.2023 16:06
 **/
package library.service;

import library.exception.ErrorCode;
import library.exception.ServiceException;
import library.model.Review;
import library.repository.db.ReviewDBRepository;

import java.util.List;

public class ReviewService {

    private final ReviewDBRepository reviewDBRepository;

    public ReviewService(ReviewDBRepository reviewDBRepository) {
        this.reviewDBRepository = reviewDBRepository;
    }

    public Review save(Review review){
        if (reviewDBRepository.findByBookId(review.getBookId()).isEmpty()) {
            throw new ServiceException(ErrorCode.ERR_CODE_03, review.getBookId());
        }

        return reviewDBRepository.save(review);
    }

    public void delete(final Long id) {
        reviewDBRepository.delete(id);
    }

    public Review findById(final Long id) {
        return reviewDBRepository.findById(id)
                .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_02, id));
    }

    public boolean exist(final Long id) {
        return reviewDBRepository.findById(id)
                .isPresent();
    }

    public List<Review> findAll() {
        return reviewDBRepository.findAll();
    }


}
