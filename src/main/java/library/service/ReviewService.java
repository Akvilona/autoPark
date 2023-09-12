/**
 * Создал Андрей Антонов 08.09.2023 16:06
 **/
package library.service;

import library.exception.ErrorCode;
import library.exception.ServiceException;
import library.model.Review;
import library.repository.ReviewRepository;

public class ReviewService {
    private final UserService userService;
    private final BookUserService bookUserService;
    private final ReviewRepository reviewRepository;

    public ReviewService(final UserService userService, final BookUserService bookUserService, final ReviewRepository reviewRepository) {
        this.userService = userService;
        this.bookUserService = bookUserService;
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(final Long userId, final Long bookId, final String commentUser) {
        if (!userService.exist(userId)) {
            throw new ServiceException(ErrorCode.ERR_CODE_02, userId);
        }
        if (!bookUserService.exist(bookId, userId)) {
            throw new ServiceException(ErrorCode.ERR_CODE_04, bookId);
        }

        Review review1 = new Review(bookId, userId, commentUser);
        reviewRepository.save(review1);
        return review1;
    }
}
