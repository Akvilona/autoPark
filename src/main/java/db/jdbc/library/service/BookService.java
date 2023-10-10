package db.jdbc.library.service;

import db.jdbc.library.entity.Book;
import db.jdbc.library.exception.ErrorCode;
import db.jdbc.library.exception.ServiceException;
import db.jdbc.library.repository.db.BookDbRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BookService {
    private final BookDbRepository dbRepository;

    public Book save(final Book book) {
        return dbRepository.save(book);
    }

    public List<Book> findAll() {
        return dbRepository.findAll();
    }

    public boolean exist(final Long bookId) {
        return dbRepository.findById(bookId).isPresent();
    }

    public Book findById(final Long bookId) {
        return dbRepository.findById(bookId)
                .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_03));
    }

    public void deleteById(final Long id) {
        dbRepository.delete(id);
    }

}
