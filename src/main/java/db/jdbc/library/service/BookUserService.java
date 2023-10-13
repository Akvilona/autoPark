package db.jdbc.library.service;

import db.jdbc.library.entity.BookUser;
import db.jdbc.library.exception.ServiceException;
import db.jdbc.library.repository.db.BookUserDbRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import static db.jdbc.library.exception.ErrorCode.ERR_CODE_02;
import static db.jdbc.library.exception.ErrorCode.ERR_CODE_03;

@RequiredArgsConstructor
public class BookUserService {

    private final BookService bookService;
    private final UserService userService;
    private final BookUserDbRepository dbRepository;

    public BookUser bookIssue(final Long userId, final Long bookId) throws ServiceException {
        if (!userService.exist(userId)) {
            throw new ServiceException(ERR_CODE_02, userId);
        }

        if (!bookService.exist(bookId)) {
            throw new ServiceException(ERR_CODE_03, bookId);
        }

        BookUser bookUser = dbRepository.findByBookIdAndUserId(bookId, userId).orElse(
                new BookUser(bookId, userId, LocalDateTime.now(), LocalDateTime.now().plusMonths(1)));
        dbRepository.save(bookUser);
        return bookUser;
    }

    public BookUser returnBook(final Long bookId) {
        if (!bookService.exist(bookId)) {
            throw new ServiceException(ERR_CODE_03, bookId);
        }

        BookUser bookUser = dbRepository.findByBookIdAndReturnDateTimeIsNull(bookId).orElseThrow();
        bookUser.setReturnDateTime(LocalDateTime.now());
        dbRepository.save(bookUser);
        return bookUser;
    }
}
