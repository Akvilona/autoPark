/**
 * Создал Андрей Антонов 29.08.2023 7:05
 **/
package library.repository.list;

import library.model.Book;
import nio.dz.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository implements CrudRepository<Book, Long> {
    private final List<Book> bookList = new ArrayList<>();

    @Override
    public Optional<Book> findById(final Long id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public Book save(final Book book) {
        bookList.add(book);
        return book;
    }

    @Override
    public void delete(final Long id) {
        bookList.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public List<Book> findAll() {
        return bookList;
    }

}
