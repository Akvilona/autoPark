package library.service;

import library.exception.ServiceException;
import library.entity.BookUser;
import library.repository.db.BookUserDBRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import static library.exception.ErrorCode.ERR_CODE_02;
import static library.exception.ErrorCode.ERR_CODE_03;

@RequiredArgsConstructor
public class BookUserService {

    private final BookService bookService;
    private final UserService userService;
    private final BookUserDBRepository bookUserDBRepository;

    public BookUser bookIssue(final Long userId, final Long bookId) throws ServiceException {
        if (!userService.exist(userId)) {
            throw new ServiceException(ERR_CODE_02, userId);
        }

        if (!bookService.exist(bookId)) {
            throw new ServiceException(ERR_CODE_03, bookId);
        }

        BookUser bookUser = bookUserDBRepository.findByBookIdAndUserId(bookId, userId).orElse(
                new BookUser(bookId, userId, LocalDateTime.now(), LocalDateTime.now().plusMonths(1)));
        bookUserDBRepository.save(bookUser);
        return bookUser;
    }

    public BookUser returnBook(final Long bookId) {
        if (!bookService.exist(bookId)) {
            throw new ServiceException(ERR_CODE_03, bookId);
        }

        BookUser bookUser = bookUserDBRepository.findByBookIdAndReturnDateTimeIsNull(bookId).orElseThrow();
        bookUser.setReturnDateTime(LocalDateTime.now());
        bookUserDBRepository.save(bookUser);
        return bookUser;
    }

}
