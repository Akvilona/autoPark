/**
 * Создал Андрей Антонов 29.08.2023 7:52
 **/
package library.service;

import library.model.Book;
import library.repository.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(final Book book) {
        bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public boolean exist(final Long bookId) {
        return bookRepository.findById(bookId).isPresent();
    }

    public Book findById(final Long bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    public void deleteById(final Long id) {
        bookRepository.delete(id);
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

}
