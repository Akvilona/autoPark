/**
 * Создал Андрей Антонов 29.08.2023 7:52
 **/
package library.service;

import library.model.Book;
import library.repository.BookRepository;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void bookAdd(final Book book) {
        bookRepository.addBook(book);
    }

}
