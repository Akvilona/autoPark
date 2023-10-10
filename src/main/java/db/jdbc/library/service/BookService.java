package db.jdbc.library.service;

import db.jdbc.library.exception.ErrorCode;
import db.jdbc.library.exception.ServiceException;
import db.jdbc.library.entity.Book;
import db.jdbc.library.repository.db.BookDBRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BookService {
    private final BookDBRepository  bookDBRepository;

    public Book save(final Book book) {
        return bookDBRepository.save(book);
    }

    public List<Book> findAll() {
        return bookDBRepository.findAll();
    }

    public boolean exist(final Long bookId) {
        return bookDBRepository.findById(bookId).isPresent();
    }

    public Book findById(final Long bookId) {
        return bookDBRepository.findById(bookId)
                .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_03));
    }

    public void deleteById(final Long id) {
        bookDBRepository.delete(id);
    }

}
