package library.repository;

import library.model.BookUser;
import nio.dz.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookUserRepository implements CrudRepository<BookUser, Long> {
    private final List<BookUser> bookUserList = new ArrayList<>();

    @Override
    public Optional<BookUser> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(final BookUser bookUser) {
        bookUserList.add(bookUser);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<BookUser> findAll() {
        return bookUserList;
    }

    public Optional<BookUser> findByBookIdAndReturnDateTimeIsNull(final Long bookId) {
        return bookUserList.stream()
                .filter(bookUser -> bookUser.getBookId().equals(bookId))
                .filter(bookUser -> bookUser.getReturnDateTime() == null)
                .findFirst();
    }
}
