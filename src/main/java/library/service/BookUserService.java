package library.service;

import library.exception.ErrorCode;
import library.exception.ServiceException;
import library.model.BookUser;
import library.repository.db.BookUserDBRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class BookUserService {

    private final BookService bookService;
    private final UserService userService;
    private final BookUserDBRepository bookUserDBRepository;

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

        //TODO: Реализрвать update с помощью метода save, если запись есть, то обновляем, если нет, то создаем
        BookUser bookUser = bookUserDBRepository.findByBookIdAndReturnDateTimeIsNull(bookId).orElseThrow();
        bookUser.setReturnDateTime(LocalDateTime.now());
        bookUserDBRepository.save(bookUser);
        return bookUser;
    }

}
