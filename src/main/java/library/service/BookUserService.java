/**
 * Создал Андрей Антонов 05.09.2023 7:28
 **/
package library.service;

import library.exception.ErrorCode;
import library.exception.ServiceException;
import library.model.BookUser;
import library.repository.db.BookUserDBRepository;

import java.time.LocalDateTime;

public class BookUserService {

    private final BookService bookService;
    private final UserService userService;
    private final BookUserDBRepository bookUserDBRepository;

    public BookUserService(final BookService bookService,
                           final UserService userService,
                           final BookUserDBRepository bookUserDBRepository) {
        this.bookService = bookService;
        this.userService = userService;
        this.bookUserDBRepository = bookUserDBRepository;
    }

    public BookUser bookIssue(final Long userId, final Long bookId) {
        if (!userService.exist(userId)) {
            throw new ServiceException(ErrorCode.ERR_CODE_02, userId);
        }

        if (!bookService.exist(bookId)) {
            throw new ServiceException(ErrorCode.ERR_CODE_03, bookId);
        }

        if (bookUserDBRepository.findByBookIdAndReturnDateTimeIsNull(bookId).isPresent()) {
            throw new ServiceException(ErrorCode.ERR_CODE_01, bookId);
        }

        BookUser bookUser = new BookUser(bookId, userId, LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
        bookUserDBRepository.save(bookUser);
        return bookUser;
    }

    public BookUser returnBook(final Long bookId) {
        if (!bookService.exist(bookId)) {
            throw new ServiceException(ErrorCode.ERR_CODE_03, bookId);
        }

        //TODO: При возврате обновлять колонку ReturnDateTime текущим временем
        BookUser bookUser = bookUserDBRepository.findById(bookId).orElseThrow();
        bookUser.setReturnDateTime(LocalDateTime.now());
        return bookUser;
    }

    public boolean exist(final Long bookId, final Long userId) {
        return BookUserDBRepository.findByBookIdAndUserId(bookId, userId)
                .isPresent();
    }

}
