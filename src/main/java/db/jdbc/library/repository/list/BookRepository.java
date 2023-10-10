/**
 * Создал Андрей Антонов 29.08.2023 7:05
 **/
package db.jdbc.library.repository.list;

import db.jdbc.library.entity.Book;
import nio.dz.CrudRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static db.jdbc.library.constant.SqlTable.BOOK;

public class BookRepository implements CrudRepository<Book, Long> {

    @Override
    public Book convert(final ResultSet resultSet) throws SQLException {
        return new Book("new book", LocalDate.now());
    }

    @Override
    public String getTableName() {
        return BOOK.getTableName();
    }

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
