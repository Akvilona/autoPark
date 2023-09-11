/**
 * Создал Андрей Антонов 05.09.2023 7:28
 **/
package library.service;

import library.exception.ErrorCode;
import library.exception.ServiceException;
import library.model.BookUser;
import library.repository.BookUserRepository;

import java.time.LocalDateTime;

public class LibraryService {

    private final BookService bookService;
    private final UserService userService;
    private final BookUserRepository bookUserRepository;

    public LibraryService(final BookService bookService,
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

        if (bookUserRepository.findByBookIdAndReturnDateTimeIsNull(bookId).isPresent()) {
            throw new ServiceException(ErrorCode.ERR_CODE_01, bookId);
        }

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
}
