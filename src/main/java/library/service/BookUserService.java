/**
 * Создал Андрей Антонов 05.09.2023 7:28
 **/
package library.service;

import library.exception.ErrorCode;
import library.exception.ServiceException;
import library.model.BookUser;
import library.repository.BookUserRepository;

import java.time.LocalDateTime;

public class BookUserService {

    private final BookService bookService;
    private final UserService userService;
    private final BookUserRepository bookUserRepository;

    public BookUserService(final BookService bookService,
                           final UserService userService,
                           final BookUserRepository bookUserRepository) {
        this.bookService = bookService;
        this.userService = userService;
        this.bookUserRepository = bookUserRepository;
    }

    public BookUser bookIssue(final Long userId, final Long bookId) {
        if (!userService.exist(userId)) {
            throw new ServiceException(ErrorCode.ERR_CODE_02, userId);
        }

        if (!bookService.exist(bookId)) {
            throw new ServiceException(ErrorCode.ERR_CODE_03, bookId);
        }

        //TODO: refactor with sql findByBookIdAndReturnDateTimeIsNull (BookUserDBRepository.class)
        if (bookUserRepository.findByBookIdAndReturnDateTimeIsNull(bookId).isPresent()) {
            throw new ServiceException(ErrorCode.ERR_CODE_01, bookId);
        }

        //TODO: refactor with sql insertBookUser (BookUserDBRepository.class)
        BookUser bookUser = new BookUser(bookId, userId, LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
        bookUserRepository.save(bookUser);

        return bookUser;
    }

    public BookUser returnBook(final Long bookId) {
        if (!bookService.exist(bookId)) {
            throw new ServiceException(ErrorCode.ERR_CODE_03, bookId);
        }

        BookUser bookUser = bookUserRepository.findByBookId(bookId).orElseThrow();
        bookUser.setReturnDateTime(LocalDateTime.now());
        return bookUser;
    }

    public boolean exist(final Long bookId, final Long userId) {
        return bookUserRepository.findByBookIdAndUserId(bookId, userId)
                .isPresent();
    }

}
