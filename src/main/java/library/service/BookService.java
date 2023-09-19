package library.service;

import library.exception.ErrorCode;
import library.exception.ServiceException;
import library.model.Book;
import library.repository.db.BookDBRepository;

import java.util.List;

public class BookService {
    private final BookDBRepository  bookDBRepository;

    public BookService(final BookDBRepository bookDBRepository) {
        this.bookDBRepository = bookDBRepository;
    }

    public void save(final Book book) {
        bookDBRepository.save(book);
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
