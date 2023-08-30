/**
 * Создал Андрей Антонов 29.08.2023 7:05
 **/
package library.repository;

import library.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {
    private final List<Book> bookList = new ArrayList<>();

    public void addBook(final Book book) {
        bookList.add(book);
    }

    public Integer getBookId(final Book book) {
        return book.getId();
    }

    public Book getBookById(final Integer id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public Optional<Book> removeBookById(final Integer id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                bookList.remove(book);
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }
}

