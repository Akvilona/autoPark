/**
 * Создал Андрей Антонов 08.09.2023 16:06
 **/

package db.jdbc.library.service;

import db.jdbc.library.entity.Review;
import db.jdbc.library.exception.ErrorCode;
import db.jdbc.library.exception.ServiceException;
import db.jdbc.library.repository.db.ReviewDbRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReviewService {

    private final ReviewDbRepository dbRepository;

    public Review save(final Review review) {
        if (dbRepository.findByBookId(review.getBookId()).isEmpty()) {
            throw new ServiceException(ErrorCode.ERR_CODE_03, review.getBookId());
        }

        return dbRepository.save(review);
    }

    public void delete(final Long id) {
        dbRepository.delete(id);
    }

    public Review findById(final Long id) {
        return dbRepository.findById(id)
                .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_02, id));
    }

    public boolean exist(final Long id) {
        return dbRepository.findById(id)
                .isPresent();
    }

    public List<Review> findAll() {
        return dbRepository.findAll();
    }

}
